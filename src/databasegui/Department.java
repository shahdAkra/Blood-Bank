/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasegui;

/**
 *
 * @author ayah
 */
public class Department {
    private String depName; 
    private int depNum; 
    public Department(){}

    public Department(String depName, int depNum) {
        this.depName = depName;
        this.depNum = depNum;
    }

    public int getDepNum() {
        return depNum;
    }

    public void setDepNum(int depNum) {
        this.depNum = depNum;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "Department{" + "depName=" + depName + ", depNum=" + depNum + '}';
    }
    
    
}
