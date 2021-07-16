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
public class ServerInterface extends JFrame {
    private JTextArea chatInput;
    private JTextArea chatOutput;
    private JButton chatSend;
    
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket server;
    private Socket connection;
    
    public ServerInterface(){
       
       //title bar
       super("Server");
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
                       sendData(chatInput);
                   }
               }
       );
   }
    
    private void sendData(JTextArea out){
       try{
           //System.out.println(out.getText());
           chatOutput.append("SERVER: " + out.getText()  + "\n"); 
           output.writeObject("SERVER: " + out.getText());

           out.setText("");
       }catch(Exception e){
           System.out.println("Oops!: " + e.toString());
       }
   }
   
   public void connectToServer(){
       try{
//           String targetIp = JOptionPane.showInputDialog("Enter Server IP Address");
//           connection = new Socket(InetAddress.getByName(targetIp), 12345);

            server = new ServerSocket(12345, 100);
            connection = server.accept();
            output = new ObjectOutputStream(connection.getOutputStream());
            input = new ObjectInputStream(connection.getInputStream());
            output.flush();
           
       }catch(Exception e){
           System.out.println("Oops!: " + e.toString());
       }
   }
   
   public static void main(String args[]){
     ServerInterface Server = new ServerInterface();
     Server.connectToServer();
     Server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     ExecutorService listen = Executors.newFixedThreadPool(1);
     ChatListener cl = new ChatListener(Server.input, Server.chatOutput);
     listen.execute(cl);
   }
}
