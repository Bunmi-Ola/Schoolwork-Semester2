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
public class AnnualMemberShip extends MemberShip{
    
    private Date joinDate;
    private boolean hasTab;
    private float tabSize;
    private float tabMax;

    
    
    public AnnualMemberShip() {}
    
    public AnnualMemberShip(int memberNumber, Date birthDate, String name, Date joinDate,
                            boolean hasTab, float tabMax){
       
        super.setMemberNumber(memberNumber);
        super.setMemberBirthDate(birthDate);
        super.setMemberName(name);
        setJoinDate(joinDate);
        setHasTab(hasTab);
        setTabMax(tabMax);
   } 
   
    /**
     * @return the joinDate
     */
    public Date getJoinDate() {
        return joinDate;
    }

    /**
     * @param joinDate the joinDate to set
     */
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    /**
     * @return the hasTab
     */
    public boolean isHasTab() {
        return hasTab;
    }

    /**
     * @param hasTab the hasTab to set
     */
    public void setHasTab(boolean hasTab) {
        this.hasTab = hasTab;
    }

    /**
     * @return the tabSize
     */
    public float getTabSize() {
        return 0;
    }

   
    /**
     * @return the tabMax
     */
    public float getTabMax() {
        return tabMax;
    }

    /**
     * @param tabMax the tabMax to set
     */
    public void setTabMax(float tabMax) {
        this.tabMax = tabMax;
    }
   
    public void grantTab(float max) {
      
        setHasTab(true);
        setTabMax(max);
        
    }
    
    public void addToTab(float charge) {
      
        if ((isHasTab()== true) && (getTabSize()+charge) < getTabMax()){
            
            charge += getTabSize();
        }
        
    }
    
    public float payTab(float payment) {
      
       return   payment += getTabSize();
        
    } 
    
    public void renew(Date joinDate) {
      
        if (getTabSize() == 0){
            
            setJoinDate(joinDate);
        }
        
    }
    
    public String  checkIn(Date todaysDate){
        
       String info = "";
      
      int year   = todaysDate.getYear() - getJoinDate().getYear();
        if ( year > 1 ){
          
            info = "Declined: Membership expired";
        }
        
        if ( (year < 1) && (getMemberBirthDate() == todaysDate) ){
          
            info = "Approved: Happy Birthday! $15 Credit to the lounge valid today only";
        }
        if ( (year < 1) && (getMemberBirthDate() != todaysDate)){
          
            info = "Approved";
        }
        return info;
    }
     public String writeAsRecord(){
        
      String member = 'A' +" ";
      member+= getMemberNumber()+" ";
      member+= getMemberBirthDate() +" ";
      member+= getMemberName() + " ";
      member+= getJoinDate() + " ";      
      member+= isHasTab() +" ";
      member+= getTabMax() +"\n"; 
      return member; 
        
    }
}
