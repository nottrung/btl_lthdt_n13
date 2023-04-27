
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
        setBounds(500, 200, 300, 470);
        getContentPane().setBackground(Color.PINK);//tao mau nen

        setLayout(null);

        JLabel us = new JLabel("Ten Tai Khoan");
        us.setBounds(15, 230, 100, 30);//vi tri
        add(us);

        //box de dien ten tk
        usname = new JTextField();
        usname.setBounds(105, 230, 150, 30);
        add(usname);

        JLabel pw = new JLabel("Mat Khau");
        pw.setBounds(15, 270, 100, 30);
        add(pw);

        pword = new JPasswordField();
        pword.setBounds(105, 270, 150, 30);
        add(pword);

        //nut dn
        dn = new JButton("DANG NHAP");
        dn.setBounds(60, 320, 150, 30);
        dn.setBackground(Color.BLACK);
        dn.setForeground(Color.white);
        dn.addActionListener(this);
        add(dn);

        //nut thoat
        thoat = new JButton("THOAT");
        thoat.setBounds(60, 360, 150, 30);
        thoat.setBackground(Color.BLACK);
        thoat.setForeground(Color.white);
        thoat.addActionListener(this);
        add(thoat);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icons/pic2.jpg"));
        Image i2_1 = i2.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i2_2 = new ImageIcon(i2_1);
        JLabel anh2 = new JLabel(i2_2);
        anh2.setBounds(40, 10, 200, 200);
        add(anh2);

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
                    JOptionPane.showMessageDialog(this, "tai khoan hoac mat khau khong dung","ERROR", JOptionPane.ERROR_MESSAGE);
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
