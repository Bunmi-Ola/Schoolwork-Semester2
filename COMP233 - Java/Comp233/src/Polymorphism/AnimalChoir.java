/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polymorphism;

import Polymorphism.Pig;
import Polymorphism.Dog;
import Polymorphism.Chicken;

/**
 *
 * @author barclay7342
 */
public class AnimalChoir {
  public static void main( String args[] ){
		
		Animal[] choir = new Animal[10];
		
		choir[0] = new Dog("Fido");
		choir[1] = new Pig("Napoleon");
		choir[2] = new Chicken("Trevor");
		choir[3] = new Pig("Snow Ball");
		choir[4] = new Dog("Snoopy");
		choir[5] = new Chicken("Martin");
		choir[6] = new Pig("Wilbur");
		choir[7] = new Chicken("Gus");
		choir[8] = new Dog("Cujo");
		choir[9] = new Pig("Babe");
		
		
 

		//All the animals sing 
		//(Polymorphic call to makeNoise)
		for( int i=0; i<choir.length; i++)
			System.out.println( choir[i].makeNoise() );
		
		System.out.println("\n");
		
		//And now by name 
		//(Polymorphic call to makeNoise via toString)
		for( int i=0; i<choir.length; i++)
			System.out.println( choir[i] );
		
		System.out.println("\n");
		
		//And now just the chickens!
		//(Down casting array to chickens)
		for( int i=0; i<choir.length; i++)
		   if(choir[i] instanceof Chicken)
			System.out.println( choir[i].toString() );
			
		System.out.println("\n");		
		//Let the dogs say Bark
		Dog.noise="Bark!";
		for( int i=0; i<choir.length; i++)
		   if(choir[i] instanceof Dog)
   {
			 

System.out.println( choir[i].toString() );

System.out.println( 
 ((Dog)choir[i]).markTerritory("Hydrant") );

             }		

}
}