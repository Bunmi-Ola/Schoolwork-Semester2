package Lab1;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Favour
 */
public class PersonProgram {

    /**
     * @param args the command line arguments
     */
   
        
        Person [] people = new Person [] {};        
        Scanner input = new Scanner(System.in);
        
        public void GetData(String FileName) {
         
        PersonFileHandler PP = new PersonFileHandler ();
        people = PP.getData(FileName);
     }
               
      public int showMenu(){
         
      int choice = 0;   
      System.out.println("Pick an option between 1 - 4:");
        System.out.println("1. Display all names");
        System.out.println("2. Display info for person by number");
        System.out.println("3. Edit information for person by number");
        System.out.println("4. Add new employee");
        System.out.println("5. Exit");
        System.out.print("choice:");
        choice = input.nextInt();       
        System.out.println("-------------------------------------------------"); 
      return choice;
    }          
      public void executeChoices(int choice) {

        if (choice == 1) {
            menuOption1();
        }
        else if (choice == 2) {
            menuOption2();
        }
        else if (choice == 3) {
            menuOption3();
        }
        else if (choice == 4) {
            menuOption4();
        }
        else if (choice == 5) {
            SaveAll("X:\\Sem 2\\233PersonTestData.txt");
             System.out.println("Exit");
        }
        
        rangeCheck(choice, 1,5);
    }
       public void menuOption1() {
          for (int i = 0; i <people.length; i++){
            System.out.println(i+1 + " " +people[i].getFullName());          
            System.out.println("-------------------------------------------------");
          }              
        }  
        public void menuOption2() {
          
        int arraynumber = 0;
            do {        
            System.out.println("Pick an array number to show employee details");
             System.out.print("arraynumber: ");
             arraynumber = input.nextInt();    
            if ( arraynumber >= 0 && arraynumber < people.length){
            System.out.println(people[arraynumber].toString());           
            System.out.println("-------------------------------------------------");               
             }
            
            else  {
            System.out.println("Invalid Number");        
            }
          }
             while (arraynumber < 0 || arraynumber >= people.length);
      }
        public void menuOption3() {
         
            int editinfo;            
            do {
            System.out.println("Pick a number to show which person details to edit");
            System.out.println("1. John");
            System.out.println("2. Sue");
            System.out.println("3. Marg");
            System.out.println("4. Beth");
            System.out.println("5. Jake");  
            System.out.println("6. Alice");  
            System.out.println("7. JMike");  
            System.out.print("Number: ");
            editinfo = input.nextInt();
            
            if (editinfo >= 1 && editinfo <= people.length){     
            System.out.println("What info do you wants to edit");
            System.out.println("1. First Name");
            System.out.println("2. Last Name");
            System.out.println("3. Middle Initial");
            System.out.println("4. Birth Date");
            System.out.println("5. Cancel");
            System.out.print("Number: ");
            int Choice;
            Choice = input.nextInt();
                        
            if (Choice == 1){
                    
                System.out.print("\nEnter new First name: ");
                people[editinfo-1].setFirstname(input.next());
                System.out.println(people[editinfo-1].toString());
                }
                if (Choice == 2){
                System.out.print("\nEnter new Last name: ");
                people[editinfo-1].setLastname(input.next());
                System.out.println(people[editinfo-1].toString());
                }
                if (Choice == 3){
                System.out.print("\nEnter new Middle Initial: ");
                people[editinfo-1].setMiddlelnit(input.next().charAt(0));
                System.out.println(people[editinfo-1].toString());
                }
                if (Choice == 4){
                int month = 0; 
                int day = 0;
                int year = 0;
                
                System.out.println("Enter the month birthdate ");    
                month = input.nextInt();
                System.out.println("Enter the day birthdate ");    
                day = input.nextInt();
                System.out.println("Enter the year birthdate ");    
                year = input.nextInt();   
                Date newDate = new Date(month, day, year);
                
                people[editinfo-1].setBirthdate(newDate);
                System.out.println(people[editinfo-1].toString());
                }
                
                if (Choice == 5){
                System.out.println("Exit");
                }
            }
           else  {
            System.out.print("Invalid option. ");  
            }
         }
           while (editinfo < 1 || editinfo > people.length);
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
 
  public void SaveAll (String FileName) {
         
             //the file writer allow you to make adjustment to a file. the false is to allow its to accept to write over
             //print writer is t
              
          try {
               FileWriter fw = new FileWriter(FileName, false);
         
               PrintWriter writer = new PrintWriter(fw);
               writer.println(people.length);
              for (int i = 0; i < people.length; i++) {                
             
              writer.println("" + people[i].writeAsRecord());
              }
              writer.close();
               } 
              catch (IOException ex) {
              Logger.getLogger(PersonProgram.class.getName()).log(Level.SEVERE, null, ex);         
               
               }
  }
   public void menuOption4() {
             Person[] newEmployee = new Person[1];
            
                System.out.print("\nEnter new First name: ");
                String newfirstname = input.next();
                 
                System.out.print("\nEnter new Last name: ");
                String newlasttname = input.next();
                
                System.out.print("\nEnter new Middle Initial: ");
                char newMiddlelnit = input.next().charAt(0);
                
                System.out.println("Enter the month birthdate ");    
                int birmonth = input.nextInt();
                System.out.println("Enter the day birthdate ");    
                int birday = input.nextInt();
                System.out.println("Enter the year birthdate ");    
                int biryear = input.nextInt();   
                Date newbirthDate = new Date(birmonth, birday, biryear);
                
                newEmployee[0] = new Person (newfirstname, newlasttname, newMiddlelnit,newbirthDate);
                
                Person[] tempPeople = new Person[people.length+1];
                System.arraycopy(people, 0, tempPeople, 0, people.length);
                System.arraycopy(newEmployee, 0, tempPeople, people.length, newEmployee.length); 
                people = tempPeople;
                SaveAll("X:\\Sem 2\\233EmployeeTestData.txt");
                
                   }
          
}