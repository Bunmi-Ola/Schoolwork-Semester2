/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp233finalproject;


    
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author beama
 */
public class SQLSelectService extends Service {

    private DataOutputStream responseWriter;
    private String requestString;
    private String sqlcommand;
   
    /**
     *
     * @param pageWriter
     * @param requestString
     */
    
    public SQLSelectService(DataOutputStream responseWriter, String requestString){
		
		super(responseWriter);
		setRequestString(requestString);
                
	}
	
  
     /**
     * @return the responseWriter
     */
    public DataOutputStream getResponseWriter() {
        return responseWriter;
    }

    /**
     * @param responseWriter the responseWriter to set
     */
    public void setResponseWriter(DataOutputStream responseWriter) {
        this.responseWriter = responseWriter;
    }

    /**
     * @return the sql
     */
    public String getSqlcommand() {
        String rs = getRequestString();
        String field="";
        field = rs.substring(rs.indexOf("Field=")+6,rs.indexOf("&Submit"));
        String criteria=rs.substring(rs.indexOf("Criteria=")+9,rs.indexOf("&Field="));
         criteria = "'%" + criteria + "%'";
        String sqlcommand = String.format("select * from employee where %s like %s ", field,criteria);
        //System.out.println(sql);
        return sqlcommand;
    }

    /**
     * @param sql the sql to set
     */
    public void setSqlcommand(String sqlcommand) {
        this.sqlcommand = sqlcommand;
    }

    /**
     * @return the requestString
     */
    public String getRequestString() {
        return requestString;
    }

    /**
     * @param requestString the requestString to set
     */
    public void setRequestString(String requestString) {
        this.requestString = requestString;
    }
    Connection conn;
    Statement stat;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    
       public void doWork()
    {
         try {
             //connect to sql
             try {
                 DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                conn = DriverManager.getConnection
("jdbc:oracle:thin:@bisoracle.siast.sk.ca:1521:ACAD",     "cistu020", "bekind4401"); //your username and password here

             } catch (SQLException e) {
                 //handle exception here
                 logging("cant connect to SQL Server"); 
                 
             }
             //output the first part of query page
             super.responseWriter.writeBytes("<html>\n" +
                     "\n" +
                     "<head>\n" +
                     "<title>Comp 233, Query</title>\n" +
                     "</head>\n" +
                     "\n" +
                     "<body>\n" +
                     "<p align='center'><font face='Arial' size='13' color=\"#0000FF\">Service  Page</font></p>\n" +
                     "\n" +
                     "<p>\n" +
                     "<form action='doSERVICE' method='GET'>\n" +
                     "&nbsp;\n" +
                     "<table border=\"0\" width=\"100%\" id=\"table1\">\n" +
                     "	<tr>\n" +
                     "		<td>\n" +
                     "		<p align=\"right\"><font face=\"Arial\">Search Criteria</font></td>\n" +
                     "		<td>\n" +
                     "<input type='text' name='Criteria' size='15'></td>\n" +
                     "	</tr>\n" +
                     "	<tr>\n" +
                     "		<td>\n" +
                     "		<p align=\"right\"><font face=\"Arial\">First Name</font></td>\n" +
                     "		<td>\n" +
                     "<input type='radio' name='Field' value='FirstName' checked></td>\n" +
                     "	</tr>\n" +
                     "	<tr>\n" +
                     "		<td>\n" +
                     "		<p align=\"right\"><font face=\"Arial\">Last Name</font></td>\n" +
                     "		<td>\n" +
                     "<input type='radio' name='Field' value='LastName'></td>\n" +
                     "	</tr>\n" +
                     "	<tr>\n" +
                     "		<td>\n" +
                     "		<p align=\"right\"><font face=\"Arial\">Job Code</font></td>\n" +
                     "		<td>\n" +
                     "<input type='radio' name='Field' value='JobCode'></td>\n" +
                     "	</tr>\n" +
                     "	<tr>\n" +
                     "		<td>\n" +
                     "		<p align=\"right\"><font face=\"Arial\">Employee ID</font></td>\n" +
                     "		<td>\n" +
                     "<input type='radio' name='Field' value='empid'></td>\n" +
                     "	</tr>\n" +
                     "	<tr>\n" +
                     "		<td colspan=\"2\">\n" +
                     "		<p align=\"center\">\n" +
                     "<input type='Submit' name='Submit' value='Run Service'></td>\n" +
                     "	</tr>\n" +
                     "</table>\n" +
                     "<!---->\n" +
                     "<p><br>\n" +
                     "<br>\n" +
                     "<br>\n" +
                     "<br>\n" +
                     "&nbsp; </p>\n" +
                     "</form>");
             //execute sql command
             //creat connection
             stat = conn.createStatement();
             rs = stat.executeQuery(getSqlcommand());
             //result set
             rsmd =rs.getMetaData();
             
             String result = "<h4>Result Not Found</h4>";
           
            
            
             super.responseWriter.writeBytes("<table style='border:1px solid red;'>");
             rsmd = rs.getMetaData();
             int col = rsmd.getColumnCount();
             super.responseWriter.writeBytes("<tr>");//output columnn names
             for (int q = 0; q < col; q++) {
             super.responseWriter.writeBytes("<td style='border:1px solid red;'>");
             super.responseWriter.writeBytes(rsmd.getColumnName(q+1));

             super.responseWriter.writeBytes("</td style='border:1px solid red;'>");
             }
             super.responseWriter.writeBytes("</tr>");//================================================================
             //Second part of table rows from table retrieved form result set
             while (rs.next()) {
                 
                 
                 super.responseWriter.writeBytes("<tr>");
                 for (int i = 0; i < col; i++) {
                     try {
                         super.responseWriter.writeBytes("<td style='border:1px solid red;'>");
                         super.responseWriter.writeBytes(rs.getString(i + 1));
                         super.responseWriter.writeBytes("</td style='border:1px solid red;'>");
                     } catch (Exception e) {
                         System.out.println(e);
                     }
                 }
                 result = "";
               

                 super.responseWriter.writeBytes("</tr>");
             }
             
             super.responseWriter.writeBytes("</table>");
             super.responseWriter.writeBytes(result);
             
             
             //output second page of query page
             super.responseWriter.writeBytes("</p>\n" +
                     "</body>\n" +
                     "\n" +
                     "</html>");
            
         
          
             //close responseWriter
             super.responseWriter.close();
         } catch (IOException ex) {
           
             try {
                 //handle exception here
                 logging("Cant write to file" + ex.toString());// asks to surround in try catch
             } catch (IOException ex1) {
                 
               
             }
           
        } catch (SQLException sqle) {
           //handle exception here
     

        }
    }

    /**
     * @return the SQLCommand
     */
        // logging to text file
    public static void logging(String string) throws  IOException{
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        BufferedWriter bw = new BufferedWriter(new FileWriter("AllRequests.txt",true));
        PrintWriter pw = new PrintWriter(bw,true);
        pw.write(timeStamp);
        pw.write(string);
        pw.flush();
    }
    
}
