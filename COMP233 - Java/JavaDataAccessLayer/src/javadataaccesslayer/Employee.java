/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadataaccesslayer;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/**
 *
 * @author olanrewaju4401
 */
public class Employee {
   
   private int EMPID; 
    private int JOBCODE; 
   private String FIRSTNAME;
   private String LASTNAME;  
   private String DESCRIPTION;

    /**
     * @return the FIRSTNAME
     */
    public String getFIRSTNAME() {
        return FIRSTNAME;
    }

    /**
     * @param FIRSTNAME the FIRSTNAME to set
     */
    public void setFIRSTNAME(String FIRSTNAME) {
        this.FIRSTNAME = FIRSTNAME;
    }

    /**
     * @return the LASTNAME
     */
    public String getLASTNAME() {
        return LASTNAME;
    }

    /**
     * @param LASTNAME the LASTNAME to set
     */
    public void setLASTNAME(String LASTNAME) {
        this.LASTNAME = LASTNAME;
    }

    /**
     * @return the DESCRIPTION
     */
    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    /**
     * @param DESCRIPTION the DESCRIPTION to set
     */
    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    /**
     * @return the EMPID
     */
    public int getEMPID() {
        return EMPID;
    }

    /**
     * @param EMPID the EMPID to set
     */
    public void setEMPID(int EMPID) {
        this.EMPID = EMPID;
    }
    
    
       /**
     * @return the JOBCODE
     */
    public int getJOBCODE() {
        return JOBCODE;
    }

    /**
     * @param JOBCODE the JOBCODE to set
     */
    public void setJOBCODE(int JOBCODE) {
        this.JOBCODE = JOBCODE;
    }
      

    
       public static Employee[] getAllEmployeeAsList(){
         
          Scanner input = new Scanner(System.in);   
          
         Statement stmt = null;
         ResultSet rset = null;
         ResultSetMetaData rsmd = null;
        Connection conn=null;
        
         Employee[] employee = null;
         try{
            
         DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());

  conn = DriverManager.getConnection
("jdbc:oracle:thin:@bisoracle.siast.sk.ca:1521:ACAD",     "cistu020", "bekind"); //your username and password here

  
            stmt = conn.createStatement();
            String SQLQuery = "Select Count(EMPID) from EMPLOYEE";           
            rset = stmt.executeQuery(SQLQuery);         
            rset.next();
            int size = rset.getInt(1);
            employee = new Employee[size];
            SQLQuery = "Select EMPLOYEE.EMPID, EMPLOYEE.FIRSTNAME, EMPLOYEE.LASTNAME, JOB.JOBCODE, JOB.DESCRIPTION from EMPLOYEE INNER JOIN JOB ON EMPLOYEE.JOBCODE = JOB.JOBCODE";
          
            rset = stmt.executeQuery(SQLQuery); 
            int i=0;
            while(rset.next()){
                Employee e = new Employee();
                e.setEMPID(rset.getInt(1));
                e.setFIRSTNAME(rset.getString(2)); 
                e.setLASTNAME(rset.getString(3)); 
                e.setJOBCODE(rset.getInt(4)); 
                e.setDESCRIPTION(rset.getString(5)); 
                employee[i]=e;
                i++;
            
                System.out.println( i + "\t" + e.getEMPID() + "\t" + e.getFIRSTNAME() + "\t\t" +
                e.getLASTNAME() + "\t\t" +e.getJOBCODE()+ "\t\t" +e.getDESCRIPTION());          
            }
            conn.close(); 
         }
         
          
         
         catch(Exception e){e.printStackTrace();}     
         
