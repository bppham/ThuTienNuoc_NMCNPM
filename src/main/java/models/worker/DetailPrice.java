
package models.worker;


public class DetailPrice {
    private int detailPriceId;
    private int startIndex;
    private int EndIndex;
    private double price;
    private String detailName;
    private String roleMoneyCategory;

    public DetailPrice() {
    }

    
    
    public DetailPrice( int startIndex, int EndIndex, double price, String detailName, String roleMoneyCategory) {
        this.startIndex = startIndex;
        this.EndIndex = EndIndex;
        this.price = price;
        this.detailName = detailName;
        this.roleMoneyCategory = roleMoneyCategory;
    }

    public int getDetailPriceId() {
        return detailPriceId;
    }

    public void setDetailPriceId(int detailPriceId) {
        this.detailPriceId = detailPriceId;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return EndIndex;
    }

    public void setEndIndex(int EndIndex) {
        this.EndIndex = EndIndex;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public String getRoleMoneyCategory() {
        return roleMoneyCategory;
    }

    public void setRoleMoneyCategory(String roleMoneyCategory) {
        this.roleMoneyCategory = roleMoneyCategory;
    }
    
    
}
