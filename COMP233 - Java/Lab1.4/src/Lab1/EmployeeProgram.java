/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author olanrewaju4401
 */

public class EmployeeProgram {
      Scanner input = new Scanner(System.in);
    
    static Employee[] employees;
    
    
     public void getData() {
         
         employees = new Employee[5];
         
        employees[0] = new Employee("John", "Smith", 'T', new Date(6,24,80), 
                                100101, 2789.0f, new Date(5,22,2000));
                                
        employees [1] = new Employee ("Jones", "Sue ", 'A', new Date (9,23,1980),
                                100102, 1550.0f, new Date (1,1,2015));
        
        employees [2] = new Employee ("Williams", "Marg", 'C', new Date (1,1,2019),
                                100103, 2000.0f, new Date (06,25,1992 ));
        
        employees [3] = new Employee ("Davies", "Beth", 'D', new Date (2,15,2014),
                                100104, 3650.0f, new Date (10,24,2006));
        
        employees [4] = new Employee ("Stewart", "Jake", 'A', new Date (6,30,2005),
                                100105, 10200.0f, new Date (6,12,2015));  
     }
     public void GetData(String FileName) {
         PersonFileHandler PP = new PersonFileHandler ();
        
        employees = PP.getData(FileName);
     }
     public int showMenu(){
         
      int choice = 0;   
      System.out.print("\n"
     + "Menu Option\n"
     + " 1. Display all employees\n"
     + " 2. Display info for employee by list number\n"
     + " 3. Display info for employee by employee number\n"
     + " 4. Edit info for employee by employee number\n"
     + " 5. Exit\n"
     + " Please make a selection:\n");
     
      choice = input.nextInt();  
     
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
              SaveAll("X:\\Sem 2\\233EmployeeTestData.txt");
        }
        rangeCheck(choice, 1, 5);
    }
      public void menuOption1() {
            System.out.println(employees[0].getEmployeeNo() + ": "+ employees[0].getFullName());
            System.out.println(employees[1].getEmployeeNo()+ ": " + employees[1].getFullName());
            System.out.println(employees[2].getEmployeeNo()+ ": " + employees[2].getFullName());
            System.out.println(employees[3].getEmployeeNo()+ ": " + employees[3].getFullName());
            System.out.println(employees[4].getEmployeeNo()+ ": " + employees[4].getFullName());
            System.out.println("-------------------------------------------------");   
        }
      
      public void menuOption2() {
          
        int arraynumber = 0;
            do {              
                          
            System.out.println("Pick an array number between 0 & 4 to show employee details");
           
             System.out.print("arraynumber: ");
             arraynumber = input.nextInt();    
            if ( arraynumber >= 0 && arraynumber <= 4){
            System.out.println(employees[arraynumber].toString());
           
            System.out.println("-------------------------------------------------");   
              
             }
            else  {
            System.out.println("Invalid Number");        
            }
            }
             while (arraynumber < 0 || arraynumber > 4);
      }
        
       public void menuOption3() {
           
         int viewinfo=0;   
            do {
            System.out.println("Give an employee number to show which employee details to display");
             
            System.out.print("Number: ");
            viewinfo = input.nextInt();
        System.out.println("-------------------------------------------------");
         if ( viewinfo >= employees[0].getEmployeeNo() && viewinfo <=employees[4].getEmployeeNo()){
             
              if ( viewinfo >= employees[0].getEmployeeNo() || viewinfo <=employees[4].getEmployeeNo()){
                
                for (int i = 0; i <=4; i++){
                    
                 if (employees[i].getEmployeeNo()== viewinfo) {
                 System.out.println(employees[i].toString()); 
                      
                  }
            } 
        }
         }    
            else  {
            System.out.println("Record not found.");        
            }
        }
        while (viewinfo < employees[0].getEmployeeNo()|| viewinfo > employees[4].getEmployeeNo() );
       } 
       
       public void menuOption4() {
          int editinfo;
          String editemployee="";
            
            do {
            System.out.println("Give an employee number to show which employee details to edit");
           
            editinfo = input.nextInt();
            
            if (editinfo ==employees[0].getEmployeeNo()){editemployee = employees[0].getFullName();}
            if (editinfo ==employees[1].getEmployeeNo()){editemployee = employees[1].getFullName();}
            if (editinfo ==employees[2].getEmployeeNo()){editemployee = employees[2].getFullName();}
            if (editinfo ==employees[3].getEmployeeNo()){editemployee = employees[3].getFullName();}
            if (editinfo ==employees[4].getEmployeeNo()){editemployee = employees[4].getFullName();}
            
             if (editinfo >= employees[0].getEmployeeNo() && editinfo <= employees[4].getEmployeeNo()){ 
               
            System.out.println(editemployee + "\n" + ": What info do you wants to edit");
             System.out.println("1. Employee Number");
            System.out.println("2. First Name");
            System.out.println("3. Last Name");
            System.out.println("4. Middle Initial");
            System.out.println("5. Monthly Salary");
            System.out.println("6. Birth Date"); 
             System.out.println("7. Hire Date");
            System.out.println("8. Exit");
            System.out.print("Number: ");
            int Choice;
            Choice = input.nextInt();
           
            if (editinfo >= employees[0].getEmployeeNo() || editinfo <= employees[4].getEmployeeNo()){ 
            if (Choice == 1){
                 System.out.print("\nEnter new Employee Number ");
                 int newempNumber = input.nextInt();
                 for (int i = 0; i <=4; i++){                    
                 if (employees[i].getEmployeeNo()== editinfo) {  
                employees[i].setEmployeeNo(newempNumber);
                System.out.println(employees[i].toString());
                 }
                }
            }    
                
            if (Choice == 2){
                 System.out.print("\nEnter new First name: ");
                 String newfirstname = input.next();
                 for (int i = 0; i <=4; i++){                    
                 if (employees[i].getEmployeeNo()== editinfo) {  
                employees[i].setFirstname(newfirstname);
                System.out.println(employees[i].toString());
                 }
                }
            }    
                if (Choice == 3){
                System.out.print("\nEnter new Last name: ");
                String newlasttname = input.next();
                 for (int i = 0; i <=4; i++){     
                     
                   if (employees[i].getEmployeeNo()== editinfo) {  
                    employees[i].setLastname(newlasttname);
                 System.out.println(employees[i].toString());
                   }
                }
                }
                
                if (Choice == 4){
                System.out.print("\nEnter new Middle Initial: ");
                char newMiddlelnit = input.next().charAt(0);
                for (int i = 0; i <=4; i++){    
                    
                 if (employees[i].getEmployeeNo()== editinfo) {  
                employees[i].setMiddlelnit(newMiddlelnit);
                System.out.println(employees[i].toString());
                }
                }
                }
                if (Choice == 5){
                 System.out.print("\nEnter new Monthly Salary: ");
                 int newMonthlySalary = input.nextInt();
                 for (int i = 0; i <=4; i++){                    
                 if (employees[i].getEmployeeNo()== editinfo) {  
                employees[i].setMonthlySalary(newMonthlySalary);
                System.out.println(employees[i].toString());
                 }
                }
            }    
                
                if (Choice == 6){
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
                
                 for (int i = 0; i <=4; i++){                    
                 if (employees[i].getEmployeeNo()== editinfo) {  
                employees[i].setBirthdate(newDate);
                System.out.println(employees[i].toString());
                }
                 }
                }
                
                if (Choice == 7){
                int month = 0; 
                int day = 0;
                int year = 0;
                
                System.out.println("Enter the month Hire date ");    
                month = input.nextInt();
                System.out.println("Enter the day Hire date ");    
                day = input.nextInt();
                System.out.println("Enter the year Hire date ");    
                year = input.nextInt();   
                Date newDate = new Date(month, day, year);
                
                 for (int i = 0; i <=4; i++){                    
                 if (employees[i].getEmployeeNo()== editinfo) {  
                employees[i].setHireDate(newDate);
                System.out.println(employees[i].toString());
                }
                 }
                }
                
                if (Choice == 8){
                System.out.println("Exit");
                }
            }
             }
           else  {
            System.out.println("Record not found ");  
            }
            }
           while (editinfo < employees[0].getEmployeeNo() || editinfo > employees[4].getEmployeeNo() );
            
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
               writer.println(employees.length);
              for (int i = 0; i < employees.length; i++) {                
             
              writer.println("" + employees[i].writeAsRecord());
              }
              writer.close();
               } 
              catch (IOException ex) {
              Logger.getLogger(EmployeeProgram.class.getName()).log(Level.SEVERE, null, ex);         
               
               }  
              
       }
}
    
 