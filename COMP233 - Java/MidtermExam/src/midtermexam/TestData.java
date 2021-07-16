/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermexam;

/**
 *
 * @author olanrewaju4401
 */
public class TestData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         
        int choice = 0;
       
        ClientProgram program = new ClientProgram();
               
        program.GetData("X:\\Sem 2\\MTTestData.txt");
        
       
        do {

            choice = program.showMenu();
            program.executeChoices(choice);

        } while (choice != 6 );
      
  }
    
}
