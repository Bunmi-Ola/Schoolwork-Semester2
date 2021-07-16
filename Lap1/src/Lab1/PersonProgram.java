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
        
        Scanner input = new Scanner(System.in);
        int choice = 0;
       
        Person People [] = new Person [5];
        People [0] = new Person ("Smith", "John", 'T', new Date (11, 7, 1990));
        People [1] = new Person ("Jones", "Sue ", 'A', new Date (9,23,1980));
        People [2] = new Person ("Williams", "Marg", 'C', new Date (1,1,2019));
        People [3] = new Person ("Davies", "Beth", 'D', new Date (2,30,2014));
        People [4] = new Person ("Stewart", "Jake", 'A', new Date (6,30,2005));

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
       
        if (choice == 1){
            System.out.println("1. "+ People[0].getFullName());
            System.out.println("2. "+ People[1].getFullName());
            System.out.println("3. "+ People[2].getFullName());
            System.out.println("4. "+ People[3].getFullName());
            System.out.println("5. "+ People[4].getFullName());
        System.out.println("-------------------------------------------------");   
        }
        
        if (choice == 2){
            int viewinfo;   
            do {
            System.out.println("Pick a number to show which person details to display");
            System.out.println("1. Smith");
            System.out.println("2. Jones");
            System.out.println("3. Williams");
            System.out.println("4. Davies");
            System.out.println("5. Stewart");           
            System.out.print("Number: ");
            viewinfo = input.nextInt();
        System.out.println("-------------------------------------------------");
            
        if (viewinfo >= 1 && viewinfo <=5){        
                        
            if ( viewinfo == 1 || viewinfo == 2 || viewinfo == 3 || viewinfo == 4 || viewinfo == 5){
                System.out.println(People[viewinfo-1].toString());
            }           
         }       
            else  {
            System.out.print("Invalid Option. ");        
            }
        }
        while (viewinfo < 1 || viewinfo > 5);
       }
        
        if (choice == 3){
            int editinfo;
            
            do {
            System.out.println("Pick a number to show which person details to edit");
            System.out.println("1. Smith");
            System.out.println("2. Jones");
            System.out.println("3. Williams");
            System.out.println("4. Davies");
            System.out.println("5. Stewart");
            System.out.print("Number: ");
            editinfo = input.nextInt();
            
            if (editinfo >= 1 && editinfo <=5){     
            System.out.println("What info do you wants to edit");
            System.out.println("1. First Name");
            System.out.println("2. Last Name");
            System.out.println("3. Middle Initial");
            System.out.println("4. Birth Date");
            System.out.println("5. Cancel");
            System.out.print("Number: ");
            int Choice;
            Choice = input.nextInt();
                        
            if (editinfo == 1 || editinfo == 2 || editinfo == 3 || editinfo == 4 || editinfo == 5){
                if (Choice == 1){
                System.out.print("\nEnter new First name: ");
                People[editinfo-1].setFirstname(input.next());
                System.out.println(People[editinfo-1].toString());
                }
                if (Choice == 2){
                System.out.print("\nEnter new Last name: ");
                People[editinfo-1].setLastname(input.next());
                System.out.println(People[editinfo-1].toString());
                }
                if (Choice == 3){
                System.out.print("\nEnter new Middle Initial: ");
                People[editinfo-1].setMiddlelnit(input.next().charAt(0));
                System.out.println(People[editinfo-1].toString());
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
                
                People[editinfo-1].setBirthdate(newDate);
                System.out.println(People[editinfo-1].toString());
                }
                
                if (Choice == 5){
                System.out.println("Exit");
                }
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
        else System.out.print("Invalid menu option is selected ");
      }
       
    }
          

 public static void boundaryValues  (String menuPrompt, int lowerbound, int upperbound){      
        
        for (int number = lowerbound; number <= upperbound; ++number) {
            
                   System.out.println(number );
            }
 }
}