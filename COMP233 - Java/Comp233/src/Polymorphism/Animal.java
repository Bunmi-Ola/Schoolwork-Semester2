/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polymorphism;

/**
 *
 * @author barclay7342
 */
public abstract class Animal {
 private String name;
	
	public Animal(String name){
		setName(name);
	}
	
	public void setName(String name){
		this.name=name;		
	}	
	
	public String getName(){
		return name;	
	}
	
	public abstract String makeNoise();

	
	public String toString(){
	
		return getName() + " says " + makeNoise();
		
	}
	
}
