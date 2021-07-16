/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

import static Lab1.EmployeeProgram.employees;
import java.util.Scanner;

/**
 *
 * @author olanrewaju4401
 */
public class PayrollReporter {
    static abstractEmployee[] employees;
    
       public static void main(String[] args) {
          
          Scanner input = new Scanner(System.in);
            
          employees = new abstractEmployee[10];
		
employees[0] = new SalaryEmployee("John", "Smith", 'T', new Date(6,24,80), 100101, 1, 12, 2894.54f);

employees[1] = new SalaryEmployee("Sue", "Jones", 'A', new Date(4,13,84), 100102, 1, 15, 3110.0f);

employees[2] = new HourlyEmployee("Marg", "Williams", 'C', new Date(1,28,70), 100103, 3, 15, 25.0f,81f);

employees[3] = new SalaryEmployee("Beth", "Davies", 'D', new Date(2,3,76), 200101, 3, 15, 2843.5f);

employees[4] = new SalaryEmployee("Jake", "Stewart", 'A', new Date(9,18,68), 100201, 1, 0, 2999.0f);

employees[5] = new HourlyEmployee("Alice", "McWilliams", 'F', new Date(10,9,80), 300203, 1, 0, 27.0f, 88f);
		
employees[6] = new HourlyEmployee("Mike", "Klauss", 'M', new Date(12,12,76), 300213, 2, 0, 30.0f, 80f);
		
employees[7] = new HourlyEmployee("Samuelle", "Chau", 'D', new Date(8,23,86), 400213, 2, 12, 22.0f, 85f);

employees[8] = new HourlyEmployee("Mitch", "Flynn", 'A', new Date(7,28,78), 990223, 3, 15, 100.0f, 80f);

employees[9] = new SalaryEmployee("Andrea", "Bouchard", 'S', new Date(3,20,85), 400023, 3, 12, 3900.0f);
		

     int choice = 0;   
        while(choice !=7){          
           
        System.out.println("Main menu:");
        System.out.println("1. Display all earnings for employees");
        System.out.println("2. Display all earnings for a project number");
        System.out.println("3. Display all earnings for a department number");
        System.out.println("4. Display wage costs for all projects");
        System.out.println("5. Display wage costs for all departments");
        System.out.println("6. Display overtimes expenses");
        System.out.println("7. Exit");
        System.out.print("choice:");
        choice = input.nextInt();        
        System.out.println("-------------------------------------------------");
        
        if (choice >0 && choice <= 6){
       
          if (choice == 1){
              
          for (int i = 0; i < employees.length; i++){
            System.out.println(employees[i].getEmployeeNo() + ": "+ employees[i].getFullName()
            +employees[i].getEarnings());
          }  
        System.out.println("-------------------------------------------------");   
        }
        
        if (choice == 2){
           int projectNumber = 0;
              do {
           System.out.println("Enter a project number:");
           System.out.println("Project Number:");
           projectNumber = input.nextInt();    
        
        if ( projectNumber == 0  || projectNumber == 12 || projectNumber == 15){             
               
          for (int i = 0; i < employees.length; i++){
               if (employees[i].getProjectNo()== projectNumber) {
                
            System.out.println(employees[i].getEmployeeNo() + ": "+ employees[i].getFullName()
            +employees[i].getEarnings());
          }
          }
        System.out.println("-------------------------------------------------");
        }
         else {
            System.out.println("Record not found.");        
            }
        }
              while (projectNumber != 0  && projectNumber != 12 && projectNumber != 15 );
            
       }
        if (choice == 3){
           int departmentNumber = 0;
              do {
           System.out.println("Enter a department number:");
           System.out.println("Department Number:");
           departmentNumber = input.nextInt();    
        
        if ( departmentNumber == 1  || departmentNumber == 2 || departmentNumber == 3){             
               
          for (int i = 0; i < employees.length; i++){
               if (employees[i].getDepartmentNo() == departmentNumber) {
                
            System.out.println(employees[i].getEmployeeNo() + ": "+ employees[i].getFullName()
            +employees[i].getEarnings());
          }
          }
        System.out.println("-------------------------------------------------");
        }
         else {
            System.out.println("Record not found.");        
            }
        }
              while (departmentNumber != 1  && departmentNumber != 2 && departmentNumber != 3 );
            
       }
        
        if (choice == 4){
            int wageCosts1= 0;
             int wageCosts2 = 0;
              int wageCosts3 = 0;
            for (int i = 0; i < employees.length; i++){
             if (employees[i].getProjectNo() == 0) {            
            wageCosts1 += employees[i].getEarnings();
              
          } 
               if (employees[i].getProjectNo() == 12) {            
            wageCosts2 += employees[i].getEarnings();
           
          } 
               if (employees[i].getProjectNo() == 15) {            
            wageCosts3 += employees[i].getEarnings();
              
          } 
             
            }
        System.out.println("Project 0: "+ wageCosts1);
        System.out.println("Project 12: "+ wageCosts2);
        System.out.println("Project 15: "+ wageCosts3);
        }
        
          if (choice == 5){
            int wageCosts1 = 0;
            int wageCosts2 = 0;
            int wageCosts3 = 0;
            for (int i = 0; i < employees.length; i++){
             if (employees[i].getDepartmentNo() == 1) {            
            wageCosts1 += employees[i].getEarnings();
              
          } 
               if (employees[i].getDepartmentNo() == 2) {            
            wageCosts2 += employees[i].getEarnings();
           
          } 
               if (employees[i].getDepartmentNo() == 3) {            
            wageCosts3 += employees[i].getEarnings();
              
          } 
             
            }
        System.out.println("Department 1: "+ wageCosts1);
        System.out.println("Department 2: "+ wageCosts2);
        System.out.println("Department3: "+ wageCosts3);
        }
       if (choice == 6){
         
       for (int i = 0; i < employees.length; i++){
       if (employees[i] instanceof HourlyEmployee){    
           
        if (((HourlyEmployee)employees[i]).getHoursWorked()> 80){
            
      System.out.println( employees[i].getEmployeeNo() + ": "+ employees[i].getFullName()+
        (((HourlyEmployee)employees[i]).getHoursWorked()-80) + "\t" +
       ((((HourlyEmployee)employees[i]).getHoursWorked()-80) *
      (((HourlyEmployee)employees[i]).getHourlyRate())* 1.5f) );
       
                }
             
            }
       }                     
        }

        }
        if (choice == 7){            
         System.out.println("Exit");   
        }
                 
       }
        }    
}





