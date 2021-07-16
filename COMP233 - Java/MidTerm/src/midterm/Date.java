/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm;

/**
 *
 * @author Favour
 */
public class Date {
   private int month;
    private int day;
    private int year;

    
  public Date (int month, int day, int year) {
        this.month = month;
        this.day = day;        
        this.year = year;   
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
        if ( month >= 1 || month <=12)
        this.month = month;
        else
         System.out.println("Invalid month");
        this.month = 1;
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
       // For months with 30 days.
    if ((month == 4 || month == 6 || month == 9|| month == 11) && (day <= 30&& day >= 1)){
        this.day = day;
    }
    // For months with 31 days.
    else if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) 
            && (day <= 31 && day >= 1)){
        this.day = day;
    }
    // For leap years when February have 29 days...
    else if (month == 2 && (day <= 29 && day >= 1))
    {
        // Check if year is a leap year.
        if ((year%4 == 0 && year%100!=0) || year%400 == 0) 
        {
            this.day = day;
        }
        else {
         System.out.println("Invalid day");
         this.day = 1;
        }
    }
    else if (month == 2 && (day <= 28 && day >= 1))
    {
         this.day = day;
    }
    else {
        System.out.println("Invalid day");
        this.day = 1;
    }
      
  
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
        
        String date = month+" ";
        date+= day +" ";
        date+= year ;       
        
        return date;
    }
}
