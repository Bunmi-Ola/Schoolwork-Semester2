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
public class Project implements Comparable{
    
    
    private int projectNo;
    private String projectName ;  
    
    
     public Project() {}
    
    
    public Project (int projectNo, String projectName) {
        
        setProjectNo(projectNo);
        setProjectName(projectName);
    }
    
    public int compareTo(Object o){
        Project projects = (Project)o;
        if(projects.getProjectNo() > this.getProjectNo()){
            return 1;
        }
        if(projects.getProjectNo() == this.getProjectNo()){
            return 0;
        }
        return -1;
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

    /**
     * @return the projectName
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName the projectName to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    public String toString(){
        
        String Project = "Project Details" +"\n";        
        Project+= "Project Number: " + getProjectNo() +"\n";
        Project+= "Project Name: " + getProjectName() +"\n";
       
        return Project;
    }
}
