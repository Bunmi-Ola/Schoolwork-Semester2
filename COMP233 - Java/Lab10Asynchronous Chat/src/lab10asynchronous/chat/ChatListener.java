/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10asynchronous.chat;

/**
 *
 * @author olanrewaju4401
 */
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.lang.*;
/**
 *
 * @author delacruz9572
 */
class ChatListener implements Runnable{
    private ObjectInputStream input;
    private JTextArea chatOutput;
    
    //public ChatListener(){}
    
    public ChatListener(ObjectInputStream input, JTextArea chatOutput){
        setInput(input);
        setChatOutput(chatOutput);
    }
    
    public ObjectInputStream getInput() {
        return input;
    }

    public void setInput(ObjectInputStream input) {
        this.input = input;
    }

    public JTextArea getChatOutput() {
        return chatOutput;
    }

    public void setChatOutput(JTextArea chatOutput) {
        this.chatOutput = chatOutput;
    }
    
    @Override
        public void run(){
            try{
                while(true){
                    String messageIn = (String)(input.readObject() + "\n");
                    chatOutput.append(messageIn);
                }

            }catch(Exception e){
                System.out.println(e.toString());
            }
        }
 
    }
