package dto;

public class SachDTO {

	private String MaSach;
	private String TenSach;
	private String TenTacGia;
	private String TheLoai;
	private String NXB; 
	private short NamXuatBan;
	private int DonGia;
	private short SoLuong;
	
	public SachDTO() {
		
	}
	
	public SachDTO(String maSach, String tenSach, String tenTacGia, 
				   String theLoai, String nXB, short namXuatBan, int dongGia, short soLuong) {
		
		MaSach = maSach;
		TenSach = tenSach;
		TenTacGia = tenTacGia;
		TheLoai = theLoai;
		NXB = nXB;
		NamXuatBan = namXuatBan;
		DonGia = dongGia;
		SoLuong = soLuong;
	}
	
	public String getMaSach() {
		return MaSach;
	}
	
	public void setMaSach(String maSach) {
		MaSach = maSach;
	}
	
	public String getTenSach() {
		return TenSach;
	}
	
	public void setTenSach(String tenSach) {
		TenSach = tenSach;
	}
	
	public String getTenTacGia() {
		return TenTacGia;
	}
	
	public void setTenTacGia(String tenTacGia) {
		TenTacGia = tenTacGia;
	}
	
	public String getTheLoai() {
		return TheLoai;
	}
	
	public void setTheLoai(String theLoai) {
		TheLoai = theLoai;
	}
	
	public String getNXB() {
		return NXB;
	}
	
	public void setNXB(String nXB) {
		NXB = nXB;
	}
	
	public short getNamXuatBan() {
		return NamXuatBan;
	}
	
	public void setNamXuatBan(short namXuatBan) {
		NamXuatBan = namXuatBan;
	}
	
	public int getDonGia() {
		return DonGia;
	}
	
	public void setDonGia(int donGia) {
		DonGia = donGia;
	}
	
	public short getSoLuong() {
		return SoLuong;
	}
	
	public void setSoLuong(short soLuong) {
		SoLuong = soLuong;
	}
}
