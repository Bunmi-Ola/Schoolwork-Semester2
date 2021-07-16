/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp233threading;
import java.util.concurrent.*;
/**
 *
 * @author barclay7342
 */
public class Comp233Threading {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ARunnable t1 = new ARunnable("Thread1");
	ARunnable t2 = new ARunnable("Thread2");
        ARunnable t3 = new ARunnable("Thread3");
		
		ExecutorService runThreads =  Executors.newFixedThreadPool(2);
		
		runThreads.execute(t1);
		runThreads.execute(t2);
                runThreads.execute(t3);
		
		System.out.println("Main method is done");

    }
    
}
