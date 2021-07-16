/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermexam;

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
private static MemberShip[] members;
   

 public MemberShip [] getData(String fileName) {  
     
   
     try{
input= new Scanner( new File(fileName));
   }
    catch(FileNotFoundException e)          
          {
        System.out.println("File not found!");
    }
    catch(NoSuchElementException e){
                    System.out.println("File Format Error");
                    //If the file is empty or we read past EOF
                    
    }
   try{
        int size = input.nextInt();
	members = new MemberShip[size];
       //index of array
        int index=0;
        int check =0;
       
			
        while ( input.hasNext() ){
            char membertype = input.next().charAt(check);
            if (membertype =='A') {
               members[index] = new AnnualMemberShip(input.nextInt(), new Date(input.nextInt(),input.nextInt(),input.nextInt()),
               input.next(), new Date(input.nextInt(),input.nextInt(),input.nextInt()),input.nextBoolean(),input.nextFloat()); 
              
            }
            
          else if (membertype =='P') {
               members[index] = new PassCardMembership (input.nextInt(), new Date(input.nextInt(),input.nextInt(),input.nextInt()),
               input.next(),input.nextInt());               
           
                  } 
                                       
        System.out.println("Person Added");
        index++;
        }
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

    
     return members;
    }
}

