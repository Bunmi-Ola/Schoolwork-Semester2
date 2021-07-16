/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermexam;



import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author olanrewaju4401
 */
public class ClientProgram {
    
    Scanner input = new Scanner(System.in);
    
    static MemberShip[] members;   
     
    public void GetData(String FileName) {
        PersonFileHandler PP = new PersonFileHandler ();
        members = PP.getData(FileName);
              
     }
    
    public int showMenu(){
         
      int choice = 0;   
      System.out.print("\n"
     + "Menu Option\n"
     + " 1. Display all members, sorted by membership numbers, highest to lowest\n"
     + " 2. Find client number by client name \n"
     + " 3. Check in a client by membership number\n"
     + " 4. Display pass card accounts with 0 passes left \n"
     + " 5. Charge a tab \n"
     + " 6. Exit the program\n"         
     + " Please make a selection:\n");
     
      choice = input.nextInt();  
     
      return choice;
    }
    public void executeChoices(int choice) {

        if (choice == 1) {            
            menuOption1();
        }
        
         if (choice == 2) {        
            menuOption2();
        }
         if (choice == 3) {        
            menuOption3();
        }
         if (choice == 4) {        
            menuOption4();
        }
         if (choice == 5) {        
             menuOption5();
        }
        
         if (choice == 6) {        
            System.out.println("End of Program");
        }
        rangeCheck(choice, 1, 6);
    }
    
    public int rangeCheck(int UserInput, int min, int max) {
        do {
            if (min > UserInput || max < UserInput) {
                System.out.println("Invalid entry. Please enter a number between " + min + " and " + max);
                break;
            }

        } while (min > UserInput || max < UserInput);
        return UserInput;

    }
    
    public void menuOption1() {
        System.out.println("Member Number" + "\t" + "Member Name"+ "\t" + "Birthdate Date");
        System.out.println("------------------------------------------------------");
         Arrays.sort(members);
          for (int i = 0; i <members.length; i++){
            System.out.println(members[i].toString());
          }
              System.out.println("-------------------------------------------------");
        }
    
     public void menuOption2() {
         
         String clientName = " ";
         String errorOutput = " ";
       System.out.println("Please provide client name to check client number");
             clientName = input.next();
      
          for (int i = 0; i <members.length; i++){
              
              if (members[i].getMemberName().equals(clientName)){
                  
            System.out.println("The Client number is" + " " +members[i].getMemberNumber());
          }
            else  errorOutput = "Invalid Name";
        }
        System.out.println(errorOutput);            
        System.out.println("-------------------------------------------------");
     }
     
      public void menuOption3() {
         
         int clientNumber = 0;
       System.out.println("Please provide client number");
             clientNumber = input.nextInt();
             Date Today = new Date(2, 26, 2019);
            
          for (int i = 0; i <members.length; i++){
              
               if (members[i] instanceof PassCardMembership) {  
                      if ( ((PassCardMembership)members[i]).getMemberNumber()== clientNumber)
                  {
                    members[i].checkIn(Today);
                    System.out.println("Checking in " + members[i].getMemberName());   
                   }  
             }
               
              if (members[i] instanceof AnnualMemberShip) {  
                      if ( ((AnnualMemberShip)members[i]).getMemberNumber()== clientNumber)
                  {
                    members[i].checkIn(Today);
                    System.out.println("Checking in " + members[i].getMemberName());   
                       
                   }  
             } 
            
        }
        System.out.println("-------------------------------------------------");
     }
      
      
      public void menuOption4() {
         
       System.out.println("Pass Card Accounts with 0:" );
         for (int i = 0; i < members.length; i++) {
             if ((members[i] instanceof PassCardMembership)&&(((PassCardMembership)members[i]).getNumberOfVisitsRemaining() == 0))
                     {
                         System.out.println(""+members[i].toString());                
             }
             }          
             
        System.out.println("-------------------------------------------------");
     }
     
       public void menuOption5() {
           
            int clientNumber = 0;
            int chargeAmount = 0;
       System.out.println("Please select a membership number");
             clientNumber = input.nextInt();
         String errorMessage = " ";
       for (int i = 0; i <members.length; i++){
              
             if ( members[i].getMemberNumber()== clientNumber && members[i] instanceof AnnualMemberShip){
                  
                         System.out.println("Please prodive the charge Amount");   
                          chargeAmount = input.nextInt();
                          ((AnnualMemberShip)members[i]).addToTab(chargeAmount);
                               }
             
             else errorMessage = "Invalid number";
             }          
        saveData ("X:\\Sem 2\\MTTestData.txt");   
         System.out.println("Charge Added");
          System.out.println(errorMessage);
        System.out.println("-------------------------------------------------");
     }
      
          public void saveData (String FileName) {
         
             //the file writer allow you to make adjustment to a file. the false is to allow its to accept to write over
             //print writer is t
              
          try {
               FileWriter fw = new FileWriter(FileName, false);
         
               PrintWriter writer = new PrintWriter(fw);
               writer.println(members.length);
              for (int i = 0; i < members.length; i++) {                
             if (members[i] instanceof AnnualMemberShip){
              writer.println("" + ((AnnualMemberShip)members[i]).writeAsRecord());
              }
              if (members[i] instanceof PassCardMembership){
              writer.println("" + ((PassCardMembership)members[i]).writeAsRecord());
              }
              }
              writer.close();
               } 
              catch (IOException ex) {
              Logger.getLogger(ClientProgram.class.getName()).log(Level.SEVERE, null, ex);         
               
               }  
              
       }
      
}
