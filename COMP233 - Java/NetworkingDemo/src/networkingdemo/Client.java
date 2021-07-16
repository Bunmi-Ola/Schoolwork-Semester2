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
public class Client {
    
    static String messageIn;
    static String messageOut;
    static Scanner keyboardInput;
    
    //declare object to maintain connection
    static Socket client;
    //declare IO pathway
    static ObjectOutputStream output;
    static ObjectInputStream input;
 
    
     public static void main(String[] args) {
        // TODO code application logic here
    
       try{           
       
           client = new Socket (InetAddress.getByName("127.0.0.1"),12345); 
           
           //1 Establish IO paths between client and server
          
              
           ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
           output.flush();
           
           ObjectInputStream input = new  ObjectInputStream (client.getInputStream());
       
           do {
               //2. Wait for out client usert ot type a message
            
      
            do {
           System.out.println("Please type your message");
           keyboardInput = new Scanner(System.in);
           messageOut = keyboardInput.nextLine();
           output.writeObject(messageOut);
           output.flush();
           if ((messageOut.endsWith("out"))) {
                    client.close();
                }
            }
      while ((!messageOut.endsWith("over"))&&(!messageOut.endsWith("out"))); 
           //3. Send that message to the server

          
               do {
                    messageIn = (String)input.readObject(); //keep receiving messages as long as client doesnt say out
          System.out.println("Server says:   "+messageIn); 
               } while (!messageIn.endsWith("over"));                            
                 
               
            
            } while(!messageOut.endsWith("out"));
          
        
    }
     catch (IOException ex){
         System.out.println(ex.toString());
     }
        catch(ClassNotFoundException cnfx){
            System.out.println(cnfx.toString());
        }
     
  }
}

//http://pirate.shu.edu/~wachsmut/Teaching/CSAS2214/Virtual/Lectures/chat-client-server.html