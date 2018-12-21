package dto;

public class TaiKhoanDTO {

    private String TaiKhoan;
    private String MatKhau;
    private byte Quyen;

    public TaiKhoanDTO() {

    }

    public TaiKhoanDTO(String user, String password, byte quyen) {
        TaiKhoan = user;
        MatKhau = password;
        Quyen = quyen;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        TaiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public byte getQuyen() {
        return Quyen;
    }

    public void setQuyen(byte Quyen) {
        this.Quyen = Quyen;
    }
}
