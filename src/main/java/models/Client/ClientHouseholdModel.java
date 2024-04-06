package models.Client;

public class ClientHouseholdModel {
    private String maCTKV, tenChiTiet, maKhuVuc, tenKhuVuc, maDH, tenDH, maLoai, tenLoai;

    public ClientHouseholdModel() {
    }

    public ClientHouseholdModel(String maCTKV, String tenChiTiet, String maKhuVuc, String tenKhuVuc, String maDH, String tenDH, String maLoai, String tenLoai) {
        this.maCTKV = maCTKV;
        this.tenChiTiet = tenChiTiet;
        this.maKhuVuc = maKhuVuc;
        this.tenKhuVuc = tenKhuVuc;
        this.maDH = maDH;
        this.tenDH = tenDH;
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    public String getMaCTKV() {
        return maCTKV;
    }

    public void setMaCTKV(String maCTKV) {
        this.maCTKV = maCTKV;
    }

    public String getTenChiTiet() {
        return tenChiTiet;
    }

    public void setTenChiTiet(String tenChiTiet) {
        this.tenChiTiet = tenChiTiet;
    }

    public String getMaKhuVuc() {
        return maKhuVuc;
    }

    public void setMaKhuVuc(String maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }

    public String getTenKhuVuc() {
        return tenKhuVuc;
    }

    public void setTenKhuVuc(String tenKhuVuc) {
        this.tenKhuVuc = tenKhuVuc;
    }

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public String getTenDH() {
        return tenDH;
    }

    public void setTenDH(String tenDH) {
        this.tenDH = tenDH;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }
    
}
