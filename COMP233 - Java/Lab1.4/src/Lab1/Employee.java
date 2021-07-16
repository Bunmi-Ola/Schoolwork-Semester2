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
public class Employee extends Person{
    
    private int employeeNo;
    private float monthlySalary;   
    private Date hireDate;
    Person lastname;
    Person firstname;
    Person middlelnit;
    Date birthdate;
    /**
     * @return the employeeNo
     */
    public Employee() {}
    
    
    public Employee (String firstname, String lastname, char middlelnit, Date birthdate,
                    int employeeNo, float monthlySalary, Date hireDate) {
        
        super.setLastname(lastname);
        super.setFirstname(firstname);
        super.setMiddlelnit(middlelnit);
        super.setBirthdate(birthdate);
        setEmployeeNo(employeeNo);
        setMonthlySalary(monthlySalary);
        setHireDate(hireDate);
    }
    
    public int getEmployeeNo() {
        return employeeNo;
    }

    /**
     * @param employeeNo the employeeNo to set
     */
    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }

    /**
     * @return the monthlySalary
     */
    public float getMonthlySalary() {
        return monthlySalary;
    }

    /**
     * @param monthlySalary the monthlySalary to set
     */
    public void setMonthlySalary(float monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    /**
     * @return the hireDate
     */
    public Date getHireDate() {
        return hireDate;
    }

    /**
     * @param hireDate the hireDate to set
     */
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
    
    public String toString(){
        
        String employee = "Employee Details" +"\n";        
        employee+= "Employee Number: " + employeeNo +"\n";
        employee+= "Employee Last Name: " + getLastname() +"\n";
        employee+= "Employee First Name: " + getFirstname() +"\n";
        employee+= "Employee middle lnitial: " + getMiddlelnit() +"\n";
        employee+= "Employee Birthdate: " + getBirthdate() +"\n";
        employee+= "Monthly Salary: "+ getMonthlySalary() +"\n";
        employee+= "Hire Date: "+ getHireDate() +"\n"; 
        return employee;
    }
    
     public String writeAsRecord(){
        
      String person = getFullName() +"\t";
      person+= birthdate +"\t";
      person+= employeeNo + "\t";
      person+= getMonthlySalary() +"\t";
      person+= getHireDate() +"\n"; 
      return person; 
        
    }
}
