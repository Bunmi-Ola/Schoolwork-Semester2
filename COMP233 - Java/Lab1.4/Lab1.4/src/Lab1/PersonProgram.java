package Lab1;


import java.util.Scanner;

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
    public static void main(String[] args) {
        // TODO code application logic here
        
        Person [] people = new Person [] {};        
        Scanner input = new Scanner(System.in);
        
               
        PersonFileHandler PP = new PersonFileHandler ();
        
        people = PP.getData("X:\\Sem 2\\233PersonTestData.txt");
        
        int choice = 0;   
        while(choice !=4){          
           
        System.out.println("Pick an option between 1 - 4:");
        System.out.println("1. Display all names");
        System.out.println("2. Display info for person by number");
        System.out.println("3. Edit information for person by number");
        System.out.println("4. Exit");
        System.out.print("choice:");
        choice = input.nextInt();        
        System.out.println("-------------------------------------------------");
        
         if (choice >0 && choice < 5){
             
           if (choice==1) {   
           for (int  i =0; i < people.length; i++) {
            
            System.out.println(people[i].getFullName());
           }
        System.out.println("-------------------------------------------------");   
        }    
          
          if (choice == 2){
              
            int viewinfo;   
            do {
            System.out.println("Pick a number to show which person details to display");
            System.out.println("1. John");
            System.out.println("2. Sue");
            System.out.println("3. Marg");
            System.out.println("4. Beth");
            System.out.println("5. Jake");  
            System.out.println("6. Alice");  
            System.out.println("7. JMike");  
            System.out.print("Number: ");
            viewinfo = input.nextInt();
            
        System.out.println("-------------------------------------------------");   
           if (viewinfo >= 1 && viewinfo <=7){           
                        
            if ( viewinfo >= 1 || viewinfo <= people.length+1){
                System.out.println(people[viewinfo-1].toString());
            }           
         }       
            else  {
            System.out.print("Invalid Option. ");        
            }
        }
        while (viewinfo < 1 || viewinfo > people.length+1);
       }
        
        if (choice == 3){
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
           while (editinfo < 1 || editinfo > 5);
            
            }   
        if (choice == 4){
            System.out.println("Exit");
        }
            }
        
        else System.out.print("Invalid menu option is selected. ");
        }
       
    }
          

 public static void boundaryValues  (String menuPrompt, int lowerbound, int upperbound){      
        
        for (int number = lowerbound; number <= upperbound; ++number) {
            
                   System.out.println(number );
            }
 }
}