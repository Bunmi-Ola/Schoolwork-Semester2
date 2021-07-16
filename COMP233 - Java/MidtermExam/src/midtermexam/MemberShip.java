/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermexam;

/**
 *
 * @author olanrewaju4401
 */
public abstract class MemberShip implements Comparable{     
   
    
    private int memberNumber;
    private Date memberBirthDate;
    private String memberName;

    
   public MemberShip() {}
      
   public MemberShip(int memberNumber, Date birthDate, String name){
       
        setMemberNumber(memberNumber);
        setMemberBirthDate(birthDate);
        setMemberName(name);
   } 
    
    
    /**
     * @return the memberNumber
     */
    public int getMemberNumber() {
        return memberNumber;
    }

    /**
     * @param memberNumber the memberNumber to set
     */
    public void setMemberNumber(int memberNumber) {
        
        if (memberNumber < 0){
            System.out.println("Invalid Number");
            this.memberNumber = 0;
        }
        else{
        this.memberNumber = memberNumber;
        }
    }

       
    /**
     * @return the memberBirthDate
     */
    public Date getMemberBirthDate() {
        return memberBirthDate;
    }

    /**
     * @param memberBirthDate the memberBirthDate to set
     */
    public void setMemberBirthDate(Date memberBirthDate) {
        this.memberBirthDate = memberBirthDate;
    }

    /**
     * @return the memberName
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * @param memberName the memberName to set
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    
     public int compareTo(Object o)
    {
    MemberShip s = (MemberShip)o;
    if(s.getMemberNumber()== this.getMemberNumber())
    {
        return 0;
    }
    if(s.getMemberNumber() > this.getMemberNumber())
    {
        return 1;
    }
    return -1;
    }
     
    public abstract String  checkIn(Date todaysDate);
    
    public String toString(){
        
        String member = getMemberNumber() +" \t\t " + getMemberName()  + " \t\t " + getMemberBirthDate();
        
        return member;
    }
}
