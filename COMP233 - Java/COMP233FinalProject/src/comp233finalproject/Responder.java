/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp233finalproject;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class Responder implements Runnable {

    private Socket requestHandler;
    private Scanner requestReader;
    private Scanner pageReader;
    private DataOutputStream pageWriter; // get the streams 
    private String HTTPMessage;   
    private String requestedFile;
    final static String DEFAULT = "WebRoot/Util/Error404.html"; //error webpage   
  
    private JTextArea text;

  
    public Responder(Socket requestHandler, JTextArea text) {

        setRequestHandler(requestHandler);     
        setText(text);
    }

    public Socket getRequestHandler() {
        return requestHandler;
    }

    /**
     * @param requestHandler the requestHandler to set
     */
    public void setRequestHandler(Socket requestHandler) {
        this.requestHandler = requestHandler;
    }

        /**
     * @return the txt
     */
    public JTextArea getText() {
        return text;
    }

    /**
     * @param txt the txt to set
     */
    public void setText(JTextArea text) {
        this.text = text;
    }

    @Override
    public void run() {
         requestedFile="";
     
            try {
                   // Get input and output streams
                   //read input streams
                   //get message from clients
                requestReader = new Scanner(
                        new InputStreamReader(requestHandler.getInputStream()));
                //sent message out
                pageWriter = new DataOutputStream(getRequestHandler().getOutputStream());


                int lineCount = 0;

                do {
                    lineCount++;//            count request sent from clients 
                      //Receive request
                    HTTPMessage = requestReader.nextLine();//request
                    text.append(HTTPMessage + "\n");

                    if (lineCount == 1) {

                        logging(HTTPMessage);
                        //run SQL
                        if (HTTPMessage.indexOf("doSERVICE") > -1) {
                            //page writer sent request
                            SQLSelectService sqls = new SQLSelectService(pageWriter, HTTPMessage);
                            sqls.doWork();
                            break;
                        } else {
                               //SEARCH FOR FILE
                            requestedFile = "WebRoot\\"
                                    + HTTPMessage.substring(5, HTTPMessage.indexOf("HTTP/1.1") - 1);

                            if (requestedFile.equals("WebRoot\\") || requestedFile.equals("WebRoot\\subdir") || requestedFile.equals("WebRoot\\subdir/")) {
                                requestedFile = "WebRoot\\Default.htm";
                            }
                        }
                    };

                } while (HTTPMessage.length() != 0);
                //It is thrown when an input-output operation failed or interrupted
            } catch (IOException ex) {
                try {
                    logging(ex.toString());
                } catch (IOException ex1) {
                

                }
            }
            //if requested file is not empty
            if (!requestedFile.equals("")) {
                try {
                    try {
                        //read file requested
                        pageReader = new Scanner(new File(requestedFile));
                        // write to Jframe
                        text.append(HTTPMessage + "\n");
                        // file not found error
                    } catch (FileNotFoundException fnfe) {
                        pageReader = new Scanner(new File("WebRoot\\Util\\Error404.htm"));
                        logging("Error 404. File Not Found");
                    }
                    //if there is more records, keep writing line by line
                    while (pageReader.hasNext()) {
                        String s = pageReader.nextLine();
                        System.out.println(s);
                        pageWriter.writeBytes(s);
                    }
                    //tell the browser we're done writing to it.
                    pageReader.close();
                    pageWriter.close();
                    requestHandler.close();
                } catch (Exception e) {
                    text.append(e.toString());
                }

            }
        

    }
     // logging to text file
    public static void logging(String string) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        BufferedWriter bw = new BufferedWriter(new FileWriter("AllRequests.txt", true));
        PrintWriter pw = new PrintWriter(bw, true);
        pw.write(timeStamp);       
        pw.write(string);
        // Flush the output
        pw.flush();
    }

}
