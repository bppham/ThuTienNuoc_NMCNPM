package models.Client;


public class ClientBillModel {
    private int collectMoneyId, employCollectID, userID, preIndex, currentIndex, moneyCategoryID, moneyToPay, addressCollectID;
    private String timeCollect, nameEmployee;

    public ClientBillModel() {
    }   

    public ClientBillModel(int collectMoneyId, int employCollectID, int userID, int preIndex, int currentIndex, int moneyCategoryID, int moneyToPay, int addressCollectID, String timeCollect) {
        this.collectMoneyId = collectMoneyId;
        this.employCollectID = employCollectID;
        this.userID = userID;
        this.preIndex = preIndex;
        this.currentIndex = currentIndex;
        this.moneyCategoryID = moneyCategoryID;
        this.moneyToPay = moneyToPay;
        this.addressCollectID = addressCollectID;
        this.timeCollect = timeCollect;
    }
      
    public ClientBillModel(int collectMoneyId, int employCollectID, int userID, int preIndex, int currentIndex, int moneyCategoryID, int moneyToPay, int addressCollectID, String timeCollect, String nameEmployee) {
        this.collectMoneyId = collectMoneyId;
        this.employCollectID = employCollectID;
        this.userID = userID;
        this.preIndex = preIndex;
        this.currentIndex = currentIndex;
        this.moneyCategoryID = moneyCategoryID;
        this.moneyToPay = moneyToPay;
        this.addressCollectID = addressCollectID;
        this.timeCollect = timeCollect;
        this.nameEmployee = nameEmployee;
    }
    
    

    public int getCollectMoneyId() {
        return collectMoneyId;
    }

    public void setCollectMoneyId(int collectMoneyId) {
        this.collectMoneyId = collectMoneyId;
    }

    public int getEmployCollectID() {
        return employCollectID;
    }

    public void setEmployCollectID(int employCollectID) {
        this.employCollectID = employCollectID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public int getMoneyCategoryID() {
        return moneyCategoryID;
    }

    public void setMoneyCategoryID(int moneyCategoryID) {
        this.moneyCategoryID = moneyCategoryID;
    }

    public int getMoneyToPay() {
        return moneyToPay;
    }

    public void setMoneyToPay(int moneyToPay) {
        this.moneyToPay = moneyToPay;
    }

    public int getAddressCollectID() {
        return addressCollectID;
    }

    public void setAddressCollectID(int addressCollectID) {
        this.addressCollectID = addressCollectID;
    }

    public String getTimeCollect() {
        return timeCollect;
    }

    public void setTimeCollect(String timeCollect) {
        this.timeCollect = timeCollect;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }
      
}
