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
public class Job {
    
    
    private int Jobcode;
    private String Description;
    private float PAYRATE;
    private String PAYTYPE;
   
      /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the PAYRATE
     */
    public float getPAYRATE() {
        return PAYRATE;
    }
     /**
     * @param PAYRATE the PAYRATE to set
     */
    public void setPAYRATE(float PAYRATE) {
        this.PAYRATE = PAYRATE;
    }

      /**
     * @return the Jobcode
     */
    public int getJobcode() {
        return Jobcode;
    }

    /**
     * @param Jobcode the Jobcode to set
     */
    public void setJobcode(int Jobcode) {
        this.Jobcode = Jobcode;
    }

   
    /**
     * @return the PAYTYPE
     */
    public String getPAYTYPE() {
        return PAYTYPE;
    }

    /**
     * @param PAYTYPE the PAYTYPE to set
     */
    public void setPAYTYPE(String PAYTYPE) {
        this.PAYTYPE = PAYTYPE;
    }

    /**
     * @param PAYRATE the PAYRATE to set
     */
    public void setPAYRATE(int PAYRATE) {
        this.setPAYRATE(PAYRATE);
    }
    
     public static Job[] getAllJobsAsList(){
         
          Scanner input = new Scanner(System.in);   
          
         Statement stmt = null;
         ResultSet rset = null;
         ResultSetMetaData rsmd = null;
        Connection conn=null;
        
         Job[] jobs = null;
         try{
            
             DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());

  conn = DriverManager.getConnection ("jdbc:oracle:thin:@bisoracle.siast.sk.ca:1521:ACAD",     "cistu020", "bekind"); //your username and password here

  
            stmt = conn.createStatement();
            String SQLQuery = "Select Count(JobCode) from Job";           
            rset = stmt.executeQuery(SQLQuery);         
            rset.next();
            int size = rset.getInt(1);
            jobs = new Job[size];
            SQLQuery = "Select JobCode, Description, PAYRATE, PAYTYPE From Job";
            rset = stmt.executeQuery(SQLQuery); 
            int i=0;
            while(rset.next()){
                Job j = new Job();
                j.setJobcode(rset.getInt(1));
                j.setDescription(rset.getString(2)); 
                j.setPAYRATE(rset.getFloat(3)); 
                j.setPAYTYPE(rset.getString(4)); 
                jobs[i]=j;
                i++;
            
                System.out.println( i + "\t" + j.getJobcode() + "\t" + j.getDescription() + "\t\t" +
                j.getPAYRATE() + "\t\t" + j.getPAYTYPE());          
            }
                System.out.println("Select a number to edit");
                int number = input.nextInt();
                int choice = 0;
                String newDescription = "A";
                float newPayrate = 0;
                String sql = "A";
                String output = "";
                for (int j = 0; j < jobs.length; j++) {        
                if ( number == j+1){
                      for (int k = 0; k < 1; k++) {   
                     System.out.print("\n"
                    + "What Info do you want to edit\n"
                    + " 1. Job description\n"
                    + " 2. Pay Rate\n"          
                    + " Please make a selection:\n");
                     choice = input.nextInt();
                     if (choice == 1){
                          System.out.println("Enter the new Job Description");
                          newDescription = input.next();
                           sql = "Update JOB SET DESCRIPTION = '"+newDescription+"' where JOBCODE = " + jobs[j].getJobcode();
                           
                     }
                     
                    if (choice == 2){
                          System.out.println("Enter the new Pay Rate");
                          newPayrate = input.nextInt();
                           sql = "Update JOB SET PAYRATE = "+newPayrate+" where JOBCODE = " + jobs[j].getJobcode();
                           
                    }
                    else if (choice != 1 ||choice != 2){
                             output = "Invalid Number";
                      }
                     
                    }
                   output = "Job Table Updated"; 
                }
                else if ( number != j+1){
                     output = "Invalid Number"; 
                 }
            }
            System.out.println(output);   
           
            executeQuery(sql);
             conn.close();
         }
         catch(Exception e){e.printStackTrace();}     
         return jobs;
        
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
  
      }
      

}
