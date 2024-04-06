package models.Client;

/**
 *
 * @author Phu Bao
 */
public class ClientInfoModel {
    private String maCH, hoTen, sdt, cccd, diaChi, gioiTinh, email;

    public ClientInfoModel() {
    }

    public ClientInfoModel(String maCH, String hoTen, String sdt, String cccd, String diaChi, String gioiTinh, String email) {
        this.maCH = maCH;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.cccd = cccd;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.email = email;
    }

    public String getMaCH() {
        return maCH;
    }

    public void setMaCH(String maCH) {
        this.maCH = maCH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
