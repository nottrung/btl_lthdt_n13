package qlks;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class Traphong extends JFrame implements ActionListener {

    JButton xn, thoat, check;
    JTextField ftenkh, fcccd, ftp;
    Choice sophg;

    Traphong() {
        setLayout(null);
        setBounds(500, 150, 400, 400);
        setTitle("TRẢ PHÒNG");
        getContentPane().setBackground(Color.WHITE);

        JLabel sp = new JLabel("SỐ PHÒNG");
        sp.setBounds(20, 30, 100, 30);
        add(sp);

        sophg = new Choice();
        sophg.setBounds(150, 35, 150, 30);
        sophg.setBackground(Color.WHITE);
        add(sophg);
        
        Ketnoi kn = new Ketnoi();
        try 
        {
            
            ResultSet rs = kn.s.executeQuery("select * from booking");
            while(rs.next())
            {
                sophg.add(rs.getString("sophong"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        JLabel tenkh = new JLabel("TÊN KHÁCH HÀNG");
        tenkh.setBounds(20, 80, 200, 30);
        add(tenkh);

        //o ten kh
        ftenkh = new JTextField();
        ftenkh.setBounds(150, 80, 150, 30);
        ftenkh.setBackground(Color.WHITE);
        add(ftenkh);
        
        JLabel cccd = new JLabel("SỐ CCCD");
        cccd.setBounds(20, 130, 200, 30);
        add(cccd);

        //o cccd
        fcccd = new JTextField();
        fcccd.setBounds(150, 130, 150, 30);
        fcccd.setBackground(Color.WHITE);
        add(fcccd);
        
        JLabel tgthue = new JLabel("SỐ TIỀN");
        tgthue.setBounds(20, 180, 200, 30);
        add(tgthue);

        //o tgt
        ftp = new JTextField();
        ftp.setBounds(150, 180, 150, 30);
        ftp.setBackground(Color.WHITE);
        add(ftp);
        
        check = new JButton("KIỂM TRA");
        check.setBounds(20, 250, 120, 30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.white);
        check.addActionListener(this);
        add(check);

        xn = new JButton("TRẢ PHÒNG");
        xn.setBackground(Color.BLACK);
        xn.setForeground(Color.white);
        xn.setBounds(180, 250, 120, 30);
        xn.addActionListener(this);
        add(xn);

        thoat = new JButton("THOÁT");
        thoat.setBackground(Color.BLACK);
        thoat.setForeground(Color.white);
        thoat.setBounds(100, 300, 120, 30);
        thoat.addActionListener(this);
        add(thoat);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ace) {
        Ketnoi kn = new Ketnoi();
        if(ace.getSource() == check)
        {
            String sophong = (String) sophg.getSelectedItem();
            String query1 = "select * from booking where sophong = " + sophong;
              
            try {      
                ResultSet rs1 = kn.s.executeQuery(query1);
                while(rs1.next())
                {
                    ftenkh.setText(rs1.getString("tenkh"));
                    fcccd.setText(rs1.getString("cccd"));
                    String tg = "select tgthue from booking where sophong = " + sophong;
                    ResultSet rs2 = kn.s.executeQuery(tg);
                    int tgo = 0;
                    if (rs2.next()) {
                        tgo = rs2.getInt("tgthue");
                    }
                    int tien = 0;
                    if (tgo < 2) {
                        tien = 200000;
                    } else {
                        tien = tgo * 200000;
                    }
                    ftp.setText(String.valueOf(tien));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(ace.getSource() == xn)
        {
            String sophong = (String) sophg.getSelectedItem();
            try {
                Statement st = kn.c.createStatement();
                String capnhat = "update rooms set trangthai = 'trống' where sophong = " + sophong;
                String truyvan = "delete from booking where sophong = " + sophong;
                st.executeUpdate(capnhat);
                st.executeUpdate(truyvan);
                JOptionPane.showMessageDialog(null, "Trả phòng thành công");
                setVisible(false);
                new Dsphong();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(ace.getSource() == thoat)
        {
            setVisible(false);
            new Dsphong();
        }
    }

    public static void main(String[] args) {
        new Traphong();
    }
}
