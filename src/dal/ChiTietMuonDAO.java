package dal;

import dto.ChiTietMuonDTO;
import dto.MuonTraDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import java.util.Date;
import javax.swing.JOptionPane;

public class ChiTietMuonDAO {

    private static Statement stmt;
    private static ResultSet rs;
    private static Connection con;
    private static PreparedStatement ps;
    
    public static void LoadDuLieu(JTable table, String MaMT) throws ClassNotFoundException, SQLException{
        String SQLQuery = "SELECT CHI_TIET_MUON.MA_SACH AS [Mã sách], SACH.TEN_SACH AS [Tên sách], CHI_TIET_MUON.SO_LUONG AS [Số lượng], NGAY_TRA AS [Ngày trả], GHI_CHU AS [Ghi chú] FROM CHI_TIET_MUON, SACH WHERE MA_MUON_TRA = '" + MaMT + "' AND SACH.MA_SACH = CHI_TIET_MUON.MA_SACH";
        con = KetNoi.getConnect();
        ps = con.prepareStatement(SQLQuery);
        rs = ps.executeQuery();
        table.setModel((DbUtils.resultSetToTableModel(rs)));
    }
    
    public static ChiTietMuonDTO LoadRowContent(String maMT, String MaS) throws SQLException, ClassNotFoundException{
            String SQLQuery = "SELECT * FROM CHI_TIET_MUON WHERE MA_SACH = '" + MaS + "' AND MA_MUON_TRA = '" + maMT + "'";
            try {
                con = KetNoi.getConnect();
                rs = con.prepareStatement(SQLQuery).executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            ChiTietMuonDTO temp = new ChiTietMuonDTO();
            if (rs.next()){
                temp.setMaMT(rs.getString(1));
                temp.setMaS(rs.getString(2));
                temp.setTienCoc(rs.getInt(3));
                temp.setNgayTra(rs.getDate(4));
                temp.setGhiChu(rs.getString(5));
            }
            return temp;
     }
    
    public static void Them(ChiTietMuonDTO newDTO) throws ClassNotFoundException, SQLException {
            
            con = KetNoi.getConnect();
            
            ps = con.prepareStatement("INSERT INTO CHI_TIET_MUON VALUES(?,?,?,?,?)");
            ps.setString(1, newDTO.getMaMT());
            ps.setString(2, newDTO.getMaS());
            ps.setInt(3, newDTO.getTienCoc());
            ps.setDate(4, newDTO.getNgayTra());
            ps.setString(5, newDTO.getGhiChu());
            
            ps.execute();
    }
    
    public static void ModifyRecord(ChiTietMuonDTO newDTO) throws SQLException{
            String SQLQuery = "UPDATE CHI_TIET_MUON"
                    + " SET MA_MUON_TRA = ?,"
                    + "MA_SACH = ?,"
                    + "SO_LUONG = ?,"
                    + "NGAY_TRA = ?,"
                    + "GHI_CHU = ? "
                    + "WHERE MA_MUON_TRA = ? AND MA_SACH = ?";
            
            ps = con.prepareStatement(SQLQuery);
            ps.setString(1, newDTO.getMaMT());
            ps.setString(2, newDTO.getMaS());
            ps.setInt(3, newDTO.getTienCoc());
            ps.setDate(4, newDTO.getNgayTra());
            ps.setString(5, newDTO.getGhiChu());
            ps.setString(6, newDTO.getMaMT());
            ps.setString(7, newDTO.getMaS());
            
            ps.execute();
    }
    
    public static void DeleteReCord(String MaMT) {

        String sql = "SELECT MA_SACH FROM CHI_TIET_MUON WHERE MA_MUON_TRA = '" + MaMT + "'";
        
        try {
            
            ResultSet rs1 = KetNoi.getConnect().prepareStatement(sql).executeQuery();
            
            while (rs1.next()){
                String msS = rs1.getString(1);
                short tongSach = SachDAO.getSL(msS);
                short sachTra = ChiTietMuonDAO.getSL(MaMT, msS);
                SachDAO.updateSLSach(msS, (short) (tongSach + sachTra));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ChiTietMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String SQLQuery = "DELETE FROM CHI_TIET_MUON WHERE MA_MUON_TRA = '" + MaMT + "'";//"DELETE FROM SACH WHERE MA_SACH = ?";
        try {
            con = KetNoi.getConnect();
            con.prepareStatement(SQLQuery).execute();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MuonTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void DeleteReCord(String MaMT, String MaS){
            
            String SQLQuery = "DELETE FROM CHI_TIET_MUON WHERE MA_MUON_TRA = '" + MaMT + "' AND MA_SACH = '" + MaS + "'";//"DELETE FROM SACH WHERE MA_SACH = ?";
            try {
                con = KetNoi.getConnect();
                con.prepareStatement(SQLQuery).execute();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(MuonTraDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static ArrayList<String> takeModel(String field, String MaMT) throws ClassNotFoundException, SQLException{
        
        ArrayList<String> list = new ArrayList<String>();
        String SQLQuery = "SELECT " + field + " FROM CHI_TIET_MUON WHERE MA_MUON_TRA = '" + MaMT + "'";
        con = KetNoi.getConnect();
        rs = con.prepareStatement(SQLQuery).executeQuery();
        while(rs.next()) list.add(rs.getString(1));
        
        return list;
    }
    
    public static long TinhTienPhat(String maMT, String hanTra, String homNay) throws ClassNotFoundException, SQLException{
        
        con = KetNoi.getConnect();
        
        // Tính tiền phạt cho những quyển quá hạn đã trả:
        String query = "SELECT SUM( SO_LUONG * DATEDIFF(DAY, ?, NGAY_TRA) ) FROM CHI_TIET_MUON WHERE MA_MUON_TRA = ? AND NGAY_TRA > ?";
        ps = con.prepareStatement(query);
        ps.setString(1, hanTra);
        ps.setString(2, maMT);
        ps.setString(3, hanTra);
        rs = ps.executeQuery();
        
        rs.next();
        long tienPhat = 1000 * (rs.getInt(1));
        
        
        // Tính tiền phạt cho những quyển quá hạn chưa trả:
        query = "SELECT SUM( SO_LUONG * DATEDIFF(DAY, ?, ?) ) FROM CHI_TIET_MUON WHERE MA_MUON_TRA = ? AND NGAY_TRA IS NULL";
        ps = con.prepareStatement(query);
        ps.setString(1, hanTra);
        ps.setString(2, homNay);
        ps.setString(3, maMT);
        rs = ps.executeQuery();
        
        rs.next();
        tienPhat += 1000 * (rs.getInt(1));
        
        return tienPhat;
    }
    
    public static void UpdateTienCoc(String MaMT){
        
        String SQLQuery = "SELECT SUM (CHI_TIET_MUON.SO_LUONG * SACH.DON_GIA) FROM CHI_TIET_MUON, SACH WHERE MA_MUON_TRA = '" + MaMT + "' AND SACH.MA_SACH = CHI_TIET_MUON.MA_SACH";
        try {
            con = KetNoi.getConnect();
            rs = con.prepareStatement(SQLQuery).executeQuery();
            rs.next();
            
            MuonTraDAO.UpdateTienCocTrongRecord(MaMT, rs.getLong(1));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ChiTietMuonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static short getSL(String maMT, String maS) throws ClassNotFoundException, SQLException{
        
        String SQLQuery = "SELECT SO_LUONG FROM CHI_TIET_MUON WHERE MA_MUON_TRA = '" + maMT + "' AND MA_SACH = '" + maS + "'";
        ps = KetNoi.getConnect().prepareStatement(SQLQuery);
        rs = ps.executeQuery();
        rs.next();
        
        return rs.getShort(1);
    }
    
    public static java.sql.Date getNgayTra(String maMT, String maS) throws ClassNotFoundException, SQLException{
        
        String SQLQuery = "SELECT NGAY_TRA FROM CHI_TIET_MUON WHERE MA_MUON_TRA = '" + maMT + "' AND MA_SACH = '" + maS + "'";
        ps = KetNoi.getConnect().prepareStatement(SQLQuery);
        rs = ps.executeQuery();
        if (rs.next())
            return rs.getDate(1);
        else return null;
    }
    
    public static void Search_Load_Table(String TieuChiTK, String NoiDungTK, JTable table) throws ClassNotFoundException, SQLException {
        String SQLQuery = "SELECT "
                + "MUON_TRA.MA_MUON_TRA AS [Mã mượn trả], "
                + "MUON_TRA.MA_DOC_GIA AS[Mã độc giả], "
                + "DOC_GIA.TEN_DOC_GIA AS [Tên độc giả], "
                + "MUON_TRA.MA_NHAN_VIEN AS[Mã nhân viên], "
                + "NHAN_VIEN.TEN_NHAN_VIEN AS[Tên nhân viên], "
                + "NGAY_MUON AS [Ngày mượn], "
                + "HAN_TRA AS[Hạn trả], "
                + "TIEN_COC AS[Tiền cọc], "
                + "MUON_TRA.TIEN_PHAT AS[Tiền phạt] "
                + "FROM MUON_TRA, DOC_GIA, NHAN_VIEN, CHI_TIET_MUON WHERE MUON_TRA.MA_MUON_TRA = CHI_TIET_MUON.MA_MUON_TRA AND DOC_GIA.MA_DOC_GIA = MUON_TRA.MA_DOC_GIA AND NHAN_VIEN.MA_NHAN_VIEN = MUON_TRA.MA_NHAN_VIEN AND " + TieuChiTK + " LIKE N'%" + NoiDungTK + "%'";
        con = KetNoi.getConnect();
        rs = con.prepareStatement(SQLQuery).executeQuery();
        table.setModel((DbUtils.resultSetToTableModel(rs)));
    }

}
