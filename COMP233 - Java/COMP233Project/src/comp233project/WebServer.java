/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp233project;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

/**
 *
 * @author olanrewaju4401
 */
public class WebServer {

    static ServerSocket requestListener;
    static Socket requestHandler;
    static Scanner requestReader;
    static String HTTPMessage;
    static Scanner pageReader;
    static DataOutputStream pageWriter;

    static String requestedFile;
    public static int HTTP_PORT = 12346;
    static String errorFile;
    static ExecutorService responses;
    final static String DEFAULT = "WebRoot/Util/Error404.htm";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            // ServerSocket object accepts the port number on which the program should be listening
            requestListener = new ServerSocket(HTTP_PORT);

            System.out.println("Waiting For IE to request a page:");

            // requestHandler is now the connected socket
            requestHandler = requestListener.accept();
            System.out.println("Page Requested: Request Header:");

           
            requestReader = new Scanner(
                    new InputStreamReader(requestHandler.getInputStream()));

            int lineCount = 0;
            do {

                lineCount++; //This will be used later
                HTTPMessage = requestReader.nextLine();

                if (lineCount == 1) {
                    //the server sends an HTTP response
                    requestedFile = "WebRoot\\"
                            + HTTPMessage.substring(5, HTTPMessage.indexOf("HTTP/1.1") - 1);

                    requestedFile = requestedFile.trim();
                }
                System.out.println(HTTPMessage);

            } while (HTTPMessage.length() != 0);
             
           
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("\n");
            e.printStackTrace();
        }

      
          

            try {
                try {
            pageReader = new Scanner(new File(requestedFile));
           
            pageWriter = new DataOutputStream(
                    requestHandler.getOutputStream());
            while (pageReader.hasNext()) {
                String s = pageReader.nextLine();
                System.out.println(s);
                pageWriter.writeBytes(s);
            }
             }catch (FileNotFoundException fnfe){
                    pageReader = new Scanner(new File(DEFAULT));
             }
            //tell the browser we're done writing to it.
            pageReader.close();
            pageWriter.close();
            requestHandler.close();

        } catch (Exception e) {

            System.out.println(e.toString());
            System.out.println("\n");
            e.printStackTrace();
        }
    }

}
