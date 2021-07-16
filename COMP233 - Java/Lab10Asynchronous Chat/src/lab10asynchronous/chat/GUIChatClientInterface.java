/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10asynchronous.chat;

import javax.swing.*;
 import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.awt.event.*;
import java.lang.*;
import java.util.concurrent.*;
import static lab10asynchronous.chat.GUIChatServerInterface.messageIn;



/**
 *
 * @author olanrewaju4401
 */
public class GUIChatClientInterface extends JFrame {
  
    private JTextArea chatInput;
    private JTextArea chatOutput;
    private JPanel chatInputContainer;
    private JButton chatSend;
    
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private static Socket client;
    private Socket connection;
    
    
  public GUIChatClientInterface(){
      
		
		//set title bar
		super("Client");
		
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
                
                //ask
		//add(chatInput, BorderLayout.SOUTH);
		add(chatSend, BorderLayout.SOUTH);
                
                // JPanel chatInputContainer = new JPanel();
                chatInputContainer = new JPanel();
		
                chatInputContainer.add(chatInput);
                chatInputContainer.add(chatSend);                 
                add( chatInputContainer,BorderLayout.SOUTH);
                
                 setVisible( true );
                 
                chatSend.addActionListener(new ActionListener(){
		public void actionPerformed( ActionEvent ae){
			sendData(getChatInput());
		}
	}
);                  
            
	}
  
 
        private void sendData(JTextArea out){	
		
	try{
		
		//System.out.println( out.getText() );
            
            chatOutput.append("Client: " + out.getText()  + "\n"); 
           output.writeObject("Client: " + out.getText());

           out.setText("");
	}
	
	catch( Exception e){
		
	   	System.out.println("Oops! : "+e.toString() );
		
		}
		
}
 public void connectToServer(){
	
try{
String targetIP = 
JOptionPane.showInputDialog("Enter Server IP Address");

connection = new Socket(InetAddress.getByName(targetIP), 12345);

         
// ObjectOutputStream output = new ObjectOutputStream(getClient().getOutputStream());
// output.flush();
       //ObjectOutputStream 
            setOutput(new ObjectOutputStream(getConnection().getOutputStream()));
            getOutput().flush();
            
            
//ObjectInputStream input = new  ObjectInputStream (getClient().getInputStream());
setInput( new  ObjectInputStream (getConnection().getInputStream()));


    ExecutorService listen = Executors.newFixedThreadPool(1);
    ChatListener c2 = new ChatListener(input, getChatOutput());
    listen.execute(c2);
    
    
}
catch( Exception e){
System.out.println("Oops! : "+e.toString() );
		
    }
}

        
public static void main(String[] args) {
        // TODO code application logic here
        
        
    GUIChatClientInterface Client = new GUIChatClientInterface();
    Client.connectToServer();
    Client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    ExecutorService listen = Executors.newFixedThreadPool(1);
//    ChatListener c2 = new ChatListener(Client.input, Client.chatOutput);
//    listen.execute(c2);
      
    }

    /**
     * @return the chatInput
     */
    public JTextArea getChatInput() {
        return chatInput;
    }

    /**
     * @param chatInput the chatInput to set
     */
    public void setChatInput(JTextArea chatInput) {
        this.chatInput = chatInput;
    }

    /**
     * @return the chatOutput
     */
    public JTextArea getChatOutput() {
        return chatOutput;
    }

    /**
     * @param chatOutput the chatOutput to set
     */
    public void setChatOutput(JTextArea chatOutput) {
        this.chatOutput = chatOutput;
    }

    /**
     * @return the chatInputContainer
     */
    public JPanel getChatInputContainer() {
        return chatInputContainer;
    }

    /**
     * @param chatInputContainer the chatInputContainer to set
     */
    public void setChatInputContainer(JPanel chatInputContainer) {
        this.chatInputContainer = chatInputContainer;
    }

    /**
     * @return the chatSend
     */
    public JButton getChatSend() {
        return chatSend;
    }

    /**
     * @param chatSend the chatSend to set
     */
    public void setChatSend(JButton chatSend) {
        this.chatSend = chatSend;
    }

    /**
     * @return the output
     */
    public ObjectOutputStream getOutput() {
        return output;
    }

    /**
     * @param output the output to set
     */
    public void setOutput(ObjectOutputStream output) {
        this.output = output;
    }

    /**
     * @return the input
     */
    public ObjectInputStream getInput() {
        return input;
    }

    /**
     * @param input the input to set
     */
    public void setInput(ObjectInputStream input) {
        this.input = input;
    }

    /**
     * @return the client
     */
    public static Socket getClient() {
        return client;
    }

    /**
     * @param aClient the client to set
     */
    public static void setClient(Socket aClient) {
        client = aClient;
    }

    /**
     * @return the connection
     */
    public Socket getConnection() {
        return connection;
    }

    /**
     * @param connection the connection to set
     */
    public void setConnection(Socket connection) {
        this.connection = connection;
    }
   
   


} 
   
//  public static void addComponentsToPane(Container pane) {
//        
//        if (!(pane.getLayout() instanceof BorderLayout)) {
//            pane.add(new JLabel("Container doesn't use BorderLayout!"));
//            return;
//        }
//        
//      
//        
//        JButton button = new JButton("Button 1 (PAGE_START)");
//        pane.add(button, BorderLayout.PAGE_START);
//        
//        //Make the center component big, since that's the
//        //typical usage of BorderLayout.
//        button = new JButton("Button 2 (CENTER)");        
//        pane.add(button, BorderLayout.CENTER);
//        
//        button = new JButton("Button 3 (LINE_START)");
//        pane.add(button, BorderLayout.LINE_START);
//        
//        button = new JButton("Long-Named Button 4 (PAGE_END)");
//        pane.add(button, BorderLayout.PAGE_END);
//        
//        button = new JButton("5 (LINE_END)");
//        pane.add(button, BorderLayout.LINE_END);
//    }
//    
//}
