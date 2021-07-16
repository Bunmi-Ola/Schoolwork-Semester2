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
public class PartTimeStudent extends Student{

    private int numberOfCourses;
    
     public PartTimeStudent() {}
      
   public PartTimeStudent(String lastname, String firstName,  char middleInit, Date birthDate, char gender, int studentNumber, 
           String email, Date registrationDate, int numberOfCourses){
        super.setLastname(lastname); 
        super.setFirstname(firstName);
        super.setMiddlelnit(middleInit);
        super.setBirthdate(birthDate);
        super.setGender(gender);
        super.setStudentNumber(studentNumber);
        super.setEmail(email);
        super.setRegistrationDate(registrationDate);
        setNumberOfCourses(numberOfCourses);
   }

    /**
     * @return the numberOfCourses
     */
    public int getNumberOfCourses() {
        return numberOfCourses;
    }

    /**
     * @param numberOfCourses the numberOfCourses to set
     */
    public void setNumberOfCourses(int numberOfCourses) {
        if (numberOfCourses < 0){
            this.numberOfCourses = 0;
        }
        else{
        this.numberOfCourses = numberOfCourses;
        }
    }
    
    
    @Override
     public float getTuition(){
         
         float Tuition = 0;
         
         if (getRegistrationDate().getYear()>= 2008){
            Tuition = 540* getNumberOfCourses();
         }
         else{
             Tuition = 630* getNumberOfCourses();
         }
        
        return Tuition;	
    }	
 public String writeAsRecord(){
        
      String student = 'P' +" ";
      student+= getLastname() +" ";
      student+= getFirstname() +" ";
      student+= getMiddlelnit() + " ";
      student+= getBirthdate() + " ";
      student+= getGender() + " ";
       student+= getStudentNumber() + " ";
      student+= getEmail() +" ";
      student+= getRegistrationDate() +" ";
      student+= getNumberOfCourses() +"\n"; 
      return student; 
        
    }
}