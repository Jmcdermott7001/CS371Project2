/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;
import Database.*;
import javax.swing.JFrame;

/**
 *
 * @author JM049812
 */

public class Main {
    
    
    public static void main(String[] args){
        DatabaseManager DB=new DatabaseManager();
        try{
           DB.connect("root","Football4","127.0.0.1","3306","mysql");
            JFrame UserLogin=new UserLogin(DB);
            UserLogin.setVisible(true);
        }
        catch(Exception e){
            
        }
    }
}