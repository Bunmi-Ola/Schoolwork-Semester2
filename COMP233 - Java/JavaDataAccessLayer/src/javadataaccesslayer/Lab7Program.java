/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadataaccesslayer;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.*;


/**
 *
 * @author olanrewaju4401
 */
public class Lab7Program {
    
    Scanner input = new Scanner(System.in);
    
    public int showMenu(){
         
      int choice = 0;   
      System.out.print("\n"
     + "Menu Option\n"
     + " 1. Display Job IDs, descriptions and pay rates.\n"
     + " 2. Display employee IDs, first name, last name, and job description\n"
     + " 3. Add a Job\n"
     + " 4. Edit a job by list number(using a sub menu to determine whether description or rate is being edited)\n"
     + " 5. Edit a job by list number(using a sub menu to determine whether description or rate is being edited)\n"
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
             Job.getAllJobsAsList();
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
        
          String sql = "Select JOBCODE, DESCRIPTION, PAYRATE from JOB";
          
          executeQuery(sql);
              System.out.println("-------------------------------------------------");
        }
    
     public void menuOption2() {
         
        String sql = 
    "Select EMPLOYEE.EMPID, EMPLOYEE.FIRSTNAME, EMPLOYEE.LASTNAME, JOB.DESCRIPTION from EMPLOYEE INNER JOIN JOB ON EMPLOYEE.JOBCODE = JOB.JOBCODE";
          
          executeQuery(sql);
              System.out.println("-------------------------------------------------");
     }
     
      public void menuOption3() {
       String jobdescription;
       
   System.out.println("Please enter the JobCode");
   int Jobcode = input.nextInt();
    
    System.out.println("Please enter the Job description");
      jobdescription =  input.next();
      
    input.nextLine();
    
    System.out.println("Please enter the PayRate");
    float payrate = input.nextFloat();
     
    System.out.println("Please enter the Job Type");
    String PAYTYPE = input.next();    
      
   String newJob = "INSERT INTO JOB(JOBCODE, DESCRIPTION, PAYRATE, PAYTYPE)" + 
                 "VALUES("+Jobcode+",'"+jobdescription+"',"+payrate+",'"+PAYTYPE+"')";
           
          Connection conn=null;

//(Just catch exception e for now)
try{

DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());

  conn = DriverManager.getConnection
("jdbc:oracle:thin:@bisoracle.siast.sk.ca:1521:ACAD",     "cistu020", "bekind"); //your username and password here

   Statement s = conn.createStatement();
   s.executeUpdate(newJob);
 
      conn.close();
 }
catch(SQLException sqle){
	
        System.out.println("A SQL error has occurred.");
	System.out.println(sqle.toString());

    }
catch(Exception E){
	System.out.println("Unknown error has occurred.");
System.out.println("Exception!"+E);	
		
}
    System.out.println("New Job Added");
      }
      
 public void menuOption5() {
     
     Employee.getAllEmployeeAsList();
     
     System.out.println("Enter the employee index number to be edited");
            int index = input.nextInt();
     
        System.out.print("\n"
                    + "What Info do you want to edit\n"
                    + " 1. First Name\n"   
                    + " 2. Last Name\n"
                    + " 3. Job description\n"          
                    + " Please make a selection:\n");
        
         int choice = input.nextInt();
         
         if (choice == 1){
            
            Employee.changeFirstName(index);
         }
        if (choice == 2){
            Employee.changeLastName(index);
         }
        
        if (choice == 3){
            Employee.changeJobCode(index);
         }
          
 }
      
 
  public static void executeQuery (String sql){
    
    Statement stmt=null; 
        ResultSet rset=null; 
        ResultSetMetaData rsmd=null;
          Connection conn=null;

         
//(Just catch exception e for now)
try{

DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());

  conn = DriverManager.getConnection ("jdbc:oracle:thin:@bisoracle.siast.sk.ca:1521:ACAD",     "cistu020", "bekind"); //your username and password here

  
  stmt = conn.createStatement();
  rset = stmt.executeQuery (sql);
   
  rsmd = rset.getMetaData();
  
   
  
  int columnCount = rsmd.getColumnCount();
  int recordNum = 1;
  
  //the ==true isnt necessary
  while (rset.next() == true){
      System.out.print(recordNum);
      recordNum++;
      for(int i = 0; i <columnCount; i++){
          System.out.print(" "+ rset.getString(i+1));
      }
      System.out.println("\n===============");
  }
  
}
catch(SQLException sqle){
	
        System.out.println("A SQL error has occurred.");
	System.out.println(sqle.toString());

    }
catch(Exception E){
	System.out.println("Unknown error has occurred.");
System.out.println("Exception!"+E);	
		
}

finally{
            try
            {
		rset.close();
		stmt.close();
		conn.close();
            }
            catch(Exception E)
            {
                    System.out.println("Warning.");
                    System.out.println("Failed to free up system resources");
            }

        }
    }

    
}


