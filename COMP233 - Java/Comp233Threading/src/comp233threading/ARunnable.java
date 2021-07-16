/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp233threading;


/**
 *
 * @author barclay7342
 */
public class ARunnable extends Thread{
    private String name;
	
	public ARunnable(String name){
		this.name=name;
	}

	public void run(){
            //Basic process
//		System.out.println(name + " has started");
//                                
//		for(int i=0; i<400000000; i++);
//		System.out.println(name + " has finished");
                
            //Sleeping Threads
//                System.out.println(name + " has started");
//		for(int i=0; i<80000000; i++);
//		
//                try{
//                    Thread.sleep( (int)(Math.random()*10000)+1);
//		}
//		catch(InterruptedException ie){
//                    System.out.println( ie.toString() );	
//		}
//			
//		System.out.println(name + " has finished");

            //Thread Priority
                int priority = (int)(Math.random()*10)+1;
                
              System.out.println("Setting "+name+" priority to:  "  +priority); 
		setPriority( priority );
		
		System.out.println(name + " has started");
		for(int i=0; i<100000000; i++);
		System.out.println(name + " has finished");

                
	}

}
