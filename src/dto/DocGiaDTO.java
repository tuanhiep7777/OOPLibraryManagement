package dto;

import java.sql.Date;

public class DocGiaDTO {

    private String MaDG;
    private String TenDG;
    private String GioiTinh;
    private long CMND;
    //private String NgaySinh;
    private Date NgaySinh;
    private String DiaChi;
    private long SDT;
    private String Email;
    private long TaiKhoan;
    private long TienPhat;

    public DocGiaDTO() {

    }

    public DocGiaDTO(String maDG, String tenDG, String gT, long cMND, Date ngaySinh, String diaChi, long sDT, String email, long taiKhoan, long tienPhat) {

        MaDG = maDG;
        TenDG = tenDG;
        GioiTinh = gT;
        CMND = cMND;
        NgaySinh = ngaySinh;
        DiaChi = diaChi;
        SDT = sDT;
        Email = email;
        TaiKhoan = taiKhoan;
        TienPhat = tienPhat;
    }

    public String getMaDG() {
        return MaDG;
    }

    public void setMaDG(String maDG) {
        MaDG = maDG;
    }

    public String getTenDG() {
        return TenDG;
    }

    public void setTenDG(String tenDG) {
        TenDG = tenDG;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public long getCMND() {
        return CMND;
    }

    public void setCMND(long cMND) {
        CMND = cMND;
    }
//	public String getNgaySinh() {
//		return NgaySinh;
//	}
//	public void setNgaySinh(String ngaySinh) {
//		NgaySinh = ngaySinh;
//	}

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public long getSDT() {
        return SDT;
    }

    public void setSDT(long sDT) {
        SDT = sDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public long getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(long taiKhoan) {
        TaiKhoan = taiKhoan;
    }

    public long getTienPhat() {
        return TienPhat;
    }

    public void setTienPhat(long tienPhat) {
        TienPhat = tienPhat;
    }
}
