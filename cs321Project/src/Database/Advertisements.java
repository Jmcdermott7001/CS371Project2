/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author JM049812
 */
public class Advertisements {
    
    private String Advertisement_ID;
    private String User_ID;
    private String User_name;
    private String Title;
    private String Title_Description;
    private String Price;
    private String Date;
    private String Status;
    private String Type;
    
    public Advertisements(String Title,String Title_Description,String Price,String Date){
        this.Title=Title;
        this.Title_Description=Title_Description;
        this.Price=Price;
        this.Date=Date;
        
    }
    
    public String getTitle(){
        return Title;
    }
    
    public String getTitle_Description(){
        return Title_Description;
    }
    
    public String getPrice(){
        return Price;
    }
    
    public String getDate(){
        return Date;
    }
    
    public String getStatus(){
        return Status;
    }
    
    public String getType(){
        return Type;
    }
    
    Object[] toArray(){
        return new Object[]{Title,Title_Description,Price,Date};
    }   
} 
