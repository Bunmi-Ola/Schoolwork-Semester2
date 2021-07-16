/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PolymorphismAssignment;

import comp233.*;

public class Person {
    private String lastName;
    private String firstName;
    private char middleInt;
    private Date birthDate;

public Person(){}


public Person(String lastName, String firstName, char middleInit ,Date birthDate){
    setLastName(lastName);
    setFirstName(firstName);
    setMiddleInit(middleInit);
    setBirthdate(birthDate);
    
}

//methods
public String getFullName(){
    String fullname = this.lastName +", "+this.firstName +" " +this.middleInt +".";
    
    return fullname;
    
}


//setters
public void setLastName(String lastName){
    this.lastName = lastName;
}
public void setFirstName(String firstName){
    this.firstName = firstName;
}
public void setMiddleInit(char mi){
    this.middleInt = mi;
}
public void setBirthdate(Date bd){
    this.birthDate = bd;
}

//getters

public String getLastName(){
    return this.lastName;
}

public String getFirstName(){
    return this.firstName;
}

public char getMiddleInit(){
    return this.middleInt;
}

public Date getBirthdate()
{
    return this.birthDate;
}
        
        
}//end Person Class.


