/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.Arrays;


/**
 *
 * @author barclay7342
 */
public class InterfaceDemo {
    
    public static void main( String args[] ){
        Glasses[] g = new Glasses[5];
    
        g[0] = new Glasses(10,10,"Glass");
        g[3] = new Glasses(9,12,"Glass");
        g[2] = new Glasses(8,13,"Glass");
        g[4] = new Glasses(7,14,"Plastic");
        g[1] = new Glasses(6,15,"Glass");     
        
        System.out.println("Not Sorted");
        System.out.println("###############################");
        
        for(int i=0; i < g.length; i++){
            System.out.println("Glass Number: "+i+" Volume:"+ g[i].getVolume());
        }
        
        Arrays.sort(g);
        System.out.println("Sorted!");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        for(int i=0; i < g.length; i++){
          System.out.println("Glass Number: "+i+" Volume:"+ g[i].getVolume());
        }
        
   
        
        
     }
            
}
