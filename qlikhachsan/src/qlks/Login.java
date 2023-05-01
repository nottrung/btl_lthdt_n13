
package qlks;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField usname, pword;
    JButton dn, thoat;
    Ketnoi Knoi;

    Login() {
        setLayout(null);
        setBounds(500, 200, 300, 250);
        getContentPane().setBackground(Color.PINK);//tao mau nen
        setTitle("Đăng Nhập");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel us = new JLabel("Tên Tài Khoản");
        us.setBounds(15, 20, 100, 30);//vi tri
        add(us);

        //box de dien ten tk
        usname = new JTextField();
        usname.setBounds(110, 20, 150, 30);
        add(usname);

        JLabel pw = new JLabel("Mật Khẩu");
        pw.setBounds(15, 70, 100, 30);
        add(pw);

        pword = new JPasswordField();
        pword.setBounds(110, 70, 150, 30);
        add(pword);

        //nut dn
            dn = new JButton("ĐĂNG NHẬP");
        dn.setBounds(60, 120, 150, 30);
        dn.setBackground(Color.BLACK);
        dn.setForeground(Color.white);
        dn.addActionListener(this);
        add(dn);

        //nut thoat
        thoat = new JButton("THOÁT");
        thoat.setBounds(60, 170, 150, 30);
        thoat.setBackground(Color.BLACK);
        thoat.setForeground(Color.white);
        thoat.addActionListener(this);
        add(thoat);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ace) {
        if(ace.getSource() == dn)
        {
            String tk = usname.getText();
            String mk = pword.getText();
            
            try
            {
                Knoi = new Ketnoi();
                String truyvan = "select * from login where tentk = '" + tk + "' and matkhau = '" + mk + "'";
                ResultSet rs = Knoi.s.executeQuery(truyvan);
                
                if(rs.next())
                {
                    setVisible(false);
                    new BangDK();
                }else
                {
                    JOptionPane.showMessageDialog(this, "tài khoản hoặc mật khẩu không đúng","ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }else if(ace.getSource() == thoat)
        {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
