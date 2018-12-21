package dal;

import dto.SachDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class SachDAO {

    private static Statement stmt;
    private static ResultSet rs;
    private static Connection con;
    private static PreparedStatement ps;

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public static void ThemTuFile(File file) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {

        FileInputStream input = new FileInputStream(file);
        HSSFWorkbook workbook = new HSSFWorkbook(input);
        HSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        while (rowIterator.hasNext()) {

            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            SachDTO newDTO = new SachDTO();
            Cell cell;

            cell = cellIterator.next();
            newDTO.setMaSach(cell.getStringCellValue());

            cell = cellIterator.next();
            newDTO.setTenSach(cell.getStringCellValue());

            cell = cellIterator.next();
            newDTO.setTenTacGia(cell.getStringCellValue());

            cell = cellIterator.next();
            newDTO.setTheLoai(cell.getStringCellValue());

            cell = cellIterator.next();
            newDTO.setNXB(cell.getStringCellValue());

            cell = cellIterator.next();
            newDTO.setNamXuatBan((short) cell.getNumericCellValue());

            cell = cellIterator.next();
            newDTO.setDonGia((int) cell.getNumericCellValue());

            cell = cellIterator.next();
            newDTO.setSoLuong((short) cell.getNumericCellValue());

            SachDAO.Them(newDTO);
        }
    }

    public static void XuatRaFile(File file, TableModel model) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("ahihi");

        Cell cell;
        Row row;

        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);

        row = sheet.createRow(0);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Mã sách");

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Tên sách");

        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Tên tác giả");

        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Thể loại");

        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Nhà xuất bản");

        cell = row.createCell(5, CellType.NUMERIC);
        cell.setCellValue("Năm xuất bản");

        cell = row.createCell(6, CellType.NUMERIC);
        cell.setCellValue("Đơn giá (VNĐ)");

        cell = row.createCell(7, CellType.NUMERIC);
        cell.setCellValue("Số lượng (quyển)");

        int rowIndex = 1;

        while (rowIndex < model.getRowCount() + 1) {

            row = sheet.createRow(rowIndex);

            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue((model.getValueAt(rowIndex - 1, 0)).toString());

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue((model.getValueAt(rowIndex - 1, 1)).toString());

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue((model.getValueAt(rowIndex - 1, 2)).toString());

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue((model.getValueAt(rowIndex - 1, 3)).toString());

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue((model.getValueAt(rowIndex - 1, 4)).toString());

            cell = row.createCell(5, CellType.NUMERIC);
            cell.setCellValue((Short) model.getValueAt(rowIndex - 1, 5));

            cell = row.createCell(6, CellType.NUMERIC);
            cell.setCellValue((int) Float.parseFloat((model.getValueAt(rowIndex - 1, 6)).toString()));

            cell = row.createCell(7, CellType.NUMERIC);
            cell.setCellValue((Short) model.getValueAt(rowIndex - 1, 7));

            file.getParentFile().mkdirs();

            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
            rowIndex++;
        }
    }

    public static void XuatRaFile(File file) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("ahihi");

        int rowNum = 0;
        Cell cell;
        Row row;

        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);

        String SQLQuery = "SELECT * FROM SACH";
        Connection con = KetNoi.getConnect();
        PreparedStatement ps = con.prepareStatement(SQLQuery);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            row = sheet.createRow(rowNum);

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(rs.getString(1));

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(rs.getString(2));

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(rs.getString(3));

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue(rs.getString(4));

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue(rs.getString(5));

            cell = row.createCell(6, CellType.NUMERIC);
            cell.setCellValue(rs.getShort(6));

            cell = row.createCell(7, CellType.NUMERIC);
            cell.setCellValue(rs.getInt(7));

            cell = row.createCell(8, CellType.NUMERIC);
            cell.setCellValue(rs.getShort(8));

            //File file = new File("F:/Sach.xls");
            file.getParentFile().mkdirs();

            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
            rowNum++;
        }
    }

    public static void Them(SachDTO newBook) throws ClassNotFoundException, SQLException {

        con = KetNoi.getConnect();

        ps = con.prepareStatement("INSERT INTO SACH VALUES(?,?,?,?,?,?,?,?)");
        ps.setString(1, newBook.getMaSach());
        ps.setString(2, newBook.getTenSach());
        ps.setString(3, newBook.getTenTacGia());
        ps.setString(4, newBook.getTheLoai());
        ps.setString(5, newBook.getNXB());
        ps.setShort(6, newBook.getNamXuatBan());
        ps.setInt(7, newBook.getDonGia());
        ps.setShort(8, newBook.getSoLuong());

        ps.execute();
    }

    public static void LoadDuLieu(JTable table) throws ClassNotFoundException, SQLException {
        String SQLQuery = "SELECT * FROM SACH";
        con = KetNoi.getConnect();
        ps = con.prepareStatement(SQLQuery);
        rs = ps.executeQuery();
        table.setModel((DbUtils.resultSetToTableModel(rs)));
    }

    public static void LoadDuLieu1(JTable table) throws ClassNotFoundException, SQLException {
        String SQLQuery = "SELECT MA_SACH, TEN_SACH, TEN_TAC_GIA FROM SACH";
        con = KetNoi.getConnect();
        ps = con.prepareStatement(SQLQuery);
        rs = ps.executeQuery();
        table.setModel((DbUtils.resultSetToTableModel(rs)));
    }

    public static SachDTO LoadRowContent(String MaS) throws SQLException, ClassNotFoundException {
        String SQLQuery = "SELECT * FROM SACH WHERE MA_SACH = '" + MaS + "'";
        try {
            con = KetNoi.getConnect();
            rs = con.prepareStatement(SQLQuery).executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        SachDTO temp = new SachDTO();
        if (rs.next()) {
            temp.setMaSach(rs.getString(1));
            temp.setTenSach(rs.getString(2));
            temp.setTenTacGia(rs.getString(3));
            temp.setTheLoai(rs.getString(4));
            temp.setNXB(rs.getString(5));
            temp.setNamXuatBan(rs.getShort(6));
            temp.setDonGia(rs.getInt(7));
            temp.setSoLuong(rs.getShort(8));
        }
        return temp;
    }

    public static void ModifyRecord(SachDTO newBook) throws SQLException {
        String SQLQuery = "UPDATE SACH"
                + " SET TEN_SACH = ?,"
                + "TEN_TAC_GIA = ?,"
                + "THE_LOAI = ?,"
                + "NXB = ?,"
                + "NAM_XUAT_BAN = ?,"
                + "DON_GIA = ?,"
                + "SO_LUONG = ? "
                + "WHERE MA_SACH = ?";
        ps = con.prepareStatement(SQLQuery);
        ps.setString(8, newBook.getMaSach());
        ps.setString(1, newBook.getTenSach());
        ps.setString(2, newBook.getTenTacGia());
        ps.setString(3, newBook.getTheLoai());
        ps.setString(4, newBook.getNXB());
        ps.setShort(5, newBook.getNamXuatBan());
        ps.setInt(6, newBook.getDonGia());
        ps.setShort(7, newBook.getSoLuong());

        ps.execute();
    }

    public static void DeleteReCord(String MaS) {

        String SQLQuery = "DELETE FROM SACH WHERE MA_SACH = '" + MaS + "'";//"DELETE FROM SACH WHERE MA_SACH = ?";
        try {
            con = KetNoi.getConnect();
            con.prepareStatement(SQLQuery).execute();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void Search_Load_Table(String TieuChiTK, String NoiDungTK, JTable table) throws ClassNotFoundException, SQLException {
        String SQLQuery = "SELECT * FROM SACH WHERE " + TieuChiTK + " LIKE N'%" + NoiDungTK + "%'";
        con = KetNoi.getConnect();
        rs = con.prepareStatement(SQLQuery).executeQuery();
        table.setModel((DbUtils.resultSetToTableModel(rs)));
    }
    
    public static void Search_Load_Table(String NoiDungTK, JTable table) throws ClassNotFoundException, SQLException {
        String SQLQuery = "SELECT * FROM SACH WHERE MA_SACH LIKE N'%" + NoiDungTK + "%' OR "
                + "TEN_SACH LIKE N'%" + NoiDungTK + "%' OR "
                + "TEN_TAC_GIA LIKE N'%" + NoiDungTK + "%' OR "
                + "THE_LOAI LIKE N'%" + NoiDungTK + "%' OR "
                + "NXB LIKE N'%" + NoiDungTK + "%' OR "
                + "NAM_XUAT_BAN LIKE N'%" + NoiDungTK + "%' OR "
                + "DON_GIA LIKE N'%" + NoiDungTK + "%' OR "
                + "SO_LUONG LIKE N'%" + NoiDungTK + "%'";
        con = KetNoi.getConnect();
        rs = con.prepareStatement(SQLQuery).executeQuery();
        table.setModel((DbUtils.resultSetToTableModel(rs)));
    }
    
    public static void Search_Load_Table(JTable table, String maS, String tenS, String tenTG, String theLoai, String NXB, String namXB, String donGia, String SL) throws ClassNotFoundException, SQLException {
        String SQLQuery = "SELECT * FROM SACH WHERE MA_SACH LIKE N'%" + maS + "%' AND "
                + "TEN_SACH LIKE N'%" + tenS + "%' AND "
                + "TEN_TAC_GIA LIKE N'%" + tenTG + "%' AND "
                + "THE_LOAI LIKE N'%" + theLoai + "%' AND "
                + "NXB LIKE N'%" + NXB + "%' AND "
                + "NAM_XUAT_BAN LIKE N'%" + namXB + "%' AND "
                + "DON_GIA LIKE N'%" + donGia + "%' AND "
                + "SO_LUONG LIKE N'%" + SL + "%'";
        con = KetNoi.getConnect();
        rs = con.prepareStatement(SQLQuery).executeQuery();
        table.setModel((DbUtils.resultSetToTableModel(rs)));
    }

    public static ArrayList<String> takeMaS() throws ClassNotFoundException, SQLException {

        ArrayList<String> list = new ArrayList<String>();
        String SQLQuery = "SELECT MA_SACH FROM SACH";
        con = KetNoi.getConnect();
        rs = con.prepareStatement(SQLQuery).executeQuery();
        while (rs.next()) {
            list.add(rs.getString(1));
        }
        return list;
    }

    public static void TK(JTable table, String TieuChiTK, String VietnameseName) throws ClassNotFoundException, SQLException {

        String SQLQuery = "SELECT " + TieuChiTK + " AS [" + VietnameseName + "], COUNT(MA_SACH) AS [Số lượng] FROM SACH GROUP BY " + TieuChiTK;
        con = KetNoi.getConnect();
        ps = con.prepareStatement(SQLQuery);
        rs = ps.executeQuery();
        table.setModel((DbUtils.resultSetToTableModel(rs)));
    }

    public static Boolean isIDExistence(String ID) {

        try {
            con = KetNoi.getConnect();
            ps = con.prepareStatement("SELECT MA_SACH FROM SACH");
            rs = ps.executeQuery();
            while (rs.next()) {
                if (ID.equals(rs.getString(1).trim())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static String getTenSach(String MaS){
        
        try {
            con = KetNoi.getConnect();
            rs = con.prepareStatement("SELECT TOP (1) TEN_SACH FROM SACH WHERE MA_SACH = '" + MaS +"'").executeQuery();
            rs.next();
            
            return rs.getString(1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            String path = "src/forms/Sach_BieuMau_TimKiem.jrxml";
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
            Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static short getSL(String maS) throws ClassNotFoundException, SQLException{
        
        String SQLQuery = "SELECT SO_LUONG FROM SACH WHERE MA_SACH = '" + maS + "'";
        rs = KetNoi.getConnect().prepareStatement(SQLQuery).executeQuery();
        rs.next();
        
        return rs.getShort(1);
    }
    
    public static void updateSLSach(String maS, short SL) throws ClassNotFoundException, SQLException{
        
        String SQLQuery = "UPDATE SACH SET SO_LUONG = " + SL + " WHERE MA_SACH = '" + maS + "'";
        ps = KetNoi.getConnect().prepareStatement(SQLQuery);
        ps.execute();
    }

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
            con = KetNoi.getConnect();
            String query = "SELECT MA_SACH FROM CHI_TIET_MUON WHERE MA_MUON_TRA = 'abc     '";//"SELECT MA_SACH, TEN_SACH FROM SACH";
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString(1) + " | " + rs.getString(1));
         }

	}
}
