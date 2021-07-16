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
public class SalaryEmployee extends Employee{
    
    private float monthlySalary;

    /**
     * @return the monthlySalary
     */
    public SalaryEmployee (String firstname, String lastname, char middlelnit, Date birthdate,
                    int employeeNo, int departmentNo, Project projectNo, float monthlySalary) {
        
        super.setLastname(lastname);
        super.setFirstname(firstname);
        super.setMiddlelnit(middlelnit);
        super.setBirthdate(birthdate);
        super.setEmployeeNo(employeeNo);
        super.setDepartmentNo(departmentNo);
        super.setProject(projectNo );
        setMonthlySalary(monthlySalary);
    }
    
    
     public SalaryEmployee() {}
     
     
    public float getMonthlySalary() {
        return monthlySalary;
    }

    /**
     * @param monthlySalary the monthlySalary to set
     */
    public void setMonthlySalary(float monthlySalary) {
        this.monthlySalary = monthlySalary;
    }   
        
   
    
     public float getEarnings(){
        return (getMonthlySalary()/52)*2;	
    }	
}
