/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.util.Date;

/**
 *
 * @author ayah
 */
public class Employee {
    
   private int ID; 
   private String eName; 
   private String phoneNo; 
   private Date DOB; 
   private int did; 
   
   
   

    public Employee() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public int getDid() {
        return did;
    }

    @Override
    public String toString() {
        return "Employee{" + "ID=" + ID + ", eName=" + eName + ", phoneNo=" + phoneNo + ", DOB=" + DOB + ", did=" + did + '}';
    }

    public void setDid(int did) {
        this.did = did;
    }

   
    
}
