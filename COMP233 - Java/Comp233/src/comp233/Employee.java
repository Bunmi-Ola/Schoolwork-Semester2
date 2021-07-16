/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp233;

/**
 *
 * @author barclay7342
 */
public class Employee extends Person{
    private int employeeNo;
    private float monthlySalary;
    private Date hireDate;
    
    public Employee(){}
    
    public Employee(String firstName, String lastname, char middleInit, Date birthDate, int EmployeeNo, float monthlySalary, Date hireDate){
        super.setFirstName(firstName);
        super.setLastName(lastname);
        super.setMiddleInit(middleInit);
        
        
        
    }
}
