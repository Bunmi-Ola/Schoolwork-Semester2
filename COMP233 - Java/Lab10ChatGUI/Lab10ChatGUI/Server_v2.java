/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab10ChatGUI;
import java.util.*;
import java.io.*;
import java.net.*;

/**
 *
 * @author delacruz9572
 */
public class Server_v2 {

    static String messageIn;
    static String messageOut;
    static Scanner keyboardInput;

    static ServerSocket server;
    static Socket connection;

    static ObjectOutputStream output;
    static ObjectInputStream input;
    static boolean Conn = true;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(12345, 100);
            keyboardInput = new Scanner(System.in);

            System.out.println("Waiting for client to connect...");
            
            do {
                
                connection = server.accept();
                System.out.println("Client connected!");

                output = new ObjectOutputStream(connection.getOutputStream());
                output.flush();
                input = new ObjectInputStream(connection.getInputStream());

                do {
                    messageIn = (String) input.readObject();
                    if (messageIn.equalsIgnoreCase("<OUT>")) {
                        Conn = true;
                        break;
                    }
                    System.out.println("Client Says: " + messageIn);
                } while (messageIn.equalsIgnoreCase("<OVER>") == false);

//                if (Conn == false) {
//                    output.writeObject("<OUT>");
//                    output.flush();
//                    break;
//                }
                System.out.println("Response: ");

                do {
                    messageOut = keyboardInput.nextLine();

                    if (messageOut.equalsIgnoreCase("<OUT>")) {
                        Conn = false;
                        break;
                    }
                    output.writeObject(messageOut);
                    output.flush();
                } while (messageOut.equalsIgnoreCase("<OVER>") == false);

                if (Conn == false) {
                    output.writeObject("<OUT>");
                    output.flush();
                    break;
                }
                //System.out.println("Waiting for client to connect...");
            } while (Conn = true);
            
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.toString());
        }
    }
}
