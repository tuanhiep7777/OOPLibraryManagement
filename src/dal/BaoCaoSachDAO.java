/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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

/**
 *
 * @author hiep.tt166077
 */
public class BaoCaoSachDAO {

    private static Connection con;

    public static void TK_The_loai(JTable table, String TieuChi, String TenBC) {

//        DefaultTableModel df = (DefaultTableModel) table.getModel();
//        JRTableModelDataSource dts = new JRTableModelDataSource(df);
//        String path = "src/forms/Sach_Thk.jrxml"; // AHIHI
//        
//        JasperReport jr;
//        try {
//            jr = JasperCompileManager.compileReport(path);
//            Connection con = KetNoi.getConnect();
//            JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap(), dts);
//            JasperViewer.viewReport(jp, false);
//        } catch (JRException | ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(BaoCaoSachDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
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
        
        
//        try {
//
//            String log4jConfPath = "src/dal/log4j.properties";
//            PropertyConfigurator.configure(log4jConfPath);
//            
//            con = KetNoi.getConnect();
//            String path = "src/forms/Sach_ThK_TheLoai.jrxml";
//            JasperDesign jd = JRXmlLoader.load(path);
//            
////            JRDesignQuery newQr = new JRDesignQuery();
////            newQr.setText("SELECT THE_LOAI AS [Thể loại], COUNT(MA_SACH) AS [Số lượng] FROM SACH GROUP BY THE_LOAI");//"SELECT TAC_GIA AS [Tasc giar], COUNT(MA_SACH) AS [Số lượng] FROM SACH GROUP BY TAC_GIA");
////            jd.setQuery(newQr);
////            JasperReport jr = JasperCompileManager.compileReport(jd);
//
//            JasperReport jr = JasperCompileManager.compileReport(path);
//            JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap(), con);
//            JasperViewer.viewReport(jp, false);
//            
//            JRStyle[] styles = jp.getStyles();
//            for (int i = 0; i < styles.length; i++) {
//                styles[i].setPdfFontName("C:\\Windows\\Fonts\\Arial.ttf");
//            }
//        } catch (ClassNotFoundException | SQLException | JRException ex) {
//            Logger.getLogger(BaoCaoSachDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
