/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab10ChatGUI;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;
/**
 *
 * @author delacruz9572
 */
public class ChatInterface extends JFrame{
   
    private JTextArea chatInput;
    private JTextArea chatOutput;
    private JButton chatSend;
    
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Socket connection;
    
    public ChatInterface(){
       
       //title bar
       super("Chatter");
       setSize(500, 500);//window size
      
       BorderLayout layout = new BorderLayout();
       setLayout(layout);
       
       //add some controls
       
       chatOutput = new JTextArea();
       chatInput = new JTextArea(3,21);
       chatSend = new JButton("Send");

       add(chatOutput, BorderLayout.CENTER);
       add(chatInput, BorderLayout.SOUTH);
       JPanel chatInputContainer = new JPanel();
       chatInputContainer.add(chatInput);
       add(chatSend, BorderLayout.SOUTH);
       chatInputContainer.add(chatSend);
       add(chatInputContainer, BorderLayout.SOUTH);
       
       setVisible(true);
       
      
       chatSend.addActionListener(
               new ActionListener(){
                   public void actionPerformed(ActionEvent ae){
                       //if(ae.getActionCommand() == KeyEvent.VK_ENTER){
                       sendData(chatInput);
                       ae.getActionCommand();
                       //}
                   }
               }
       );
   }
    
   private void sendData(JTextArea out){
       try{     
           output.writeObject("CLIENT: " + out.getText());
           chatOutput.append("CLIENT: " + out.getText() + "\n");    
           out.setText("");
       }catch(Exception e){
           System.out.println("Oops!: " + e.toString());
       }
   }
   
   public void connectToServer(){
       try{
           String targetIp = JOptionPane.showInputDialog("Enter Server IP Address");
           connection = new Socket(InetAddress.getByName(targetIp), 12345);
           
           //ObjectOutputStream 
           output = new ObjectOutputStream(connection.getOutputStream());
           //ObjectInputStream 
           input = new ObjectInputStream(connection.getInputStream());
           output.flush();
           
       }catch(Exception e){
           System.out.println("Oops!: " + e.toString());
       }
   }
   
   

   
   public static void main(String args[]){
     ChatInterface chatter = new ChatInterface();
     chatter.connectToServer();
     chatter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     ExecutorService listen = Executors.newFixedThreadPool(1);
     ChatListener cl = new ChatListener(chatter.input, chatter.chatOutput);
     listen.execute(cl);
   }
   
   
}




