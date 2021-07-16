/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm;

import java.util.Scanner;

/**
 *
 * @author Favour
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author olanrewaju4401
 */

public class ClientProgram {
      Scanner input = new Scanner(System.in);
    
    static Student[] students;    
    
 
 public void GetData(String FileName) {
        PersonFileHandler PP = new PersonFileHandler ();
        students = PP.getData(FileName);
        
      
     }
 
  public int showMenu(){
         
      int choice = 0;   
      System.out.print("\n"
     + "Menu Option\n"
     + " 1. Display name and tuition fees for all students in sorted order\n"
     + " 2. Display students by year\n"
     + " 3. Display Student Centre Member Mail List \n"
     + " 4. Part Time to Full Time Transfer \n"
     + " 5. Reload Data\n"
     + " 6. Delete\n"
     + " 7. Exit\n"         
     + " Please make a selection:\n");
     
      choice = input.nextInt();  
     
      return choice;
    }
   public void executeChoices(int choice) {

        if (choice == 1) {            
            menuOption1();
        }
        
         if (choice == 2) {        
            menuOption2();
        }
         if (choice == 3) {        
            menuOption3();
        }
         if (choice == 4) {        
            menuOption4();
        }
         if (choice == 5) {        
            reloadData("X:\\Sem 2\\examTestData.txt");
        }
          if (choice == 6) {        
            menuOption6();
        }
         if (choice == 7) {        
            System.out.println("Exit");
        }
        rangeCheck(choice, 1, 7);
    }
   
    public void menuOption1() {
        System.out.println("Student Number" + "\t\t" + "Name"+ "\t\t\t" + "Tuition");
        System.out.println("------------------------------------------------------");
         Arrays.sort(students);
          for (int i = 0; i <students.length; i++){
            System.out.println(students[i].getStudentNumber() + "\t\t "+ students[i].fullName()+ "\t\t\t"+ students[i].getTuition() );          
          
          }
              System.out.println("-------------------------------------------------");
        }
    
