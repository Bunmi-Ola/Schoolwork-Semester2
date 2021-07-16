/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

import java.util.Scanner;

/**
 *
 * @author olanrewaju4401
 */
public class TestProgram {
    
  public static void main(String[] args) {
        
        int choice = 0;
       
        EmployeeProgram program = new EmployeeProgram();
               
        program.GetData("C:\\Users\\Favour\\Desktop\\233EmployeeTestData.txt");
        
       
        do {

            choice = program.showMenu();
            program.executeChoices(choice);

        } while (choice != 5 );
      
  }
}
