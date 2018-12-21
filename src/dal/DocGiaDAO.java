package dal;

import dto.DocGiaDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author hiep.tt166077
 */
public class DocGiaDAO {
    
    private static Statement stmt;
    private static ResultSet rs;
    private static Connection con;
    private static PreparedStatement ps;
    
    public static void LoadDuLieu(JTable table) throws ClassNotFoundException, SQLException{
            String SQLQuery = "SELECT "
                    + "MA_DOC_GIA AS[Mã DG], "
                    + "TEN_DOC_GIA AS [Tên DG], "
                    + "GIOI_TINH AS [GT], "
                    + "CMND, "
                    + "NGAY_SINH AS [Ngày sinh], "
                    + "DIA_CHI AS [Địa chỉ], "
                    + "SO_DIEN_THOAI AS [SĐT], "
                    + "EMAIL AS [email] "
                    + "FROM DOC_GIA";
            con = KetNoi.getConnect();
            ps = con.prepareStatement(SQLQuery);
            rs = ps.executeQuery();
            table.setModel((DbUtils.resultSetToTableModel(rs)));
    }
    
    public static void Them(DocGiaDTO newDTO) throws ClassNotFoundException, SQLException {
            
            con = KetNoi.getConnect();
            
            ps = con.prepareStatement("INSERT INTO DOC_GIA VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, newDTO.getMaDG());
            ps.setString(2, newDTO.getTenDG());
            ps.setString(3, newDTO.getGioiTinh());
            ps.setLong(4, newDTO.getCMND());
            ps.setDate(5, newDTO.getNgaySinh());
            ps.setString(6, newDTO.getDiaChi());
            ps.setLong(7, newDTO.getSDT());
            ps.setString(8, newDTO.getEmail());
            ps.setLong(9, newDTO.getTaiKhoan());
            ps.setLong(10, newDTO.getTienPhat());
            
            ps.execute();
    }
    
    public static DocGiaDTO LoadRowContent(String MaDG) throws SQLException, ClassNotFoundException{
            String SQLQuery = "SELECT * FROM DOC_GIA WHERE MA_DOC_GIA = '" + MaDG + "'";
            try {
                con = KetNoi.getConnect();
                rs = con.prepareStatement(SQLQuery).executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            DocGiaDTO temp = new DocGiaDTO();
            if (rs.next()){
                temp.setMaDG(rs.getString(1));
                temp.setTenDG(rs.getString(2));
                temp.setGioiTinh(rs.getString(3));
                temp.setCMND(rs.getLong(4));
                temp.setNgaySinh(rs.getDate(5));
                temp.setDiaChi(rs.getString(6));
                temp.setSDT(rs.getLong(7));
                temp.setEmail(rs.getString(8));
                temp.setTaiKhoan(rs.getLong(9));
                temp.setTienPhat(rs.getLong(10));
            }
            return temp;
    }
    
    public static void ModifyRecord(DocGiaDTO newDTO) throws SQLException{
            String SQLQuery = "UPDATE DOC_GIA"
                    + " SET TEN_DOC_GIA = ?,"
                    + "GIOI_TINH = ?,"
                    + "CMND = ?,"
                    + "NGAY_SINH = ?,"
                    + "DIA_CHI = ?,"
                    + "SO_DIEN_THOAI = ?,"
                    + "EMAIL = ?,"
                    + "TAI_KHOAN = ?,"
                    + "TIEN_PHAT = ? "
                    + "WHERE MA_DOC_GIA = ?";
            ps = con.prepareStatement(SQLQuery);
            ps.setString(10, newDTO.getMaDG());
            ps.setString(1, newDTO.getTenDG());
            ps.setString(2, newDTO.getGioiTinh());
            ps.setLong(3, newDTO.getCMND());
            ps.setDate(4, newDTO.getNgaySinh());
            ps.setString(5, newDTO.getDiaChi());
            ps.setLong(6, newDTO.getSDT());
            ps.setString(7, newDTO.getEmail());
            ps.setLong(8, newDTO.getTaiKhoan());
            ps.setLong(9, newDTO.getTienPhat());
            
            ps.execute();
        }
    
    public static void DeleteReCord(String MaDG){
            
            String SQLQuery = "DELETE FROM DOC_GIA WHERE MA_DOC_GIA = '" + MaDG + "'";
            try {
                con = KetNoi.getConnect();
                con.prepareStatement(SQLQuery).execute();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    public static ArrayList<String> takeMaDG() throws ClassNotFoundException, SQLException{
        
        ArrayList<String> list = new ArrayList<String>();
        String SQLQuery = "SELECT MA_DOC_GIA FROM DOC_GIA";
        con = KetNoi.getConnect();
        rs = con.prepareStatement(SQLQuery).executeQuery();
        while(rs.next()) list.add(rs.getString(1));
        
        return list;
    }
    
    public static void TK(JTable table, String TieuChiTK, String VietnameseName) throws ClassNotFoundException, SQLException{
            
            String SQLQuery = "SELECT " + TieuChiTK + " AS [" + VietnameseName + "], COUNT(MA_DOC_GIA) AS [Số lượng] FROM DOC_GIA GROUP BY " + TieuChiTK;
            con = KetNoi.getConnect();
            ps = con.prepareStatement(SQLQuery);
            rs = ps.executeQuery();
            table.setModel((DbUtils.resultSetToTableModel(rs)));
    }
    
    public static void ThemTuFile(File file) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
        
        FileInputStream input = new FileInputStream(file);
        HSSFWorkbook workbook = new HSSFWorkbook(input);
        HSSFSheet sheet = workbook.getSheetAt(0);
        
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        while (rowIterator.hasNext()){
            
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            DocGiaDTO newDTO = new DocGiaDTO();
            Cell cell;
            
            cell = cellIterator.next();
            newDTO.setMaDG(cell.getStringCellValue());
            
            cell = cellIterator.next();
            newDTO.setTenDG(cell.getStringCellValue());
            
            cell = cellIterator.next();
            newDTO.setGioiTinh(cell.getStringCellValue());
            
            cell = cellIterator.next();
            newDTO.setCMND((long) cell.getNumericCellValue());
            
            cell = cellIterator.next();
            newDTO.setNgaySinh(new Date(cell.getDateCellValue().getTime()));
            
            cell = cellIterator.next();
            newDTO.setDiaChi(cell.getStringCellValue());
            
            cell = cellIterator.next();
            newDTO.setSDT((long) cell.getNumericCellValue());
            
            cell = cellIterator.next();
            newDTO.setEmail(cell.getStringCellValue());
            
            cell = cellIterator.next();
            newDTO.setTaiKhoan((long) cell.getNumericCellValue());
            
            cell = cellIterator.next();
            newDTO.setTienPhat((long) cell.getNumericCellValue());
            
            DocGiaDAO.Them(newDTO);
        }        
    }
    
    public static void Search_Load_Table(String TieuChiTK, String NoiDungTK, JTable table) throws ClassNotFoundException, SQLException{
            String SQLQuery = "SELECT "
                    + "MA_DOC_GIA AS[Mã DG], "
                    + "TEN_DOC_GIA AS [Tên DG], "
                    + "GIOI_TINH AS [GT], "
                    + "CMND, "
                    + "NGAY_SINH AS [Ngày sinh], "
                    + "DIA_CHI AS [Địa chỉ], "
                    + "SO_DIEN_THOAI AS [SĐT], "
                    + "EMAIL AS [email] "
                    + "FROM DOC_GIA WHERE " + TieuChiTK + " LIKE N'%" + NoiDungTK + "%'";
            con = KetNoi.getConnect();
            rs = con.prepareStatement(SQLQuery).executeQuery();
            table.setModel((DbUtils.resultSetToTableModel(rs)));
    }
    
    public static void Search_Load_Table(String NoiDungTK, JTable table) throws ClassNotFoundException, SQLException {
        String SQLQuery = "SELECT "
                + "MA_DOC_GIA AS[Mã DG], "
                + "TEN_DOC_GIA AS [Tên DG], "
                + "GIOI_TINH AS [GT], "
                + "CMND, "
                + "NGAY_SINH AS [Ngày sinh], "
                + "DIA_CHI AS [Địa chỉ], "
                + "SO_DIEN_THOAI AS [SĐT], "
                + "EMAIL AS [email] "
                + "FROM DOC_GIA WHERE MA_DOC_GIA LIKE N'%" + NoiDungTK + "%' OR "
                + "TEN_DOC_GIA LIKE N'%" + NoiDungTK + "%' OR "
                + "GIOI_TINH LIKE N'%" + NoiDungTK + "%' OR "
                + "CMND LIKE N'%" + NoiDungTK + "%' OR "
                + "NGAY_SINH LIKE N'%" + NoiDungTK + "%' OR "
                + "DIA_CHI LIKE N'%" + NoiDungTK + "%' OR "
                + "SO_DIEN_THOAI LIKE N'%" + NoiDungTK + "%' OR "
                + "EMAIL LIKE N'%" + NoiDungTK + "%'";
        con = KetNoi.getConnect();
        rs = con.prepareStatement(SQLQuery).executeQuery();
        table.setModel((DbUtils.resultSetToTableModel(rs)));
    }
    
    public static void Search_Load_Table(JTable table, String mDG, String tDG, String GT, String CMND, String NS, String DC, String sdt, String email) throws ClassNotFoundException, SQLException {
        String SQLQuery = "SELECT "
                + "MA_DOC_GIA AS[Mã DG], "
                + "TEN_DOC_GIA AS [Tên DG], "
                + "GIOI_TINH AS [GT], "
                + "CMND, "
                + "NGAY_SINH AS [Ngày sinh], "
                + "DIA_CHI AS [Địa chỉ], "
                + "SO_DIEN_THOAI AS [SĐT], "
                + "EMAIL AS [email] "
                + "FROM DOC_GIA WHERE MA_DOC_GIA LIKE N'%" + mDG + "%' AND "
                + "TEN_DOC_GIA LIKE N'%" + tDG + "%' AND "
                + "GIOI_TINH LIKE N'%" + GT + "%' AND "
                + "CMND LIKE N'%" + CMND + "%' AND "
                + "NGAY_SINH LIKE N'%" + NS + "%' AND "
                + "DIA_CHI LIKE N'%" + DC + "%' AND "
                + "SO_DIEN_THOAI LIKE N'%" + sdt + "%' AND "
                + "EMAIL LIKE N'%" + email + "%'";
        con = KetNoi.getConnect();
        rs = con.prepareStatement(SQLQuery).executeQuery();
        table.setModel((DbUtils.resultSetToTableModel(rs)));
    }
    
    public static Boolean isIDExistence(String ID){
            
            try {
                con = KetNoi.getConnect();
                ps = con.prepareStatement("SELECT MA_DOC_GIA FROM DOC_GIA");
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
    
    public static void TK_The_loai(JTable table, String TieuChi, String TenBC) {
        
        try {

            DefaultTableModel df = (DefaultTableModel) table.getModel();
            JRTableModelDataSource dts = new JRTableModelDataSource(df);
            
            String log4jConfPath = "src/dal/log4j.properties";
            PropertyConfigurator.configure(log4jConfPath);
            
            con = KetNoi.getConnect();
            String path = "src/forms/Sach_ThKTheoSL.jrxml";
            JasperDesign jd = JRXmlLoader.load(path);
            
            JasperReport jr = JasperCompileManager.compileReport(path);
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("TieuChi", TieuChi);
            params.put("TenBC", TenBC);
            
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
    
    public static String getTenDG(String MaDG){
        
        try {
            con = KetNoi.getConnect();
            rs = con.prepareStatement("SELECT TOP (1) TEN_DOC_GIA FROM DOC_GIA WHERE MA_DOC_GIA = '" + MaDG +"'").executeQuery();
            rs.next();
            
            return rs.getString(1);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DocGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void XuatBieuMauTimKiem(JTable table, String TenBC) {
        
        try {

            DefaultTableModel df = (DefaultTableModel) table.getModel();
            JRTableModelDataSource dts = new JRTableModelDataSource(df);
            
            String log4jConfPath = "src/dal/log4j.properties";
            PropertyConfigurator.configure(log4jConfPath);
            
            con = KetNoi.getConnect();
            String path = "src/forms/DocGia_BieuMau_TimKiem.jrxml";
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
}
