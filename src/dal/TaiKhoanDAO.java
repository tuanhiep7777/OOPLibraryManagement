package dal;

import dto.TaiKhoanDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaiKhoanDAO {

    public static PreparedStatement ps;
    public static ResultSet rs;
    
    public static TaiKhoanDTO XacThuc(String user, String password) throws ClassNotFoundException, SQLException{
        
        TaiKhoanDTO TaiKhoan = null;
        String SQLQuery = "SELECT * FROM TAI_KHOAN_DANG_NHAP where TEN_DANG_NHAP = ? and MAT_KHAU = ?";
        ps = KetNoi.getConnect().prepareStatement(SQLQuery);
            //("SELECT * FROM TAI_KHOAN_DANG_NHAP where TEN_DANG_NHAP = " + user + " and MAT_KHAU = " + password);
        ps.setString(1, user);
        ps.setString(2, password);
        rs = ps.executeQuery();
        
        if (rs.next())
            TaiKhoan = new TaiKhoanDTO(user, password, rs.getByte(3));
        
        return TaiKhoan;
    }
    
    public static void Them(String user, String password, int rule) throws ClassNotFoundException, SQLException{
        String SQLQuery = "INSERT INTO TAI_KHOAN_DANG_NHAP VALUES (?, ?, ?)";
        ps = KetNoi.getConnect().prepareStatement(SQLQuery);
        ps.setString(1, user);
        ps.setString(2, password);
        ps.setInt(3, rule);
        ps.execute();
    }
    
    public static void Xoa(String user) throws ClassNotFoundException, SQLException{
        String SQLQuery = "DELETE FROM TAI_KHOAN_DANG_NHAP WHERE TEN_DANG_NHAP = '" + user + "'";
        ps = KetNoi.getConnect().prepareStatement(SQLQuery);
        ps.execute();
    }
    
    public static void CapNhat(String user, String password) throws ClassNotFoundException, SQLException{
        
        String SQLQuery = "UPDATE TAI_KHOAN_DANG_NHAP SET MAT_KHAU = '" + password + "' WHERE TEN_DANG_NHAP = '" + user + "'";
        KetNoi.getConnect().prepareStatement(SQLQuery).execute();
    }
}
