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
public abstract class Employee extends Person implements Comparable{
    
    private int employeeNo;
    private int departmentNo;   
    private Project  project;
    Person lastname;
    Person firstname;
    Person middlelnit;
    Date birthdate;
    /**
     * @return the employeeNo
     */
    public Employee() {}
    
    
    public Employee (String firstname, String lastname, char middlelnit, Date birthdate,
                    int employeeNo, int departmentNo, Project  project) {
        
        super.setLastname(lastname);
        super.setFirstname(firstname);
        super.setMiddlelnit(middlelnit);
        super.setBirthdate(birthdate);
        setEmployeeNo(employeeNo);
        setDepartmentNo(departmentNo);
        setProject(project);
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
      public int getDepartmentNo() {
        return departmentNo;
    }

    /**
     * @param departmentNo the departmentNo to set
     */
    public void setDepartmentNo(int departmentNo) {
        this.departmentNo = departmentNo;
    }
    
     public Project getProject() {
        return project;
    }

    /**
     * @param Project the Project to set
     */
    public void setProject(Project projectNo) {
        this.project = projectNo;
    }
    
    public String toString(){
        
        String employee = "Employee Details" +"\n";        
        employee+= "Employee Number: " + employeeNo +"\n";
        employee+= "Employee Last Name: " + getLastname() +"\n";
        employee+= "Employee First Name: " + getFirstname() +"\n";
        employee+= "Employee middle lnitial: " + getMiddlelnit() +"\n";
        employee+= "Employee Birthdate: " + getBirthdate() +"\n";
        employee+= "Monthly Salary: "+ getDepartmentNo() +"\n";
        employee+= "Hire Date: "+ getProject() +"\n"; 
        return employee;
    }
    
    public abstract float getEarnings();
    
    
    public String EarningstoString(){
		return getFirstname() + " make " + getEarnings();
		
	}
    
    @Override
    public int compareTo(Object o){
        Employee Emp = (Employee)o; 
        if(Emp.getEmployeeNo() == this.getEmployeeNo()){
            return 0;
        }
        if(Emp.getEmployeeNo() > this.getEmployeeNo()){
            return 1;
        }
      
        return -1;
    }

}