         return employee;
        
    }
       
  public static void changeFirstName(int choice){  
      
       Scanner input = new Scanner(System.in);   
          
         Statement stmt = null;
         ResultSet rset = null;
         ResultSetMetaData rsmd = null;
        Connection conn=null;
        
         Employee[] employee = null;
         try{
            
         DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());

  conn = DriverManager.getConnection
("jdbc:oracle:thin:@bisoracle.siast.sk.ca:1521:ACAD",     "cistu020", "bekind"); //your username and password here

  
            stmt = conn.createStatement();
            String SQLQuery = "Select Count(EMPID) from EMPLOYEE";           
            rset = stmt.executeQuery(SQLQuery);         
            rset.next();
            int size = rset.getInt(1);
            employee = new Employee[size];
            SQLQuery = "Select EMPLOYEE.EMPID, EMPLOYEE.FIRSTNAME, EMPLOYEE.LASTNAME, JOB.JOBCODE, JOB.DESCRIPTION from EMPLOYEE INNER JOIN JOB ON EMPLOYEE.JOBCODE = JOB.JOBCODE";
          
            rset = stmt.executeQuery(SQLQuery); 
            int i=0;
            
            while(rset.next()){
                Employee e = new Employee();
                e.setEMPID(rset.getInt(1));
                e.setFIRSTNAME(rset.getString(2)); 
                e.setLASTNAME(rset.getString(3)); 
                e.setJOBCODE(rset.getInt(4)); 
                e.setDESCRIPTION(rset.getString(5)); 
                employee[i]=e;
                    i++;
               }
            
             System.out.println("Enter the new First Name");
                         String newFirstName = input.next();
               String sql = "A";   
               
             for (int j = 0; j < employee.length; j++) { 
                  if ( choice == j+1){
                  
                  sql = "Update EMPLOYEE SET FIRSTNAME = '"+newFirstName+"' where EMPID = " + employee[choice-1].getEMPID();
                        
                  }
                 
             }
                        
              executeQuery(sql);
            conn.close(); 
         }
         
          
         
         catch(Exception e){e.printStackTrace();}     
         
    }
  
   public static void changeLastName(int choice){  
      
       Scanner input = new Scanner(System.in);   
          
         Statement stmt = null;
         ResultSet rset = null;
         ResultSetMetaData rsmd = null;
        Connection conn=null;
        
         Employee[] employee = null;
         try{
            
         DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());

  conn = DriverManager.getConnection
("jdbc:oracle:thin:@bisoracle.siast.sk.ca:1521:ACAD",     "cistu020", "bekind"); //your username and password here

  
            stmt = conn.createStatement();
            String SQLQuery = "Select Count(EMPID) from EMPLOYEE";           
            rset = stmt.executeQuery(SQLQuery);         
            rset.next();
            int size = rset.getInt(1);
            employee = new Employee[size];
            SQLQuery = "Select EMPLOYEE.EMPID, EMPLOYEE.FIRSTNAME, EMPLOYEE.LASTNAME, JOB.JOBCODE, JOB.DESCRIPTION from EMPLOYEE INNER JOIN JOB ON EMPLOYEE.JOBCODE = JOB.JOBCODE";
          
            rset = stmt.executeQuery(SQLQuery); 
            int i=0;
            
            while(rset.next()){
                Employee e = new Employee();
                e.setEMPID(rset.getInt(1));
                e.setFIRSTNAME(rset.getString(2)); 
                e.setLASTNAME(rset.getString(3)); 
                e.setJOBCODE(rset.getInt(4)); 
                e.setDESCRIPTION(rset.getString(5)); 
                employee[i]=e;
                i++;
               }
            
             System.out.println("Enter the new Last Name");
                         String newLastName = input.next();
               String sql = "A";   
               
             for (int j = 0; j < employee.length; j++) { 
                  if ( choice == j+1){
                  
                  sql = "Update EMPLOYEE SET LASTNAME = '"+newLastName+"' where EMPID = " + employee[choice-1].getEMPID();
                        
                  }
                 
             }
           
             
              executeQuery(sql);
            conn.close(); 
         }
         
          
         
         catch(Exception e){e.printStackTrace();}     
         
    }
   
   
   public static void changeJobCode(int choice){  
      
       Scanner input = new Scanner(System.in);   
          
         Statement stmt = null;
         ResultSet rset = null;
         ResultSetMetaData rsmd = null;
        Connection conn=null;
        
         Employee[] employee = null;
         try{
            
         DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());

  conn = DriverManager.getConnection
("jdbc:oracle:thin:@bisoracle.siast.sk.ca:1521:ACAD",     "cistu020", "bekind"); //your username and password here

  
            stmt = conn.createStatement();
            String SQLQuery = "Select Count(EMPID) from EMPLOYEE";           
            rset = stmt.executeQuery(SQLQuery);         
            rset.next();
            int size = rset.getInt(1);
            employee = new Employee[size];
            SQLQuery = "Select EMPLOYEE.EMPID, EMPLOYEE.FIRSTNAME, EMPLOYEE.LASTNAME, JOB.JOBCODE, JOB.DESCRIPTION from EMPLOYEE INNER JOIN JOB ON EMPLOYEE.JOBCODE = JOB.JOBCODE";
          
            rset = stmt.executeQuery(SQLQuery); 
            int i=0;
            
            while(rset.next()){
                Employee e = new Employee();
                e.setEMPID(rset.getInt(1));
                e.setFIRSTNAME(rset.getString(2)); 
                e.setLASTNAME(rset.getString(3)); 
                e.setJOBCODE(rset.getInt(4)); 
                e.setDESCRIPTION(rset.getString(5)); 
                employee[i]=e;
                i++;
                   System.out.println( i +  "\t\t" + e.getJOBCODE()+ "\t\t" +e.getDESCRIPTION());          
               }
            
             System.out.println("Enter the Job Code Index you want to change to");
                         int codeIndex = input.nextInt();
               String sql = "A";   
              
             for (int j = 0; j < employee.length; j++) { 
                  if ( codeIndex == j+1 && choice == j+1){
                  
                  sql = "Update EMPLOYEE SET JOBCODE = "+employee[codeIndex-1].getJOBCODE()+" where EMPID = " + employee[choice-1].getEMPID();
                        
                  }
                 
             }
                         
              executeQuery(sql);
            conn.close(); 
         }
         
          
         
         catch(Exception e){e.printStackTrace();}     
         
    }
  
   
   
     
      public static void executeQuery (String sql){
    
    Statement stmt=null; 
        ResultSet rset=null; 
        ResultSetMetaData rsmd=null;
          Connection conn=null;

         
//(Just catch exception e for now)
try{

DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());

  conn = DriverManager.getConnection
("jdbc:oracle:thin:@bisoracle.siast.sk.ca:1521:ACAD",     "cistu020", "bekind"); //your username and password here

   Statement s = conn.createStatement();
   s.executeUpdate(sql);
 
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
    System.out.println("Employee Table Updated");
      }
      


 
    
}
