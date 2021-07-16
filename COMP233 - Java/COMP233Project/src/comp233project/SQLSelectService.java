/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp233project;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

import java.sql.*;  

/**
 *
 * @author olanrewaju4401
 */
public class SQLSelectService extends Service{
    
    private String requestString;
//    private SQLCommand;
   

   public SQLSelectService(DataOutputStream responseWriter, String requestString){
		
		super(responseWriter);
		this.requestString=requestString;
	}
	
	public void setSQLCommand(){
	
		//This method extracts the criteria and field name from the
		//request string (using indexOf)and builds a valid SQL query.
		//something like:
	
		//”SELECT * FROM EMPLOYEE WHERE “+fieldName+” = ‘“ criteria +”’”  
	}
        
        public void doWork(){
		try{
                    
                     Statement stmt=null; 
                     ResultSet rset=null; 
                     ResultSetMetaData rsmd=null;
                     Connection conn=null;
	
            
            
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
try {
      
        //Set up the Web page:
       DataOutputStream  responseWriter  = new DataOutputStream("WebRoot\\Util\\Error404.htm");  
		responseWriter.writeBytes("<html><head><title>test");
		responseWriter.writeBytes("</title></head><body>");		
}
catch (Exception ioe) {
    ioe.printStackTrace();
}

    }
        
    
}
