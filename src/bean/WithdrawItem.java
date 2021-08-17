/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import util.Utility.JUtility;

/**
 *
 * @author dulshan
 */
public class WithdrawItem {
    String wSID = null;
    String wSISID = null;
    String wSName = null;
    int wSQty = 0;
    String wSDate = null;

    public WithdrawItem() {
    }
    
    public WithdrawItem(String wSID, String wSISID, String wSName, int wSQty, String wSDate) {
        this.wSID = JUtility.addPrefix("WS", wSID);
        this.wSISID = JUtility.addPrefix("IS", wSISID);
        this.wSName = wSName;
        this.wSQty = wSQty;
        this.wSDate = wSDate;
    }

    public String getwSID() {
        return wSID;
    }

    public void setwSID(String wSID) {
        this.wSID = wSID;
    }

    public String getwSISID() {
        return wSISID;
    }

    public void setwSISID(String wSISID) {
        this.wSISID = wSISID;
    }

    public String getwSName() {
        return wSName;
    }

    public void setwSName(String wSName) {
        this.wSName = wSName;
    }
    
    public int getwSQty() {
        return wSQty;
    }

    public void setwSQty(int wSQty) {
        this.wSQty = wSQty;
    }

    public String getwSDate() {
        return wSDate;
    }

    public void setwSDate(String wSDate) {
        this.wSDate = wSDate;
    }
    
    
    
}
