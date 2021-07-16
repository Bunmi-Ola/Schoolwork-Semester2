/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8threading;

/**
 *
 * @author olanrewaju4401
 */
public class Horse extends Thread implements Runnable{
    
   private String horseName;  
   private static volatile int[] position = new int[4]; 
   private boolean frontrunner;  //fast out of the gate
   private boolean bobbler; //slow out of the gate
   private boolean mudder; //runs well in the mud
   private boolean falterer; //slows at the end of a race
   private boolean sleepy; //falls asleep on the track sometimes
   private boolean hopped; //on steroids 

  
   
    public  Horse(String horseName, boolean frontrunner, boolean bobbler, boolean mudder, boolean falterer,
            boolean sleepy, boolean hopped) {
       
        setHorseName(horseName);
        setFrontrunner(frontrunner);
        setBobbler(bobbler);
        setMudder(mudder);
        setFalterer(falterer);
        setSleepy(sleepy);
        setHopped(hopped);
    }
    
     public Horse() {

    }
      public String getHorseName() {
        return horseName;
    }

    /**
     * @param horseName the horseName to set
     */
    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public synchronized static void incrementPosition(int x) {
        
            position[x]++;
    }  
  
       
    public void frontrunner() {
        this.setFrontrunner(true);
    }
      
     public void bobbler() {
         this.setBobbler(true);
    }
        
    /**
     * @return the position
     */
     public static void setPosition(int[] aPosition) {
        position = aPosition;
    }

//    /**
//     * @param aPosition the position to set
//     */
//    public int getPosition(int position) {
//        return this.position[position];
//    }


    /**
     * @return the frontrunner
     */
    public boolean isFrontrunner() {
        return frontrunner;
    }

    /**
     * @param frontrunner the frontrunner to set
     */
    public void setFrontrunner(boolean frontrunner) {
        this.frontrunner = frontrunner;
    }

    /**
     * @return the bobbler
     */
    public boolean isBobbler() {
        return bobbler;
    }

    /**
     * @param bobbler the bobbler to set
     */
    public void setBobbler(boolean bobbler) {
        this.bobbler = bobbler;
    }

    /**
     * @return the mudder
     */
    public boolean isMudder() {
        return mudder;
    }

    /**
     * @param mudder the mudder to set
     */
    public void setMudder(boolean mudder) {
        this.mudder = mudder;
    }

    /**
     * @return the falterer
     */
    public boolean isFalterer() {
        return falterer;
    }

    /**
     * @param falterer the falterer to set
     */
    public void setFalterer(boolean falterer) {
        this.falterer = falterer;
    }

    /**
     * @return the sleepy
     */
    public boolean isSleepy() {
        return sleepy;
    }

    /**
     * @param sleepy the sleepy to set
     */
    public void setSleepy(boolean sleepy) {
        this.sleepy = sleepy;
    }

    /**
     * @return the hopped
     */
    public boolean isHopped() {
        return hopped;
    }

    /**
     * @param hopped the hopped to set
     */
    public void setHopped(boolean hopped) {
        this.hopped = hopped;
    }

    public synchronized int getposition(int leg){
        position[leg]++;
        return  position[leg];
                
    }
    
    
  public void run() {
      
        hopped();
        System.out.println(this.getHorseName() + " is out of the gate\n");
       
        
        for (int i = 0; i < 200000000; i++);
//        incrementPosition(0);
        System.out.println(this.getHorseName() + " is finished the first leg in " + getposition(0) + " position!\n");

        if (isSleepy() == true) {
            sleep();
        }
        
        if (isMudder() == true) {
            for (int i = 0; i < 120000000; i++);
//            incrementPosition(1);

            System.out.println(this.getHorseName() + " is finished the second leg in " + getposition(1) + " position !\n");
        } else {
            for (int i = 0; i < 200000000; i++);
//            incrementPosition(1);

            System.out.println(this.getHorseName() + " is finished the second leg in " + getposition(1) + " position !\n");

        }

     
        if (isFalterer() == true) {
            for (int i = 0; i < 250000000; i++);

//            incrementPosition(2); 
            System.out.println(this.getHorseName() + " is finished the third leg in " + getposition(2) + " position !\n");
        } else {
            for (int i = 0; i < 200000000; i++);
//            incrementPosition(2);
            System.out.println(this.getHorseName() + " is finished the third leg in " + getposition(2) + " position!\n");
        }

        if (isSleepy() == true) {
            sleep();
        }
        if (isFalterer() == true) {

            for (int i = 0; i < 300000000; i++);
//            incrementPosition(3);
            System.out.println(this.getHorseName() + " is on the position in " + getposition(3) + " position!\n");
        } else {
            for (int i = 0; i < 200000000; i++);
//            incrementPosition(3);
            System.out.println(this.getHorseName() + " is on the position in " + getposition(3) + " position!\n");
        }

    }

    void sleep() {
        if (this.isSleepy()) {
            int x = (int) (Math.random() * 10) + 1;
            if (x <= 2) {
                System.out.println("\nOh no! "+ this.getHorseName() + " is asleep on the track!");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                    System.out.println(ie);
                }

                System.out.println("\n" + this.getHorseName() + " is now awake and back in the race!\n");
            }
        }
    }
    
  

    /**
     * @param horseName the horseName to set
     */
   
    void hopped() {
        if (this.isHopped() == true) {
            setPriority(7); // priority 1 is low, 10 is high. 5 regular 
            System.out.println(this.getHorseName() + " seems full of energy today\n");
        }
    }

  
  
}