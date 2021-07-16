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
public class Pig extends Animal{
  		public static String noise = "Oink!";
		
		public Pig( String name ){
			super(name);
		}
		
		public String makeNoise(){
			return noise;	
		}
  
}
