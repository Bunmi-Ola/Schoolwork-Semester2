/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author barclay7342
 */
public class Glasses implements Comparable{

    private int volume;
    private int diameter;
    private String material;
    
    
    //Constructors
    Glasses(int v, int d, String m){
        setVolume(v);
        setDiameter(d);
        setMaterial(m);
    }
    
    //Blank Constructor
    Glasses(){}
    
    
    //This compare on volume
    public int compareTo(Object o){
        Glasses g = (Glasses)o;
        if(g.getVolume() > this.getVolume()){
            return 1;
        }
        if(g.getVolume() == this.getVolume()){
            return 0;
        }
        return -1;
    }
    
    
    /**
     * @return the volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * @return the diameter
     */
    public int getDiameter() {
        return diameter;
    }

    /**
     * @param diameter the diameter to set
     */
    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    /**
     * @return the material
     */
    public String getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(String material) {
        this.material = material;
    }
    
    
    
}
