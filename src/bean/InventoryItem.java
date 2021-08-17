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
public class InventoryItem {
    String iSID = null;
    String iSName = null;
    int iSQty = 0;
    String iSDate = null;

    public InventoryItem() {
    }
    
    public InventoryItem(String iSID, String iSName, int iSQty, String iSDate) {
        this.iSID = JUtility.addPrefix("IS", iSID);
        this.iSName = iSName;
        this.iSQty = iSQty;
        this.iSDate = iSDate;
    }

    public String getiSID() {
        return iSID;
    }

    public void setiSID(String iSID) {
        this.iSID = iSID;
    }

    public String getiSName() {
        return iSName;
    }

    public void setiSName(String iSName) {
        this.iSName = iSName;
    }

    public int getiSQty() {
        return iSQty;
    }

    public void setiSQty(int iSQty) {
        this.iSQty = iSQty;
    }

    public String getiSDate() {
        return iSDate;
    }

    public void setiSDate(String iSDate) {
        this.iSDate = iSDate;
    }
    
    
    
}
