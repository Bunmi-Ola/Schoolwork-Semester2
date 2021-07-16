/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp233project;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


/**
 *
 * @author olanrewaju4401
 */
public class Responder implements Runnable{
    
        
	private static Socket requestHandler;
	private static Scanner requestReader;
        private static Scanner pageReader;
        private static DataOutputStream pageWriter;
	private static String HTTPMessage;  
	private static String requestedURL;
	
        private static String requestedFile;
	

     public Responder(Socket requestHandler){
      
         setRequestHandler(requestHandler);
    }
        
        
        
        
    public void run(){
         
        }

    /**
     * @return the requestHandler
     */
    public static Socket getRequestHandler() {
        return requestHandler;
    }

    /**
     * @param aRequestHandler the requestHandler to set
     */
    public static void setRequestHandler(Socket aRequestHandler) {
        requestHandler = aRequestHandler;
    }

    /**
     * @return the requestReader
     */
    public static Scanner getRequestReader() {
        return requestReader;
    }

    /**
     * @param aRequestReader the requestReader to set
     */
    public static void setRequestReader(Scanner aRequestReader) {
        requestReader = aRequestReader;
    }

    /**
     * @return the pageReader
     */
    public static Scanner getPageReader() {
        return pageReader;
    }

    /**
     * @param aPageReader the pageReader to set
     */
    public static void setPageReader(Scanner aPageReader) {
        pageReader = aPageReader;
    }

    /**
     * @return the pageWriter
     */
    public static DataOutputStream getPageWriter() {
        return pageWriter;
    }

    /**
     * @param aPageWriter the pageWriter to set
     */
    public static void setPageWriter(DataOutputStream aPageWriter) {
        pageWriter = aPageWriter;
    }

    /**
     * @return the HTTPMessage
     */
    public static String getHTTPMessage() {
        return HTTPMessage;
    }

    /**
     * @param aHTTPMessage the HTTPMessage to set
     */
    public static void setHTTPMessage(String aHTTPMessage) {
        HTTPMessage = aHTTPMessage;
    }

    /**
     * @return the requestedURL
     */
    public static String getRequestedURL() {
        return requestedURL;
    }

    /**
     * @param aRequestedURL the requestedURL to set
     */
    public static void setRequestedURL(String aRequestedURL) {
        requestedURL = aRequestedURL;
    }

    /**
     * @return the requestedFile
     */
    public static String getRequestedFile() {
        return requestedFile;
    }

    /**
     * @param aRequestedFile the requestedFile to set
     */
    public static void setRequestedFile(String aRequestedFile) {
        requestedFile = aRequestedFile;
    }
    
}
