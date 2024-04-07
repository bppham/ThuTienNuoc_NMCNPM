package models;

/**
 *
 * @author Phu Bao
 */
public class WaterCategoryModel {
    private String maLoai, tenLoai;
    private int phiTre;

    public WaterCategoryModel() {
    }

    public WaterCategoryModel(String tenLoai, int phiTre) {
        this.tenLoai = tenLoai;
        this.phiTre = phiTre;
    }

    public WaterCategoryModel(String maLoai, String tenLoai, int phiTre) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
        this.phiTre = phiTre;
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

    public int getPhiTre() {
        return phiTre;
    }

    public void setPhiTre(int phiTre) {
        this.phiTre = phiTre;
    }
    
}
