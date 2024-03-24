package models.Client;

public class ClientChartModel {
    private String month;
    private int waterConsumption, moneyToPay;

    public ClientChartModel() {
    }

    public ClientChartModel(String month, int waterConsumption, int moneyToPay) {
        this.month = month;
        this.waterConsumption = waterConsumption;
        this.moneyToPay = moneyToPay;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getWaterConsumption() {
        return waterConsumption;
    }

    public void setWaterConsumption(int waterConsumption) {
        this.waterConsumption = waterConsumption;
    }

    public double getMoneyToPay() {
        return moneyToPay;
    }

    public void setMoneyToPay(int moneyToPay) {
        this.moneyToPay = moneyToPay;
    }  
}
