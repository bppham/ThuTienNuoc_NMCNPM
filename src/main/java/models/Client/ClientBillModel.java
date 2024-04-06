package models.Client;

import java.sql.Date;



public class ClientBillModel {
    private String maHoaDon, maNhanVienLapHoaDon, maGhi, maDongHo, maNhanVienGhiNuoc, tenNhanVienLapHoaDon, tenNhanVienGhiNuoc, tenDongHo, maLoai, tenLoai, ki, maCTKV, tenChiTiet, maKhuVuc, tenKhuVuc;
    private int tieuThu, tongTien, chiSoCu, chiSoMoi;
    private Date ngayDenHan, ngayTra, ngayTao, ngayGhi;
    private boolean thanhToan;

    public ClientBillModel() {
    }

    public ClientBillModel(String maHoaDon, String maNhanVienLapHoaDon, String maGhi, String maDongHo, String maNhanVienGhiNuoc, String tenNhanVienLapHoaDon, String tenNhanVienGhiNuoc, String tenDongHo, String maLoai, String tenLoai, String ki, String maCTKV, String tenChiTiet, String maKhuVuc, String tenKhuVuc, int tieuThu, int tongTien, boolean thanhToan, int chiSoCu, int chiSoMoi, Date ngayDenHan, Date ngayTra, Date ngayTao, Date ngayGhi) {
        this.maHoaDon = maHoaDon;
        this.maNhanVienLapHoaDon = maNhanVienLapHoaDon;
        this.maGhi = maGhi;
        this.maDongHo = maDongHo;
        this.maNhanVienGhiNuoc = maNhanVienGhiNuoc;
        this.tenNhanVienLapHoaDon = tenNhanVienLapHoaDon;
        this.tenNhanVienGhiNuoc = tenNhanVienGhiNuoc;
        this.tenDongHo = tenDongHo;
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
        this.ki = ki;
        this.maCTKV = maCTKV;
        this.tenChiTiet = tenChiTiet;
        this.maKhuVuc = maKhuVuc;
        this.tenKhuVuc = tenKhuVuc;
        this.tieuThu = tieuThu;
        this.tongTien = tongTien;
        this.thanhToan = thanhToan;
        this.chiSoCu = chiSoCu;
        this.chiSoMoi = chiSoMoi;
        this.ngayDenHan = ngayDenHan;
        this.ngayTra = ngayTra;
        this.ngayTao = ngayTao;
        this.ngayGhi = ngayGhi;
    }

    

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaNhanVienLapHoaDon() {
        return maNhanVienLapHoaDon;
    }

    public void setMaNhanVienLapHoaDon(String maNhanVienLapHoaDon) {
        this.maNhanVienLapHoaDon = maNhanVienLapHoaDon;
    }

    public String getMaGhi() {
        return maGhi;
    }

    public void setMaGhi(String maGhi) {
        this.maGhi = maGhi;
    }

    public String getMaDongHo() {
        return maDongHo;
    }

    public void setMaDongHo(String maDongHo) {
        this.maDongHo = maDongHo;
    }

    public String getMaNhanVienGhiNuoc() {
        return maNhanVienGhiNuoc;
    }

    public void setMaNhanVienGhiNuoc(String maNhanVienGhiNuoc) {
        this.maNhanVienGhiNuoc = maNhanVienGhiNuoc;
    }

    public String getTenNhanVienLapHoaDon() {
        return tenNhanVienLapHoaDon;
    }

    public void setTenNhanVienLapHoaDon(String tenNhanVienLapHoaDon) {
        this.tenNhanVienLapHoaDon = tenNhanVienLapHoaDon;
    }

    public String getTenNhanVienGhiNuoc() {
        return tenNhanVienGhiNuoc;
    }

    public void setTenNhanVienGhiNuoc(String tenNhanVienGhiNuoc) {
        this.tenNhanVienGhiNuoc = tenNhanVienGhiNuoc;
    }

    public String getTenDongHo() {
        return tenDongHo;
    }

    public void setTenDongHo(String tenDongHo) {
        this.tenDongHo = tenDongHo;
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

    public String getKi() {
        return ki;
    }

    public void setKi(String ki) {
        this.ki = ki;
    }

    public int getTieuThu() {
        return tieuThu;
    }

    public void setTieuThu(int tieuThu) {
        this.tieuThu = tieuThu;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public boolean isThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(boolean thanhToan) {
        this.thanhToan = thanhToan;
    }

    public int getChiSoCu() {
        return chiSoCu;
    }

    public void setChiSoCu(int chiSoCu) {
        this.chiSoCu = chiSoCu;
    }

    public int getChiSoMoi() {
        return chiSoMoi;
    }

    public void setChiSoMoi(int chiSoMoi) {
        this.chiSoMoi = chiSoMoi;
    }

    public Date getNgayDenHan() {
        return ngayDenHan;
    }

    public void setNgayDenHan(Date ngayDenHan) {
        this.ngayDenHan = ngayDenHan;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayGhi() {
        return ngayGhi;
    }

    public void setNgayGhi(Date ngayGhi) {
        this.ngayGhi = ngayGhi;
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
  
}