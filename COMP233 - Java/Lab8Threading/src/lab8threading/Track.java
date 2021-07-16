/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8threading;

import java.util.concurrent.*;


/**
 *
 * @author olanrewaju4401
 */
public class Track {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         
    Horse horses[] = new Horse[3];
    
    ExecutorService race = Executors.newFixedThreadPool(horses.length);
 

	horses[0] = new Horse("Sea Biscuit", true, false, true, false,false, false);
        horses[1] = new Horse("Man o War", false, true, false, false, true, true);
        horses[2] = new Horse("KIT KAT", false, true, false, true, true, true);	
        
        
		  for(int i = 0; i<horses.length; i++)
       {
           if(horses[i].isFrontrunner() == true)
           {
               race.execute(horses[i]);
           }
       }
       for(int i = 0; i<horses.length; i++)
       {
           if(horses[i].isFrontrunner()==false && horses[i].isBobbler() == false)
           {
               race.execute(horses[i]);
           }
       }
       for(int i = 0; i < horses.length; i++)
       {
           if(horses[i].isBobbler() == true)
           {
               race.execute(horses[i]);
           }
       }
       System.out.println("Main method is done");
    }
}
