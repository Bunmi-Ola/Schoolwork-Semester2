/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp233;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonProgram {
    public static Scanner input;
    public static Person[] people;
    
    //constructor
    public PersonProgram(){
       input = new Scanner(System.in);
    }
    
    public void getData(){
    Employee[] employee = new Employee[1];
    employee[0] = new Employee("Michael","Barclay",'J',new Date(23,01,1987),123,1200,new Date(23,01,1997));
    
    people = new Person[5];
    people[0] = new Person("Barclay","Michael",'J',new Date(23,01,1987));
    people[1] = new Person("Johnson","Sam",'G',new Date(14,12,1987));
    people[2] = new Person("Stevens","Frank",'J',new Date(13,10,1977));
    people[3] = new Person("Simons","Jules",'D',new Date(20,01,1997));
    people[4] = new Person("McAdams","Mary",'K',new Date(02,03,1967));
    
    List<Person> p;
    
    }
    
    public void getData(String filename){
        PersonFileHandler pfh = new PersonFileHandler();
         people = pfh.getData(filename);
    }
    
    public int showMenu(){
        int choice = 0;
        System.out.println("---------------------------------------------");
        System.out.println("1. Display all names");
        System.out.println("2. Display info for person by number");
        System.out.println("3. Edit information for person by number");
        System.out.println("4.Exit");
        System.out.println("Enter a Choice:");
        choice = input.nextInt();
       if (choice > 4){
           System.out.println("Out of bounds!");
           showMenu();}
       else{
       return choice;
       }
               
       return choice;
    }
    
    public void executeChoice(int choice){
        //could also use a nested if
        switch(choice){
            case 1: menuOption1();
                break;
            case 2: menuOption2();
                break;
            case 3: menuOption3();
                break;
            case 4: menuOption4();
                break;                
        }//end switch
    }//end choice
    
    public void menuOption1(){
        System.out.println("All the names in the system are as follows:");
        for(int i=0;i<people.length;i++){
            System.out.println(i+1+". "+ people[i].getFullName());
            System.out.println("     Bday: "+ people[i].getBirthdate().toString());
        }
        executeChoice(showMenu());
    }
    
    public void menuOption2(){
        
    }
    
    public void menuOption3(){
    
    }
    
    public void menuOption4(){
    
    }
    
    //main method
    public static void main(String[] args) {
        // TODO code application logic here
      PersonProgram pp = new PersonProgram();
      pp.getData("C:\\Users\\barclay7342\\OneDrive - Saskatchewan Polytechnic\\Classes\\Comp233\\MikesSolution\\Comp233\\233PersonTestData.txt");
      pp.executeChoice(pp.showMenu());
    }
    
    
}
