
package qlks;
import java.sql.*;

public class Ketnoi {

    Connection c;
    Statement s;

    Ketnoi() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hethongqlks", "root", "1234");
            s = c.createStatement();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Ketnoi();

    }
}
