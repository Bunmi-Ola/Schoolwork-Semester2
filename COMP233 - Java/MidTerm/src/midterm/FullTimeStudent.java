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
public class FullTimeStudent extends Student{
    
    private boolean insuranceOptOut;
    private boolean studentCentreOptOut;

    
     public FullTimeStudent() {}
      
   public FullTimeStudent(String lastname, String firstName,  char middleInit, Date birthDate, char gender, int studentNumber, 
           String email, Date registrationDate, boolean insuranceOptOut, boolean studentCentreOptOut){
        super.setLastname(lastname); 
        super.setFirstname(firstName);
        super.setMiddlelnit(middleInit);
        super.setBirthdate(birthDate);
        super.setGender(gender);
        super.setStudentNumber(studentNumber);
        super.setEmail(email);
        super.setRegistrationDate(registrationDate);
        setInsuranceOptOut(insuranceOptOut);
        setStudentCentreOptOut(studentCentreOptOut);
   }

   
   
    /**
     * @return the insuranceOptOut
     */
    public boolean isInsuranceOptOut() {
        return insuranceOptOut;
    }

    /**
     * @param insuranceOptOut the insuranceOptOut to set
     */
    public void setInsuranceOptOut(boolean insuranceOptOut) {
        this.insuranceOptOut = insuranceOptOut;
    }

    /**
     * @return the studentCentreOptOut
     */
    public boolean isStudentCentreOptOut() {
        return studentCentreOptOut;
    }

    /**
     * @param studentCentreOptOut the studentCentreOptOut to set
     */
    public void setStudentCentreOptOut(boolean studentCentreOptOut) {
        this.studentCentreOptOut = studentCentreOptOut;
    }
    
      public float getTuition(){
         
         float Tuition = 4250;
         
         if (isInsuranceOptOut() == false){
             Tuition -=235;
         }
         if(isStudentCentreOptOut()== false){
             
               Tuition -= 125;
         }
         
         return Tuition;
      }
      
      public String writeAsRecord(){
        
      String student = 'F' +" ";
      student+= getLastname() +" ";
      student+= getFirstname() +" ";
      student+= getMiddlelnit() + " ";
      student+= getBirthdate() + " ";
      student+= getGender() + " ";
       student+= getStudentNumber() + " ";
      student+= getEmail() +" ";
      student+= getRegistrationDate() +" ";
      student+= isInsuranceOptOut() +" ";
      student+= isStudentCentreOptOut() +"\n"; 
      return student; 
        
    }
    public String ToString(){
        return getStudentNumber()+" "+ super.toString()+" "+ isInsuranceOptOut()+" "+ isStudentCentreOptOut();
    }  
}
