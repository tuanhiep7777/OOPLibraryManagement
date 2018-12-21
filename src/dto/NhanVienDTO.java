package dto;

import java.sql.Date;

public class NhanVienDTO {
	
	private String MaNV;
	private String TenNV;
	private String GioiTinh;
	private long CMND;
//	private String NgaySinh;
        private Date NgaySinh;
	private String DiaChi;
	private long SDT;
	private String Email;
        
        public NhanVienDTO(){
            
        }
        
        public NhanVienDTO(String maNV, String tenNV, String gioiTinh, long cMND, Date ngaySinh, String diaChi, long sDT, String email){
            
            MaNV = maNV;
            TenNV = tenNV;
            GioiTinh = gioiTinh;
            CMND = cMND;
            NgaySinh = ngaySinh;
            DiaChi = diaChi;
            SDT = sDT;
            Email = email;
        }
        
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public String getTenNV() {
		return TenNV;
	}
	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}
	public long getCMND() {
		return CMND;
	}
	public void setCMND(long cMND) {
		CMND = cMND;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
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
}