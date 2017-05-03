/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author typhene
 */
/*public class Advertisements {
    private String Advertisement_ID;
    private String AdvTitle;
    private String AdvDetails;
    private String AdvDateTime;
    private String Price;
    private String User_ID;
    private String Moderator_ID;
    private String Category_ID;
    private String Status_ID;
    
    
    public Advertisements(String Advertisement_ID, String AdvTitle, String AdvDetails, String AdvDateTime, 
            String Price, String User_ID, String Moderator_ID, String Category_ID, String Status_ID){
        this.Advertisement_ID=Advertisement_ID;
        this.AdvTitle = AdvTitle;
        this.AdvDetails = AdvDetails;
        this.AdvDateTime = AdvDateTime;
        this.Price = Price;
        this.User_ID = User_ID;
        this.Moderator_ID = Moderator_ID;
        this.Category_ID = Category_ID;
        this.Status_ID = Status_ID;
    }

    Advertisements(String title, String description, String price, String date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getID(){
        return Advertisement_ID;
    }
    
    public String getTitle(){
       return AdvTitle;
    }
    
    public String getDetails(){
        return AdvDetails;
    }
    
    public String getDate(){
        return AdvDateTime;
    }
    
    public String getPrice(){
        return Price;
    }
    
    public String getUserID(){
        return User_ID;
    }
    
    public String getModID(){
        return Moderator_ID;
    }
    public String getCatID(){
        return Category_ID;
    }
    public String getStatID(){
        return Status_ID;
    }
    
    Object[] toArray(){
        return new Object[]{Advertisement_ID, AdvTitle, AdvDetails, AdvDateTime, 
            Price, User_ID, Moderator_ID, Category_ID, Status_ID};
    }   
    
}*/
public class Advertisements {
    
   
    private String Title;
    private String Description;
    private String Price;
    private String Date;
    
    public Advertisements(String Title,String Description,String Price,String Date){
        this.Title=Title;
        this.Description=Description;
        this.Price=Price;
        this.Date=Date;
        
    }
    
    public String getTitle(){
        return Title;
    }
    
    public String getDescription(){
        return Description;
    }
    
    public String getPrice(){
        return Price;
    }
    
    public String getDate(){
        return Date;
    }
    
    
    Object[] toArray(){
        return new Object[]{Title,Description,Price,Date};
    }   
}     
    