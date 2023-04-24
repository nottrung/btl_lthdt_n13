package qlks;

import java.sql.*;

public class ketnoi {
    
    Connection c;
    
    ketnoi()
    {
        try{
            Class.forName("com.myspl.cj.jdbc.Driver");
            c = DriverManager.getConnection(url)
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        new ketnoi();
    }
}
