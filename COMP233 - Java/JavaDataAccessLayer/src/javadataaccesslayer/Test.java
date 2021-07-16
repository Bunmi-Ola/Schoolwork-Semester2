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

import javax.swing.*;

/**
 *
 * @author olanrewaju4401
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        Statement stmt=null; 
        ResultSet rset=null; 
        ResultSetMetaData rsmd=null;
        Connection conn=null;
String password = getPassword();
//(Just catch exception e for now)
try{

DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());

  conn = DriverManager.getConnection
("jdbc:oracle:thin:@bisoracle.siast.sk.ca:1521:ACAD",     "cistu020", "bekind"); //your username and password here
 //your username and password here


  stmt = conn.createStatement();
  rset = stmt.executeQuery ("select * from employee");
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
	sqle.printStackTrace ();
    }
   }
    
public static String getPassword() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter a password:");
        JPasswordField pass = new JPasswordField(10);
        panel.add(label);
        panel.add(pass);
        String[] options = new String[]{"OK", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panel, "The title",
                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[1]);
        String strPassword = " ";
       if (option == 0) // pressing OK button
        {
            char[] password = pass.getPassword();
            strPassword = new String(password);
        }

        return strPassword;
    }
    
}
