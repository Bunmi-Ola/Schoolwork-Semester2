/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polymorphism;


import Polymorphism.Animal;

/**
 *
 * @author barclay7342
 */
public class Dog extends Animal {
    public static String noise = "Woof!";
		
		public Dog( String name ){
			super(name);
		}
		
		public String makeNoise(){
			return noise;	
		}

		public String markTerritory(String s)
                {
                  return getName() + " just peed on " + s;
                } 

}
