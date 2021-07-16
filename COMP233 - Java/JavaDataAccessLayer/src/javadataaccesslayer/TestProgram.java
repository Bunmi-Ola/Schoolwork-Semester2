/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadataaccesslayer;


/**
 *
 * @author olanrewaju4401
 */
public class TestProgram {
    
public static void main(String[] args) {
        // TODO code application logic here
         
        int choice = 0;
       
        Lab7Program program = new Lab7Program();
             //connect  
       do {

            choice = program.showMenu();
            program.executeChoices(choice);

        } while (choice != 6 );
       //close conn
    }
}
  