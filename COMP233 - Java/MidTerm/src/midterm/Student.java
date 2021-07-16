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
public abstract class Student extends Person implements Comparable{
    
    private int studentNumber ;
    private String email ;
    private Date registrationDate ;
    
    
      public Student() {}
      
   public Student(String lastname, String firstName,  char middleInit, Date birthDate, char gender, int studentNumber, 
           String email, Date registrationDate){
        super.setLastname(lastname); 
        super.setFirstname(firstName);
        super.setMiddlelnit(middleInit);
        super.setBirthdate(birthDate);
        super.setGender(gender);
        setStudentNumber(studentNumber);
        setEmail(email);
        setRegistrationDate(registrationDate);
   }
    /**
     * @return the studentNumber
     */
    public int getStudentNumber() {
        return studentNumber;
    }

    /**
     * @param studentNumber the studentNumber to set
     */
    public void setStudentNumber(int studentNumber) {
        if (studentNumber< 0){
            System.out.println("Invalid Number");
        }
        else{
        this.studentNumber = studentNumber;
        }
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        
        if (email == ""){
            this.email = "noMail@school.org";
        }
        else{
        this.email = email;
        }
    }

    /**
     * @return the registrationDate
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     * @param registrationDate the registrationDate to set
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
  
   
    public abstract float  getTuition();
    
      public int compareTo(Object o)
    {
    Student s = (Student)o;
    if(s.getStudentNumber()== this.getStudentNumber())
    {
        return 0;
    }
    if(s.getStudentNumber()< this.getStudentNumber())
    {
        return 1;
    }
    return -1;
    }
      
     
    public String ToString(){
        return getStudentNumber()+"   "+ super.toString()+"     "+ getTuition();
    }
}
