/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

import java.util.Date;

/**
 *
 * @author awj
 */
public class Donor extends Person{
    private int donarID; 
    private boolean safety ; 
    private Date time; 
    private char quantity;
    private int numOfDonation ;

    public int getDonarID() {
        return donarID;
    }

    public void setDonarID(int donarID) {
        this.donarID = donarID;
    }

    public boolean isSafety() {
        return safety;
    }

    public void setSafety(boolean safety) {
        this.safety = safety;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public char getQuantity() {
        return quantity;
    }

    public void setQuantity(char quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Donor{" + "donarID=" + donarID + ", safety=" + safety + ", time=" + time + ", quantity=" + quantity + '}';
    }

    public int getNumOfDonation() {
        return numOfDonation;
    }

    public void setNumOfDonation(int numOfDonation) {
        this.numOfDonation = numOfDonation;
    }
            
    
}
