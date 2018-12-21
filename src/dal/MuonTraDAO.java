package dal;

import dto.MuonTraDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRStyle;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.log4j.PropertyConfigurator;

public class MuonTraDAO {

    private static Statement stmt;
    private static ResultSet rs;
    private static Connection con;
    private static PreparedStatement ps;
    
    public static void LoadDuLieu(JTable table) throws ClassNotFoundException, SQLException{
        String SQLQuery = "SELECT "
                + "MA_MUON_TRA AS [Mã mượn trả], "
                + "MUON_TRA.MA_DOC_GIA AS[Mã độc giả], "
                + "DOC_GIA.TEN_DOC_GIA AS [Tên độc giả], "
                + "MUON_TRA.MA_NHAN_VIEN AS[Mã nhân viên], "
                + "NHAN_VIEN.TEN_NHAN_VIEN AS[Tên nhân viên], "
                + "NGAY_MUON AS [Ngày mượn], "
                + "HAN_TRA AS[Hạn trả], "
                + "TIEN_COC AS[Tiền cọc], "
                + "MUON_TRA.TIEN_PHAT AS[Tiền phạt] "
                + "FROM MUON_TRA, DOC_GIA, NHAN_VIEN "
                + "WHERE DOC_GIA.MA_DOC_GIA = MUON_TRA.MA_DOC_GIA AND NHAN_VIEN.MA_NHAN_VIEN = MUON_TRA.MA_NHAN_VIEN";
        con = KetNoi.getConnect();
        ps = con.prepareStatement(SQLQuery);
        rs = ps.executeQuery();
        table.setModel((DbUtils.resultSetToTableModel(rs)));
    }
    
