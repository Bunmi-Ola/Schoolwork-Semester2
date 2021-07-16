/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

/**
 *
 * @author olanrewaju4401
 */
public class TestPersonProram { 
    
    public static void main(String[] args) {
        
        int choice = 0;
       
        PersonProgram program = new PersonProgram();
               
        program.GetData("X:\\Sem 2\\233PersonTestData.txt");
        
       
        do {

            choice = program.showMenu();
            program.executeChoices(choice);

        } while (choice != 5 );
      
  }
}