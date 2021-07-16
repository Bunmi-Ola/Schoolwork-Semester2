

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
    
private static Scanner input;
private static Employee[] employees;
   

 public Employee [] getData(String fileName) {  
   
     try{
input= new Scanner( new File("X:\\Sem 2\\233EmployeeTestData.txt"));
   }
catch (FileNotFoundException fnfe){
	System.out.println("File Not Found");
}  

       
      try{
        
        input = new Scanner (new File (fileName));
        
        int size = input.nextInt();
	employees = new Employee[size];
        
        int index=0;
			
        while ( input.hasNext() ){
        employees[index] = new Employee(input.next(), input.next(),
				 input.next().charAt(0), 
        new Date(input.nextInt(),
        input.nextInt(),
        input.nextInt()),
        input.nextInt(),
        input.nextFloat(),
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
      
      return employees;
}

}