    public static MuonTraDTO LoadRowContent(String MaMT) throws SQLException, ClassNotFoundException{
            String SQLQuery = "SELECT * FROM MUON_TRA WHERE MA_MUON_TRA = '" + MaMT + "'";
            try {
                con = KetNoi.getConnect();
                rs = con.prepareStatement(SQLQuery).executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(MuonTraDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            MuonTraDTO temp = new MuonTraDTO();
            if (rs.next()){
                temp.setMaMT(rs.getString(1));
                temp.setMaDG(rs.getString(2));
                temp.setMaNV(rs.getString(3));
                temp.setNgayMuon(rs.getDate(4));
                temp.setHanTra(rs.getDate(5));
            }
            return temp;
     }
    
    public static void Them(MuonTraDTO newDTO) throws ClassNotFoundException, SQLException {
            
            con = KetNoi.getConnect();
            
            ps = con.prepareStatement("INSERT INTO MUON_TRA VALUES(?,?,?,?,?, 0, 0)");
            ps.setString(1, newDTO.getMaMT());
            ps.setString(2, newDTO.getMaDG());
            ps.setString(3, newDTO.getMaNV());
            ps.setDate(4, newDTO.getNgayMuon());
            ps.setDate(5, newDTO.getHanTra());
            
            ps.execute();
    }
    
    public static void ModifyRecord(MuonTraDTO newDTO) throws SQLException{
            String SQLQuery = "UPDATE MUON_TRA"
                    + " SET MA_DOC_GIA = ?,"
                    + "MA_NHAN_VIEN = ?,"
                    + "NGAY_MUON = ?,"
                    + "HAN_TRA = ? "
                    + "WHERE MA_MUON_TRA = ?";
            ps = con.prepareStatement(SQLQuery);
            ps.setString(5, newDTO.getMaMT());
            ps.setString(1, newDTO.getMaDG());
            ps.setString(2, newDTO.getMaNV());
            ps.setDate(3, newDTO.getNgayMuon());
            ps.setDate(4, newDTO.getHanTra());
            
            ps.execute();
    }
    
    public static void Search_Load_Table(String TieuChiTK, String NoiDungTK, JTable table) throws ClassNotFoundException, SQLException {
        String SQLQuery = "SELECT "
                + "MA_MUON_TRA AS [Mã mượn trả], "
                + "MUON_TRA.MA_DOC_GIA AS[Mã độc giả], "
                + "DOC_GIA.TEN_DOC_GIA AS [Tên độc giả], "
                + "MUON_TRA.MA_NHAN_VIEN AS[Mã nhân viên], "
                + "NHAN_VIEN.TEN_NHAN_VIEN AS[Tên nhân viên], "
                + "NGAY_MUON AS [Ngày mượn], "
                + "HAN_TRA AS[Hạn trả], "
                + "TIEN_COC AS[Tiền cọc], "
                + "MUON_TRA.TIEN_PHAT AS[Tiền phạt] "
                + "FROM MUON_TRA, DOC_GIA, NHAN_VIEN WHERE DOC_GIA.MA_DOC_GIA = MUON_TRA.MA_DOC_GIA AND NHAN_VIEN.MA_NHAN_VIEN = MUON_TRA.MA_NHAN_VIEN AND " + TieuChiTK + " LIKE N'%" + NoiDungTK + "%'";
        con = KetNoi.getConnect();
        rs = con.prepareStatement(SQLQuery).executeQuery();
        table.setModel((DbUtils.resultSetToTableModel(rs)));
    }
    
    public static void Search_Load_Table(String NoiDungTK, JTable table) throws ClassNotFoundException, SQLException {
        String SQLQuery = "SELECT "
                + "MA_MUON_TRA AS [Mã mượn trả], "
                + "MUON_TRA.MA_DOC_GIA AS[Mã độc giả], "
                + "DOC_GIA.TEN_DOC_GIA AS [Tên độc giả], "
                + "MUON_TRA.MA_NHAN_VIEN AS[Mã nhân viên], "
                + "NHAN_VIEN.TEN_NHAN_VIEN AS[Tên nhân viên], "
                + "NGAY_MUON AS [Ngày mượn], "
                + "HAN_TRA AS[Hạn trả], "
                + "TIEN_COC AS[Tiền cọc], "
                + "MUON_TRA.TIEN_PHAT AS[Tiền phạt] "
                + "FROM MUON_TRA, DOC_GIA, NHAN_VIEN WHERE ("
                + "MUON_TRA.MA_MUON_TRA LIKE N'%" + NoiDungTK + "%' OR "
                + "MUON_TRA.MA_DOC_GIA LIKE N'%" + NoiDungTK + "%' OR "
                + "MUON_TRA.MA_NHAN_VIEN LIKE N'%" + NoiDungTK + "%' OR "
                + "NGAY_MUON LIKE N'%" + NoiDungTK + "%' OR "
                + "HAN_TRA LIKE N'%" + NoiDungTK + "%' OR "
                + "TIEN_COC LIKE N'%" + NoiDungTK + "%' OR "
                + "MUON_TRA.TIEN_PHAT LIKE N'%" + NoiDungTK + "%') AND "
                + "DOC_GIA.MA_DOC_GIA = MUON_TRA.MA_DOC_GIA AND "
                + "NHAN_VIEN.MA_NHAN_VIEN = MUON_TRA.MA_NHAN_VIEN";
        
        con = KetNoi.getConnect();
        rs = con.prepareStatement(SQLQuery).executeQuery();
        table.setModel((DbUtils.resultSetToTableModel(rs)));
    }
    
    public static void Search_Load_Table(Date today, Date tenDayForward, JTable table) throws ClassNotFoundException, SQLException {
                       
        String SQLQuery = "SELECT MA_MUON_TRA AS [Mã mượn trả], "
                + "MUON_TRA.MA_DOC_GIA AS[Mã độc giả], "
                + "DOC_GIA.TEN_DOC_GIA AS [Tên độc giả], "
                + "MUON_TRA.MA_NHAN_VIEN AS[Mã nhân viên], "
                + "NHAN_VIEN.TEN_NHAN_VIEN AS[Tên nhân viên], "
                + "NGAY_MUON AS [Ngày mượn], "
                + "HAN_TRA AS[Hạn trả], "
                + "TIEN_COC AS[Tiền cọc], "
                + "MUON_TRA.TIEN_PHAT AS[Tiền phạt] "
                + "FROM MUON_TRA, DOC_GIA, NHAN_VIEN "
                + "WHERE DOC_GIA.MA_DOC_GIA = MUON_TRA.MA_DOC_GIA "
                + "AND NHAN_VIEN.MA_NHAN_VIEN = MUON_TRA.MA_NHAN_VIEN AND "
                + "HAN_TRA <= '" + tenDayForward.toString() + "' AND "
                + "HAN_TRA >= '" + today.toString() + "'";
        con = KetNoi.getConnect();
        rs = con.prepareStatement(SQLQuery).executeQuery();
        table.setModel((DbUtils.resultSetToTableModel(rs)));
    }
    
    public static void Search_Load_Table(JTable table, String MaMT, String MaDG, String MaNV, String NgayMuon, String HanTra, String TienCoc, String TienPhat) throws ClassNotFoundException, SQLException {
        String SQLQuery = "SELECT "
                + "MA_MUON_TRA AS [Mã mượn trả], "
                + "MUON_TRA.MA_DOC_GIA AS[Mã độc giả], "
                + "DOC_GIA.TEN_DOC_GIA AS [Tên độc giả], "
                + "MUON_TRA.MA_NHAN_VIEN AS[Mã nhân viên], "
                + "NHAN_VIEN.TEN_NHAN_VIEN AS[Tên nhân viên], "
                + "NGAY_MUON AS [Ngày mượn], "
                + "HAN_TRA AS[Hạn trả], "
                + "TIEN_COC AS[Tiền cọc], "
                + "MUON_TRA.TIEN_PHAT AS[Tiền phạt] "
                + "FROM MUON_TRA, DOC_GIA, NHAN_VIEN "
                + "WHERE ("
                + "MUON_TRA.MA_MUON_TRA LIKE N'%" + MaMT + "%' AND "
                + "MUON_TRA.MA_DOC_GIA LIKE N'%" + MaDG + "%' AND "
                + "MUON_TRA.MA_NHAN_VIEN LIKE N'%" + MaNV + "%' AND "
                + "NGAY_MUON LIKE N'%" + NgayMuon + "%' AND "
                + "HAN_TRA LIKE N'%" + HanTra + "%' AND "
                + "TIEN_COC LIKE N'%" + TienCoc + "%' AND "
                + "MUON_TRA.TIEN_PHAT LIKE N'%" + TienPhat + "%') AND "
                + "DOC_GIA.MA_DOC_GIA = MUON_TRA.MA_DOC_GIA AND "
                + "NHAN_VIEN.MA_NHAN_VIEN = MUON_TRA.MA_NHAN_VIEN";
        
        con = KetNoi.getConnect();
        rs = con.prepareStatement(SQLQuery).executeQuery();
        table.setModel((DbUtils.resultSetToTableModel(rs)));
    }
    
    public static void DeleteReCord(String MaMT){
            
        ChiTietMuonDAO.DeleteReCord(MaMT);
        String SQLQuery = "DELETE FROM MUON_TRA WHERE MA_MUON_TRA = '" + MaMT + "'";//"DELETE FROM SACH WHERE MA_SACH = ?";
        try {
            con = KetNoi.getConnect();
            con.prepareStatement(SQLQuery).execute();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MuonTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<String> takeMaMT() throws ClassNotFoundException, SQLException{
        
        ArrayList<String> list = new ArrayList<String>();
        String SQLQuery = "SELECT MA_MUON_TRA FROM MUON_TRA";
        con = KetNoi.getConnect();
        rs = con.prepareStatement(SQLQuery).executeQuery();
        while(rs.next()) list.add(rs.getString(1));
        
        return list;
    }
    
    private static void UpdateTienPhatTrongRecord(String maMT, long tienPhat) throws ClassNotFoundException, SQLException{
        
        con = KetNoi.getConnect();
        con.prepareStatement("UPDATE MUON_TRA SET TIEN_PHAT = " + tienPhat + " WHERE MA_MUON_TRA = '" + maMT + "'").execute();
    }
    
    public static void updateTienPhat() throws ClassNotFoundException, SQLException, ParseException{
        
        long thoiDiemHT = System.currentTimeMillis();
        Date homNay = new Date(thoiDiemHT);
        
        con = KetNoi.getConnect();
        rs = con.prepareStatement("SELECT * FROM MUON_TRA").executeQuery();
        
        while (rs.next()){
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date hanTra = sdf.parse(rs.getString(5));
            long thoiDiemHanTra = hanTra.getTime();
            
            if (thoiDiemHanTra < thoiDiemHT){
                
                String maMT = rs.getString(1);
                long tienPhat = ChiTietMuonDAO.TinhTienPhat(maMT, sdf.format(hanTra), sdf.format(homNay));
                
                UpdateTienPhatTrongRecord(maMT, tienPhat);
            }
            else {
                String maMT = rs.getString(1);
                UpdateTienPhatTrongRecord(maMT, 0);
            }
        }
    }
    
    public static Boolean isIDExistence(String ID){
            
            try {
                con = KetNoi.getConnect();
                ps = con.prepareStatement("SELECT MA_MUON_TRA FROM MUON_TRA");
                rs = ps.executeQuery();
                while (rs.next()) {
                    if (ID.equals(rs.getString(1).trim())) {
                        return true;
                    }
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            return false;
    }
    
    public static void InPhieuMuonTra(JTable table, MuonTraDTO tempDTO, String TienCoc, String TienPhat) {

        try {

            DefaultTableModel df = (DefaultTableModel) table.getModel();
            JRTableModelDataSource dts = new JRTableModelDataSource(df);

            String log4jConfPath = "src/dal/log4j.properties";
            PropertyConfigurator.configure(log4jConfPath);

            con = KetNoi.getConnect();
            String path = "src/forms/PhieuMuon.jrxml";
            JasperDesign jd = JRXmlLoader.load(path);

            JasperReport jr = JasperCompileManager.compileReport(path);
            Map<String, Object> params = new HashMap<String, Object>();
            
            params.put("MaMT", tempDTO.getMaMT());
            params.put("MaDG", tempDTO.getMaDG());
            params.put("MaNV", tempDTO.getMaNV());
            params.put("NgayMuon", tempDTO.getNgayMuon().toString());
            params.put("HanTra", tempDTO.getHanTra().toString());
            
            params.put("TienCoc", TienCoc);
            params.put("TienPhat", TienPhat);
            
            params.put("TenDG", DocGiaDAO.getTenDG(tempDTO.getMaDG()));
            params.put("TenNV", NhanVienDAO.getTenNV(tempDTO.getMaNV()));

            JasperPrint jp = JasperFillManager.fillReport(jr, params, dts);
            JasperViewer.viewReport(jp, false);

            JRStyle[] styles = jp.getStyles();
            for (int i = 0; i < styles.length; i++) {
                styles[i].setPdfFontName("C:\\Windows\\Fonts\\Arial.ttf");
            }
        } catch (ClassNotFoundException | SQLException | JRException ex) {
            Logger.getLogger(MuonTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void UpdateTienCocTrongRecord(String maMT, long tienCoc) throws ClassNotFoundException, SQLException{
        
        con = KetNoi.getConnect();
        con.prepareStatement("UPDATE MUON_TRA SET TIEN_COC = " + tienCoc + " WHERE MA_MUON_TRA = '" + maMT + "'").execute();
    }
    
    public static void XuatBieuMauTimKiem(JTable table, String TenBC) {
        
        try {

            DefaultTableModel df = (DefaultTableModel) table.getModel();
            JRTableModelDataSource dts = new JRTableModelDataSource(df);
            
            String log4jConfPath = "src/dal/log4j.properties";
            PropertyConfigurator.configure(log4jConfPath);
            
            con = KetNoi.getConnect();
            String path = "src/forms/MuonTra_BieuMau_TimKiem.jrxml";
            JasperDesign jd = JRXmlLoader.load(path);
            
            JasperReport jr = JasperCompileManager.compileReport(path);
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("TenBC", TenBC);
            
            JasperPrint jp = JasperFillManager.fillReport(jr, params, dts);
            JasperViewer.viewReport(jp, false);
            
            JRStyle[] styles = jp.getStyles();
            for (int i = 0; i < styles.length; i++) {
                styles[i].setPdfFontName("C:\\Windows\\Fonts\\Arial.ttf");
            }
        } catch (ClassNotFoundException | SQLException | JRException ex) {
            Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void TK(JTable table, String SQLQuery) throws ClassNotFoundException, SQLException{
            
            con = KetNoi.getConnect();
            ps = con.prepareStatement(SQLQuery);
            rs = ps.executeQuery();
            table.setModel((DbUtils.resultSetToTableModel(rs)));
    }
    
    public static void InBieuMauThK(JTable table, String TenBC, String col0Name, String col1Name, String col2Name) {
        
        try {

            DefaultTableModel df = (DefaultTableModel) table.getModel();
            JRTableModelDataSource dts = new JRTableModelDataSource(df);
            
            String log4jConfPath = "src/dal/log4j.properties";
            PropertyConfigurator.configure(log4jConfPath);
            
            con = KetNoi.getConnect();
            String path = "src/forms/MuonTra_ThK.jrxml";
            JasperDesign jd = JRXmlLoader.load(path);
            
            JasperReport jr = JasperCompileManager.compileReport(path);
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("TenBC", TenBC);
            params.put("col0Name", col0Name);
            params.put("col1Name", col1Name);
            params.put("col2Name", col2Name);
            
            JasperPrint jp = JasperFillManager.fillReport(jr, params, dts);
            JasperViewer.viewReport(jp, false);
            
            JRStyle[] styles = jp.getStyles();
            for (int i = 0; i < styles.length; i++) {
                styles[i].setPdfFontName("C:\\Windows\\Fonts\\Arial.ttf");
            }
        } catch (ClassNotFoundException | SQLException | JRException ex) {
            Logger.getLogger(BaoCaoSachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
