/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp233finalproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebServer extends JFrame {
    private static ServerSocket requestListener;
  //socket is an endpoint for communication between two machines.
    private static int HTTP_PORT;  // server port number
    private ExecutorService responses; //executive program in order

    private JTextArea textArea;
    private JButton start;
    private JButton stop;   
   
    
    public WebServer(){
        
        //set title bar
        super("Server");
        
        //set dimensions
        setSize(500,500);
      
        ////determines the layout
        BorderLayout layout = new BorderLayout();
        setLayout( layout );


        //add some controls:
        //display messages
        textArea = new JTextArea();
        //panel to start the connection
        start = new JButton("Start");
        //panel to stop the connection
        stop = new JButton("Stop");
        add(textArea, BorderLayout.CENTER);


        //set background color
        textArea.setBackground(new Color(223, 198, 186));

        //create a font object and set font      
        textArea.setFont(new Font("Serif",Font.PLAIN,16));

        
        Panel buttonContainer = new Panel();
        buttonContainer.add(start);
        buttonContainer.add(stop);

        
        add( buttonContainer,BorderLayout.SOUTH);
        
       //Create a JPanel  
JPanel panel=new JPanel();  
  
//Create a scrollbar using JScrollPane and add panel into it's viewport  
//Set vertical and horizontal scrollbar always show  
JScrollPane scrollBar =new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
  

add(scrollBar);
        //set the frame to appear
        setVisible(true);
        //invoked the server to stop when the stop button is clicked
         stop.addActionListener(new ActionListener() { //button to stop listening
            public void actionPerformed(ActionEvent ae) {
               // handle stop server here             
               getDisconnect(); 
          
              
            }  
         });
            //invoked the server to start when the stop button is clicked
         start.addActionListener(new ActionListener() { //Button to listen
            public void actionPerformed(ActionEvent ae) {              
              getConnection();
              textArea.append("Started \n");
                         
            }
        });
                 
    };
    
    //start server
    public void start(){
        //while the server is connected, keep listening to receive incoming messages from clients
        while(true){
            try{
                //accept incoming connections
                Responder reponse = new Responder(requestListener.accept(), textArea);                
                responses.execute(reponse);
                }
            catch (Exception e){
                    
            }
        }
    }
    
    public void getConnection(){
        
        try{ //get connection
           String input = JOptionPane.showInputDialog("Enter Port Number");
            int PORT = Integer.parseInt(input);
            //Invoke the ServerSocket's accept() method to listen on the configured port for a client connection.
            requestListener = new ServerSocket(PORT); 
            //allow multiple clients upto 100
            responses = Executors.newFixedThreadPool(100);
        }
        catch (Exception e){
        try {
                 logging(e.toString());
                 //handle exception here. write it  to logfile
             } catch (IOException ex) {
                 
             }
        }
    }
    //stop server
    public void getDisconnect(){
        try{
           textArea.append("Connection is lost \n");
            requestListener.close();
        }catch (Exception e){

        }
    }
    // executive program
    public static void main(String[] args){
      
        WebServer myServer = new WebServer();    
        myServer.start();    
   
     
    }
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
