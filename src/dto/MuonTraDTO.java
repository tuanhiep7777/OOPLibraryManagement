package dto;

import java.sql.Date;

public class MuonTraDTO {

    private String MaMT;
    private String MaDG;
    private String MaNV;
    private Date NgayMuon;
    private Date HanTra;
    
    public MuonTraDTO(){
        
    }
    
    public MuonTraDTO(String maMT, String maDG, String maNV, Date ngayMuon, Date hanTra){
        MaMT = maMT;
        MaDG = maDG;
        MaNV = maNV;
        NgayMuon = ngayMuon;
        HanTra = hanTra;
    }
    
	public String getMaMT() {
		return MaMT;
	}
	public void setMaMT(String maMT) {
		MaMT = maMT;
	}
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public String getMaDG() {
		return MaDG;
	}
	public void setMaDG(String maDG) {
		MaDG = maDG;
	}
	public Date getNgayMuon() {
		return NgayMuon;
	}
	public void setNgayMuon(Date ngayMuon) {
		NgayMuon = ngayMuon;
	}
	public Date getHanTra() {
		return HanTra;
	}
	public void setHanTra(Date hanTra) {
		HanTra = hanTra;
	}
    
}
