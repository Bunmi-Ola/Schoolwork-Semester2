

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lab1;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;


/**
 *
 * @author olanrewaju4401
 */
public class PersonFileHandler {
    
private static Person[] people;
private static Scanner input;

   

 public Person [] getData(String fileName) {  
   
        File filename = new File (fileName);       
              
      try{
        
        input = new Scanner (filename);
        
        int size = input.nextInt();
	people = new Person[size];
        
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

    }
    catch(FileNotFoundException e)          
          {
        System.out.println("File not found!");
    }
      
      return people;
}

}
