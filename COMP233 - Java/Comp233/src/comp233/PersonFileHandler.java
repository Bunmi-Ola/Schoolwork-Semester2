/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp233;

import java.io.*;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PersonFileHandler {

    static Person[] people;
    static Scanner input;
     
    
     public static Person[] getData(String fileName){
           
           try {
            input = new Scanner(new File(fileName));
        
        } catch (FileNotFoundException fnfe) {
            System.out.println("File Not Found");
        } catch (IOException ioe) {
            System.out.println("Unkown IO error has occurred");
        } catch (Exception e) {
            System.out.println("An unkown error has occurred");
        }
        
        people = new Person[getSize(fileName)];
         int index=0;

            while ( input.hasNext() ){
            people[index] = new Person(input.next(), input.next(),
                                             input.next().charAt(0), 
             new Date(input.nextInt(),
            input.nextInt(),
            input.nextInt())
                                            );
                    System.out.println("Person Added");
                    index++;
            }
            return people;
        }

     public static int getSize(String fileName){
        try {
            input = new Scanner(new File(fileName));
        
        } catch (FileNotFoundException fnfe) {
            System.out.println("File Not Found");
        } catch (IOException ioe) {
            System.out.println("Unkown IO error has occurred");
        } catch (Exception e) {
            System.out.println("An unkown error has occurred");
        }
        try{
            int size = input.nextInt();
                    people = new Person[size];
                 return size;           
            }
        catch(NoSuchElementException e){
                            System.out.println("File Format Error");
                            //If the file is empty or we read past EOF
            }
        catch(IllegalStateException ise){
                            System.out.println("Error Reading Error");
                            //If the file is deleted or closed before we 
                            //Have a chance to read from it.			
            }
        return -1;
     }
}
