package model;

public class User
{
    private String hoten;
    private String ngaysinh;
    private String cccd;

    //contructor
    public User(String hoten, String ngaysinh, String cccd) {
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.cccd = cccd;
    }

    @Override
    public String toString() {
        return "User [hoten=" + hoten + ", ngaysinh=" + ngaysinh + ", cccd=" + cccd + "]";
    }

    //geter setter
    public String getHoten()
    {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }
}
