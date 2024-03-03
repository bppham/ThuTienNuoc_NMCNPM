
package models;

import java.util.Date;


public class BillModel {
    private String collectMoneyId;
    private String employCollectId;
    private String userId;
    private int preIndex;
    private int currentIndex;
    private Date timeCollect;
    private double moneyToPay;
    private String AddressCollectId;
    private boolean statusCollect;

    public BillModel() {
    }

    public BillModel(String collectMoneyId, String employCollectId, String userId, int preIndex, int currentIndex, Date timeCollect, double moneyToPay, String AddressCollectId, boolean statusCollect) {
        this.collectMoneyId = collectMoneyId;
        this.employCollectId = employCollectId;
        this.userId = userId;
        this.preIndex = preIndex;
        this.currentIndex = currentIndex;
        this.timeCollect = timeCollect;
        this.moneyToPay = moneyToPay;
        this.AddressCollectId = AddressCollectId;
        this.statusCollect = statusCollect;
    }

    public String getCollectMoneyId() {
        return collectMoneyId;
    }

    public void setCollectMoneyId(String collectMoneyId) {
        this.collectMoneyId = collectMoneyId;
    }

    public String getEmployCollectId() {
        return employCollectId;
    }

    public void setEmployCollectId(String employCollectId) {
        this.employCollectId = employCollectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getPreIndex() {
        return preIndex;
    }

    public void setPreIndex(int preIndex) {
        this.preIndex = preIndex;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public Date getTimeCollect() {
        return timeCollect;
    }

    public void setTimeCollect(Date timeCollect) {
        this.timeCollect = timeCollect;
    }

    public double getMoneyToPay() {
        return moneyToPay;
    }

    public void setMoneyToPay(double moneyToPay) {
        this.moneyToPay = moneyToPay;
    }

    public String getAddressCollectId() {
        return AddressCollectId;
    }

    public void setAddressCollectId(String AddressCollectId) {
        this.AddressCollectId = AddressCollectId;
    }

    public boolean isStatusCollect() {
        return statusCollect;
    }

    public void setStatusCollect(boolean statusCollect) {
        this.statusCollect = statusCollect;
    }
    
    
}
