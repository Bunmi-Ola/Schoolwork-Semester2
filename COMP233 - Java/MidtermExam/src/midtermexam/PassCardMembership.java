/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermexam;

import java.util.Calendar;

/**
 *
 * @author olanrewaju4401
 */
public class PassCardMembership extends MemberShip{
    
     private int numberOfVisitsRemaining;
     
   public PassCardMembership() {}
    
    public PassCardMembership(int memberNumber, Date birthDate, String name, int numberOfVisitsRemaining){
       
        super.setMemberNumber(memberNumber);
        super.setMemberBirthDate(birthDate);
        super.setMemberName(name);
        setNumberOfVisitsRemaining(numberOfVisitsRemaining);
      
   } 

    /**
     * @return the numberOfVisitsRemaining
     */
    public int getNumberOfVisitsRemaining() {
        return numberOfVisitsRemaining;
    }

    /**
     * @param numberOfVisitsRemaining the numberOfVisitsRemaining to set
     */
    public void setNumberOfVisitsRemaining(int visits) {
        
         if (visits == 12 || visits == 15 || visits == 20){
             this.numberOfVisitsRemaining = visits;
         }
         else{
            System.out.println("Invalid Number");
            this.numberOfVisitsRemaining = 0;
        }
        
    }
   
    public String  checkIn(Date todaysDate){
        
         String info = "";
      
     
      
        if ((getMemberBirthDate() != todaysDate) && getNumberOfVisitsRemaining() >20 ){
          
            info = "Approved";
        }
        
        if ( (getMemberBirthDate() != todaysDate) && getNumberOfVisitsRemaining() < 3 ){
          
            info = "Approved: You may wish to buy a new pass";
        }
        if ( (getMemberBirthDate() == todaysDate) && getNumberOfVisitsRemaining() !=0 ){
          
            info = "Approved: Happy Birthday, today is on us!";
        }
        if ( getNumberOfVisitsRemaining() <=0 ){
          
            info = "Declined: Card expired";
        } 
        
        return info;
    }
    
    public String writeAsRecord(){
        
      String member = 'P' +" ";
      member+= getMemberNumber()+" ";
      member+= getMemberBirthDate() +" ";
      member+= getMemberName() + " ";      
      member+= getNumberOfVisitsRemaining() +"\n"; 
      return member; 
        
    }
}
