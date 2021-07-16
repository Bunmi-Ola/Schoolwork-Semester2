/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Favour
 */
public class Person {
    private String lastname;
    private String firstname;
    private char middlelnit;
    private Date birthdate;

    public Person() {}
    
    @Override  //optional
    public String toString(){
        
        String person = "Person Data" +"\n";
        person+= "Full name: "+ getFullName() +"\n";
        person+= "Birth Date: "+ birthdate +"\n"; 
        return person;
    }
    
    public Person (String lastname, String firstname, char middlelnit, Date birthdate) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.middlelnit = middlelnit;
        this.birthdate = birthdate;   
    }
    
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public char getMiddlelnit() {
        return middlelnit;
    }

    public void setMiddlelnit(char middlelnit) {
        this.middlelnit = middlelnit;
    }
    
    public Date getBirthdate() {
        return birthdate;
    }
   
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    
    public String getFullName() {
        return lastname + ", " +firstname + " " + middlelnit;
    }
    
    public String displayFormattedDate() {
        String Date = "Birth Date is" + " " +birthdate;
        
        return Date;
    }
}
