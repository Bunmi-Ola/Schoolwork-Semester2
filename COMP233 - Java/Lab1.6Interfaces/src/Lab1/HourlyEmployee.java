/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

/**
 *
 * @author olanrewaju4401
 */
public class HourlyEmployee extends Employee{
    
     private float hourlyRate;
     private float hoursWorked;

    /**
     * @return the hourlyRate
     */
     public HourlyEmployee (String firstname, String lastname, char middlelnit, Date birthdate,
                    int employeeNo, int departmentNo, Project project, float hourlyRate, float hoursWorked){
        
        super.setLastname(lastname);
        super.setFirstname(firstname);
        super.setMiddlelnit(middlelnit);
        super.setBirthdate(birthdate);
        super.setEmployeeNo(employeeNo);
        super.setDepartmentNo(departmentNo);
        super.setProject(project );
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
    }
     
      public HourlyEmployee() {}
      
      
    public float getHourlyRate() {
        return hourlyRate;
    }

    /**
     * @param hourlyRate the hourlyRate to set
     */
    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     * @return the hoursWorked
     */
    public float getHoursWorked() {
        return hoursWorked;
    }

    /**
     * @param hoursWorked the hoursWorked to set
     */
    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
   
     public float getEarnings(){
       float earnings=0;  
    
         if (getHoursWorked() > 80){
        earnings = (getHoursWorked()* getHourlyRate())+((getHoursWorked()-80)*0.5f);	
        }	
         else{
       earnings =getHoursWorked()* getHourlyRate();  }
         
          return earnings;
     }
}
