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
public class JavaDataAccessLayer {

    /**
     * @param args the command line arguments
     */
  
    
    public static void main(String[] args) {
        // TODO code application logic here
         
          System.out.print("Employee Number: ");
          Scanner input = new Scanner(System.in);
          String EMPID = input.next();
          String sql = "Select* from employee where EMPID = " + EMPID;
          
          executeQuery(sql);
          
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
