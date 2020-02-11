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
public class Patient extends Person {
    private int patientId;
    private int donorUnitId;
    private Date time;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDonorUnitId() {
        return donorUnitId;
    }

    public void setDonorUnitId(int donorUnitId) {
        this.donorUnitId = donorUnitId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Patient{" + "patientId=" + patientId + ", donorUnitId=" + donorUnitId + ", time=" + time + '}';
    }
    
    
    
}
