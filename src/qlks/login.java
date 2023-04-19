
package qlks;

import java.awt.*;
import javax.swing.*;

public class login extends JFrame {
    login()
    {
        getContentPane().setBackground(Color.PINK);
        
        setLayout(null);
        
        JLabel us = new JLabel("Ten Tai Khoan");
        us.setBounds(40, 20, 100, 30);
        add(us);
        
        JTextField usname = new JTextField();
        usname.setBounds(150, 20, 150, 30);
        add(usname);
                
        JLabel pw = new JLabel("Mat Khau");
        pw.setBounds(40, 70, 100, 30);
        add(pw);
        
        JTextField pword = new JTextField();
        pword.setBounds(150, 70, 150, 30);
        add(pword);
        
        JButton dn = new JButton("DANG NHAP");
        dn.setBounds(40, 150, 120, 30);
        dn.setBackground(Color.BLACK);
        dn.setForeground(Color.white);
        add(dn);
        
        JButton thoat = new JButton("THOAT");
        thoat.setBounds(180, 150, 120, 30);
        thoat.setBackground(Color.BLACK);
        thoat.setForeground(Color.white);
        add(thoat);
        
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icons/pic2.jpg"));
        Image i2_1 = i2.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i2_2 = new ImageIcon(i2_1);
        JLabel anh2 = new JLabel(i2_2);
        anh2.setBounds(350, 10, 200, 200);
        add(anh2);
        
        setBounds(500, 200,600 , 300);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new login();
    }
}