     public void menuOption2(){
         int choice =0;
        
   String[] rank = {"Junior", "Intermediate","Senior"};
   for (int i = 0; i < rank.length; i++){
            System.out.println(i+1 + ": " + rank[i] + "\n");
   }
            System.out.println("\n Please choose an option to display by year");
             choice = input.nextInt();
             if (choice ==1) {
                  System.out.println("Junior List:" + "\n" + "Student Number" + "\t\t" + "Name");
                  System.out.println("-------------------------------------------------");
                 for (int i = 0; i < students.length; i++) {
                    if (students[i].getRegistrationDate().getYear()==2013){
                     System.out.println(""+students[i].getStudentNumber()+"\t\t"+students[i].fullName());
                 }
                 }
             }
            
        if (choice ==2) {
                   System.out.println("Intermediate List:" + "\n" + "Student Number" + "\t\t" + "Name");
                  System.out.println("-------------------------------------------------");
                 for (int i = 0; i < students.length; i++) {
                    if (students[i].getRegistrationDate().getYear()==2012){
                     System.out.println(""+students[i].getStudentNumber()+"\t\t"+students[i].fullName());
                 }
                 }
                 }
        
        if (choice ==3) {
                  System.out.println("Senior List:" + "\n" + "Student Number" + "\t\t" + "Name");
                  System.out.println("-------------------------------------------------");
                 for (int i = 0; i < students.length; i++) {
                    if (students[i].getRegistrationDate().getYear()==2011){
                    System.out.println(""+students[i].getStudentNumber()+"\t\t"+students[i].fullName());
                 }             
             }}
              } 
      public void menuOption3(){
          System.out.println("Student Centre Mail List:" );
         for (int i = 0; i < students.length; i++) {
             if ((students[i] instanceof FullTimeStudent)&&(((FullTimeStudent)students[i]).isStudentCentreOptOut()==false))
                     {
                         System.out.println(""+students[i].getEmail());                
             }
             }          
             }
       public void menuOption4(){
              int number = 0;
              Student [] newFTS = new FullTimeStudent[1];
              int StudentNumber = 0;
              String lastName = "";
              String firstName = "";
              char middleLnit = 'A';
              Date Birthday =  new Date(1, 1, 2019);
              char gender = 'A';
              String email = "";
              Date registrationDate = new Date(1, 1, 2019);
              boolean insuranceOptOut = true;
              boolean studentCentreOptOut = false;
              
              System.out.println("Please Enter The student number");
              number = input.nextInt();
              for (int i = 0; i < students.length; i++) {
                  
                    if (students[i] instanceof FullTimeStudent) {  
                      if ( ((FullTimeStudent)students[i]).getStudentNumber()== number)
                  {
                    System.out.println(students[i].fullName() + " was already a Full Time Student");
                       
                   }  
                   }
                  if (students[i] instanceof PartTimeStudent) {                      
                 
                  if ( ((PartTimeStudent)students[i]).getStudentNumber()== number)
                  {
                      StudentNumber = number;
                      lastName = students[i].getFirstname();
                      firstName = students[i].getLastname();
                      middleLnit = students[i].getMiddlelnit();
                      Birthday = students[i].getBirthdate();
                      gender = students[i].getGender();
                      email = students[i].getEmail();
                      registrationDate = students[i].getRegistrationDate();
               students[i] =   new FullTimeStudent (lastName, firstName, middleLnit, Birthday,gender, StudentNumber,
                          email,registrationDate, insuranceOptOut, studentCentreOptOut);
            System.out.println(students[i].fullName() + " is now a Full Time Student with a Student Centre Membership.");
                  }
              }
                 
            }

//            newFTS[0] =   new FullTimeStudent (lastName, firstName, middleLnit, Birthday,gender, StudentNumber,
//                          email,registrationDate, insuranceOptOut, studentCentreOptOut);
//               Student[] tempStudent = new Student[students.length+1];
//               System.arraycopy(students, 0, tempStudent, 0, students.length);
//               System.arraycopy(newFTS, 0, tempStudent, students.length, newFTS.length); 
//                students = tempStudent;
              reloadData("X:\\Sem 2\\examTestData.txt");
       }
      
       public void reloadData (String FileName) {
         
             //the file writer allow you to make adjustment to a file. the false is to allow its to accept to write over
             //print writer is t
              
          try {
               FileWriter fw = new FileWriter(FileName, false);
         
               PrintWriter writer = new PrintWriter(fw);
               writer.println(students.length);
              for (int i = 0; i < students.length; i++) {                
             if (students[i] instanceof FullTimeStudent){
              writer.println("" + ((FullTimeStudent)students[i]).writeAsRecord());
              }
              if (students[i] instanceof PartTimeStudent){
              writer.println("" + ((PartTimeStudent)students[i]).writeAsRecord());
              }
              }
              writer.close();
               } 
              catch (IOException ex) {
              Logger.getLogger(ClientProgram.class.getName()).log(Level.SEVERE, null, ex);         
               
               }  
              
       }

          public int rangeCheck(int UserInput, int min, int max) {
        do {
            if (min > UserInput || max < UserInput) {
                System.out.println("Invalid entry. Please enter a number between " + min + " and " + max);
                break;
            }

        } while (min > UserInput || max < UserInput);
        return UserInput;

    }
          
      public void menuOption6(){
         int number = 0;
             
              System.out.println("Please Enter The student number");
              number = input.nextInt();
              int currentLength = students.length;
              for (int i = 0; i < students.length; i++) {
            if (students[i].getStudentNumber()== number){
                   students[i] = students[currentLength - 1];
                     currentLength--;
                 break; 
                 
             }
            if (i == currentLength - 1) {
           System.out.println("That requested students is remove.");
             }          
           }
      }
}
         
