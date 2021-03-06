/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp233;

/**
 *
 * @author barclay7342
 */
public class Date {
    
    private int month;
    private int day;
    private int year;
    
    public Date(){}
    

    /**
     * 
     * @param theMonth
     * @param theDay
     * @param theYear 
     */
    public Date (int theMonth,int theDay, int theYear)
    {
        setMonth(theMonth);
        setDay(theDay);
        setYear(theYear);
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }
    
    public String toString(){
        return getDay() + "/"+getMonth()+"/"+getYear();
    }
    
}
