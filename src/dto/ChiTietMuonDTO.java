package dto;

import java.sql.Date;

public class ChiTietMuonDTO {

	private String MaMT;
	private String MaS;
	private int TienCoc;
        private Date NgayTra;
	private String GhiChu;
        
        public ChiTietMuonDTO(){
            
        }
        
        public ChiTietMuonDTO(String maMT, String maS, int tienCoc, Date ngayTra, String ghiChu){
            MaMT = maMT;
            MaS = maS;
            TienCoc = tienCoc;
            NgayTra = ngayTra;
            GhiChu = ghiChu;
        }
	
	public String getMaMT() {
		return MaMT;
	}
	public void setMaMT(String maMT) {
		MaMT = maMT;
	}
	public int getTienCoc() {
		return TienCoc;
	}
	public void setTienCoc(int tienCoc) {
		TienCoc = tienCoc;
	}
	public String getMaS() {
		return MaS;
	}
	public void setMaS(String maS) {
		MaS = maS;
	}
        public Date getNgayTra() {
            return NgayTra;
        }
        public void setNgayTra(Date NgayTra) {
            this.NgayTra = NgayTra;
        }
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	
}
