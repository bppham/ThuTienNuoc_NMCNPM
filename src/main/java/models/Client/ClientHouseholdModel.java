package models.Client;

public class ClientHouseholdModel {
    private String detailAddressId, nameDetailAddress, typeWaterUsing, roleAreaId, detailArea;

    public ClientHouseholdModel() {
    }

    public ClientHouseholdModel(String detailAddressId, String nameDetailAddress, String typeWaterUsing, String roleAreaId, String detailArea) {
        this.detailAddressId = detailAddressId;
        this.nameDetailAddress = nameDetailAddress;
        this.typeWaterUsing = typeWaterUsing;
        this.roleAreaId = roleAreaId;
        this.detailArea = detailArea;
    }

    public String getDetailAddressId() {
        return detailAddressId;
    }

    public void setDetailAddressId(String detailAddressId) {
        this.detailAddressId = detailAddressId;
    }

    public String getNameDetailAddress() {
        return nameDetailAddress;
    }

    public void setNameDetailAddress(String nameDetailAddress) {
        this.nameDetailAddress = nameDetailAddress;
    }

    public String getTypeWaterUsing() {
        return typeWaterUsing;
    }

    public void setTypeWaterUsing(String typeWaterUsing) {
        this.typeWaterUsing = typeWaterUsing;
    }

    public String getRoleAreaId() {
        return roleAreaId;
    }

    public void setRoleAreaId(String roleAreaId) {
        this.roleAreaId = roleAreaId;
    }

    public String getDetailArea() {
        return detailArea;
    }

    public void setDetailArea(String detailArea) {
        this.detailArea = detailArea;
    }
    
}
