/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

/**
 *
 * @author kuhail
 */
public class DatabaseManager {
    Connection connection;
    
        public class Record{
        public String ID;
        public String Name;
        
        public Record(String ID,String Name){
            this.ID=ID;
            this.Name=Name;
        }
        
        public String toString(){
            return Name;
        }
    }
        
 
    public void connect(String userName, String password, String serverName, String portNumber, String dbName) throws SQLException, InstantiationException, IllegalAccessException {
        System.out.println("Loading driver...");

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", userName);
        connectionProps.put("password", password);

        conn = DriverManager.getConnection(
                "jdbc:mysql://"
                + serverName
                + ":" + portNumber + "/" + dbName,
                connectionProps);

        System.out.println("Connected to database");
        this.connection=conn;
    }
    
    public Object[][] getAdvertisement(String user_id,String text) {
        PreparedStatement stmt = null;
        Object[][] result=new Object[][]{};
        
        String query = "SELECT AdvTitle, AdvDetails, Price, AdvDateTime FROM Advertisements WHERE Status_ID = 'AC' and User_ID = ?";

        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1,user_id); //binding the parameter with the given string
            stmt.setString(2,"%"+text+"%");
            stmt.setString(3,"%"+text+"%");
            ResultSet rs = stmt.executeQuery();
            int count = getResultSetSize(rs);
            result=getAdData(count,rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return result;
        }
        return result;
    }   
    
   public Object[][] getAdvertisement(String user_id) {
        PreparedStatement stmt = null;
        Object[][] result=new Object[][]{};
        
        String query = "SELECT AdvTitle, AdvDetails, Price, AdvDateTime FROM Advertisements WHERE Status_ID = 'AC' and User_ID = ?";

        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1,user_id); //binding the parameter with the given string
            ResultSet rs = stmt.executeQuery();
            int count = getResultSetSize(rs);
            result=getAdData(count,rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return result;
        }
        return result;
    }
   
       private Object[][] getAdData(int count,ResultSet rs) throws SQLException {
        Object[][] result=new Object[count][4];
        int index=0;
       do {
            String title = rs.getString("AdvTitle");
            String description = rs.getString("AdvDetails");
            String price = rs.getString("Price");
            String date = rs.getString("AdvDateTime");

            Advertisements advertisement=new Advertisements(title,description,price,date);
            result[index++]=advertisement.toArray();
        }
       while(rs.next());
        return result;
    } 
    
  public boolean checkUser(String User_id) {
        PreparedStatement stmt = null;
        
        String query = "select * FROM users WHERE User_ID=?";
                
        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1,User_id); //binding the parameter with the given string
            ResultSet rs = stmt.executeQuery();
            int count = getResultSetSize(rs);
            if (count == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }
  
   public boolean checkModerator(String User_id) {
        PreparedStatement stmt = null;
        
        String query = "select * FROM moderators WHERE User_ID=?";
                
        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1,User_id); //binding the parameter with the given string
            ResultSet rs = stmt.executeQuery();
            int count = getResultSetSize(rs);
            if (count == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }

  
  private int getResultSetSize(ResultSet rs) {
        int count = 0;
        try {
            while (rs.next()) {
                count++;
            }
            rs.first();
        } catch (SQLException e) {

        }
        return count;
    }
}
