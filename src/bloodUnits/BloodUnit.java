/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodUnits;

/**
 *
 * @author awj
 */
public class BloodUnit {
    private String bloodType;
    private String resusAgent;
    private int uId;

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getResusAgent() {
        return resusAgent;
    }

    public void setResusAgent(String resusAgent) {
        this.resusAgent = resusAgent;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Override
    public String toString() {
        return "BloodUnit{" + "bloodType=" + bloodType + ", resusAgent=" + resusAgent + ", uId=" + uId + '}';
    }
    
    
    
}
