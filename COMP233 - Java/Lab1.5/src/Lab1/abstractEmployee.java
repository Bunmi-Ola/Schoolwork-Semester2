package Lab1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author olanrewaju4401
 */
public abstract class abstractEmployee extends Person{

    private int employeeNo;
    private int departmentNo;
    private int projectNo;

    /**
     * @return the employeeNo
     */
    
     public abstractEmployee (String firstname, String lastname, char middlelnit, Date birthdate,
                    int employeeNo, int departmentNo, int projectNo) {
        
        super.setLastname(lastname);
        super.setFirstname(firstname);
        super.setMiddlelnit(middlelnit);
        super.setBirthdate(birthdate);
        setEmployeeNo(employeeNo);
        setDepartmentNo(departmentNo);
        setProjectNo(projectNo );
    }
     
     public abstractEmployee() {}
     
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
     * @return the departmentNo
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

    /**
     * @return the projectNo
     */
    public int getProjectNo() {
        return projectNo;
    }

    /**
     * @param projectNo the projectNo to set
     */
    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public abstract float getEarnings();
    
    public String toString(){
        
        String employee = "Employee Details" +"\n";        
        employee+= "Employee Number: " + getDepartmentNo() +"\n";
        employee+= "Employee Last Name: " + getLastname() +"\n";
        employee+= "Employee First Name: " + getFirstname() +"\n";
        employee+= "Employee middle lnitial: " + getMiddlelnit() +"\n";
        employee+= "Employee Birthdate: " + getBirthdate() +"\n";
        employee+= "Monthly Salary: "+ getDepartmentNo() +"\n";
        employee+= "Hire Date: "+ getProjectNo() +"\n"; 
        return employee;
    }
    
    public String EarningstoString(){
		return getFirstname() + " make " + getEarnings();
		
	}
}
