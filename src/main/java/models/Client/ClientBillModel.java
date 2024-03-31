package models.Client;

import java.sql.Date;



public class ClientBillModel {
    private String collectMoneyId, employCollectID, userID, moneyCategoryID, addressCollectID, nameAddressCollect, nameEmployee, nameMoneyCategory;
    private int preIndex, currentIndex, moneyToPay;
    private Date timeCollect, timePay;

    public ClientBillModel() {
    }

    public ClientBillModel(String collectMoneyId, String employCollectID, String userID, String moneyCategoryID, String addressCollectID, String nameAddressCollect, String nameEmployee, String nameMoneyCategory, int preIndex, int currentIndex, int moneyToPay, Date timeCollect, Date timePay) {
        this.collectMoneyId = collectMoneyId;
        this.employCollectID = employCollectID;
        this.userID = userID;
        this.moneyCategoryID = moneyCategoryID;
        this.addressCollectID = addressCollectID;
        this.nameAddressCollect = nameAddressCollect;
        this.nameEmployee = nameEmployee;
        this.nameMoneyCategory = nameMoneyCategory;
        this.preIndex = preIndex;
        this.currentIndex = currentIndex;
        this.moneyToPay = moneyToPay;
        this.timeCollect = timeCollect;
        this.timePay = timePay;
    }

    public String getCollectMoneyId() {
        return collectMoneyId;
    }

    public void setCollectMoneyId(String collectMoneyId) {
        this.collectMoneyId = collectMoneyId;
    }

    public String getEmployCollectID() {
        return employCollectID;
    }

    public void setEmployCollectID(String employCollectID) {
        this.employCollectID = employCollectID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getMoneyCategoryID() {
        return moneyCategoryID;
    }

    public void setMoneyCategoryID(String moneyCategoryID) {
        this.moneyCategoryID = moneyCategoryID;
    }

    public String getAddressCollectID() {
        return addressCollectID;
    }

    public void setAddressCollectID(String addressCollectID) {
        this.addressCollectID = addressCollectID;
    }

    public String getNameAddressCollect() {
        return nameAddressCollect;
    }

    public void setNameAddressCollect(String nameAddressCollect) {
        this.nameAddressCollect = nameAddressCollect;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getNameMoneyCategory() {
        return nameMoneyCategory;
    }

    public void setNameMoneyCategory(String nameMoneyCategory) {
        this.nameMoneyCategory = nameMoneyCategory;
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

    public int getMoneyToPay() {
        return moneyToPay;
    }

    public void setMoneyToPay(int moneyToPay) {
        this.moneyToPay = moneyToPay;
    }

    public Date getTimeCollect() {
        return timeCollect;
    }

    public void setTimeCollect(Date timeCollect) {
        this.timeCollect = timeCollect;
    }

    public Date getTimePay() {
        return timePay;
    }

    public void setTimePay(Date timePay) {
        this.timePay = timePay;
    }
  
}