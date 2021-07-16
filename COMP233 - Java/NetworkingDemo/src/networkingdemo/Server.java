/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkingdemo;

import java.util.Scanner;
import java.io.*;
import java.net.*;



/**
 *
 * @author olanrewaju4401
 */
public class Server {
    
    static String messageIn;
    static String messageOut;
    static Scanner keyboardInput;
    
 //Declare object to maintain the connection
    static ServerSocket server;
    static Socket connection;
    
    //Declare IO pathways
    static ObjectOutputStream output;
    static ObjectInputStream input;
    
    public static void main (String []args){
       
        try{
            do {
           
            server = new ServerSocket (12345,100);
            
            System.out.println("Waiting for client to connect");
            
            connection = server.accept(); //server has a method accept more likely  a loop
            
            System.out.println("Client Connected!");
           
            output = new ObjectOutputStream (connection.getOutputStream());
            output.flush();
            
            input = new ObjectInputStream(connection.getInputStream());
            
            do {
            
            //2. Wait for incoming String Object
            do {
            messageIn = (String)input.readObject();
            
            //3. Print the message to the screeen
            
            System.out.println("Client says: "+messageIn);
            }  
         while ((!messageIn.endsWith("over"))&&(!messageIn.endsWith("out")));
            //4. Wait for our server administrator(thatsus) to type response
                do {                   
                               
            System.out.println("Server Response: ");
            keyboardInput = new Scanner (System.in);
            messageOut = keyboardInput.nextLine();
            
            //5. Send that response back to the client
           // The messageOut String object will be sent to the client using the writeObject method.
            
            output.writeObject(messageOut);
             output.flush();
             
              } while ((!messageOut.endsWith("over"))&&(!messageOut.endsWith("out"))); 
              
            
          } while ((messageOut.endsWith("over"))&&(!messageOut.endsWith("out")));
             
         if ((messageOut.endsWith("out"))) {
                   server.close();
                   connection.close(); 
                }
             }while ((!messageOut.endsWith("out"))|| (messageOut.endsWith("over")));
                    
    }
        catch(IOException ex)
        {
            System.out.println(ex.toString());
        }
        catch (ClassNotFoundException cnfe)
                {
                System.out.println(cnfe.toString());
               }  
   
}
}