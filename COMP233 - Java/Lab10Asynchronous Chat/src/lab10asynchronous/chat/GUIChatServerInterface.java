/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10asynchronous.chat;

import javax.swing.*;
 import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;





/**
 *
 * @author olanrewaju4401
 */
public class GUIChatServerInterface extends JFrame {

    
    private JTextArea chatInput;
    private JTextArea chatOutput;   
    private JButton chatSend;
    private JPanel chatInputContainer;
    
    private ObjectOutputStream output;
    private ObjectInputStream input;   
    private static ServerSocket server;
    private static Socket connection;
     static String messageIn;
    
     public GUIChatServerInterface(){

      
		//set title bar
		super("Server");
		
		//set diemensions
		setSize(500, 500);
		
		//tell it to appear
		  
                //determines the layout
		BorderLayout layout = new BorderLayout();
		setLayout( layout );
		
		
		//add some controls
		chatOutput = new JTextArea(); 
		chatInput = new JTextArea(3,20);
		chatSend = new JButton("Send");  		
		

                add(chatOutput, BorderLayout.CENTER);
		add(chatInput, BorderLayout.SOUTH);
		add(chatSend, BorderLayout.SOUTH);
                
                // JPanel chatInputContainer = new JPanel();
                chatInputContainer = new JPanel();
		
                chatInputContainer.add(chatInput);
                chatInputContainer.add(chatSend);                 
                add( chatInputContainer,BorderLayout.SOUTH);
                
                 setVisible( true );
                 
                chatSend.addActionListener(new ActionListener(){
		public void actionPerformed( ActionEvent ae){
			sendData(chatInput);
		}
	}
);            
                     
                
       
	}
  

        private void sendData(JTextArea out){
	
		
	try{
		
		//System.out.println( out.getText() );
            chatOutput.append("SERVER: " + out.getText()  + "\n"); 
           output.writeObject("SERVER: " + out.getText());

           out.setText("");
	}
	
	catch( Exception e){
		
	   	System.out.println("Oops! : "+e.toString() );
		
		}
		
}

 public void connectToClient(){
	
try{
//String targetIP = 
//JOptionPane.showInputDialog("Enter Port Number");
//int IPNumber = Integer.parseInt(targetIP);
//   server = new ServerSocket (IPNumber,100);

            server =new ServerSocket (12345,100);
            
          
            chatOutput.append("Waiting for client to connect\n"); 
            connection = server.accept(); //server has a method accept more likely  a loop
            
            chatOutput.append("Client Connected!\n"); 
              
          
            output = new ObjectOutputStream (connection.getOutputStream());
            output.flush();
            
            input = new ObjectInputStream(connection.getInputStream());
//            messageIn = (String)input.readObject();
//             getChatInput().append("Client: " + messageIn  + "\n"); 
          
            
}
catch( Exception e){
System.out.println("Oops! : "+e.toString() );
		
}
}

        
public static void main(String[] args) {
        // TODO code application logic here
        
        
     GUIChatServerInterface Server = new GUIChatServerInterface();
     Server.connectToClient();
     Server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     ExecutorService listen = Executors.newFixedThreadPool(1);
     ChatListener cl = new ChatListener(Server.input, Server.chatOutput);
     listen.execute(cl);
     
     
    
    }



} 
   