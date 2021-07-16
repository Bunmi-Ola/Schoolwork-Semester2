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
public class Person {
    
    private String lastname;
    private String firstname;
    private char middlelnit;
    private Date birthdate;
    private char gender;

    
     public Person() {}
    
    @Override  //optional
    public String toString(){
        
        String person = "Person Data" +"\n";
        person+= "Full name: "+ getLastname() +" " + getFirstname() + " " + getMiddlelnit()+ "\n";
        person+= "Birth Date: "+ birthdate +"\n"; 
        person+= "Gender: "+ getGender() +"\n"; 
        return person;
    }
    
    public String fullName(){
        
        String person = getFirstname() +", " + getLastname()  + " " + getMiddlelnit()+". ";
        
        return person;
    }
    
    public Person (String lastname, String firstname, char middlelnit, Date birthdate,char gender){
          
        setLastname(lastname);
        setFirstname(firstname);
        setMiddlelnit(middlelnit);
        setBirthdate(birthdate);
        setGender(gender);
    }
    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the middlelnit
     */
    public char getMiddlelnit() {
        return middlelnit;
    }

    /**
     * @param middlelnit the middlelnit to set
     */
    public void setMiddlelnit(char middlelnit) {
        this.middlelnit = middlelnit;
    }

    /**
     * @return the birthdate
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * @param birthdate the birthdate to set
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * @return the gender
     */
    public char getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(char gender) {
        this.gender = gender;
    }
   
   
}
