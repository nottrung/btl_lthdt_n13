package qlks;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Dsphong extends JFrame implements ActionListener{

    JTable danhsach;
    JButton them, tra, thoat;
    JTextField ftenthue, fsocc, ftgthue;
    Choice sphong;

    Dsphong() {
        setLayout(null);
        setBounds(500, 150, 650, 400);
        getContentPane().setBackground(Color.WHITE);
        setTitle("DANH SÁCH PHÒNG");

        danhsach = new JTable();
        danhsach.setBounds(0, 30, 200, 350);
        add(danhsach);
        
        try {
            Ketnoi kn = new Ketnoi();
            ResultSet rs = kn.s.executeQuery("select * from rooms");
            danhsach.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JLabel l1 = new JLabel("SỐ PHÒNG");
        l1.setBounds(0, 0, 80, 30);
        add(l1);
        
        JLabel l2 = new JLabel("TRẠNG THÁI");
        l2.setBounds(100, 0, 80, 30);
        add(l2);
        
        JLabel tenthue = new JLabel("TÊN KHÁCH");
        tenthue.setFont(new Font("", Font.PLAIN, 17));
        tenthue.setBounds(250, 30, 120, 30);
        add(tenthue);

        //nhap ten nguoi thue
        ftenthue = new JTextField();
        ftenthue.setBounds(400, 30, 150, 30);
        add(ftenthue);

        JLabel socc = new JLabel("SỐ CCCD");
        socc.setFont(new Font("", Font.PLAIN, 17));
        socc.setBounds(250, 80, 120, 30);
        add(socc);

        //nhap so cccd
        fsocc = new JTextField();
        fsocc.setBounds(400, 80, 150, 30);
        add(fsocc);

        JLabel sophg = new JLabel("SỐ PHÒNG");
        sophg.setFont(new Font("", Font.PLAIN, 17));
        sophg.setBounds(250, 130, 120, 30);
        add(sophg);

        //nhap so phong
        sphong = new Choice();
        sphong.setBounds(400, 130, 150, 30);
        sphong.setBackground(Color.WHITE);
        add(sphong);
        
        try 
        {
            Ketnoi kn = new Ketnoi();
            ResultSet rs = kn.s.executeQuery("select * from rooms as r left join booking as b on r.sophong = b.sophong where b.sophong is null");
            while(rs.next())
            {
                sphong.add(rs.getString("sophong"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //gia phong la 200k/dem
        JLabel tgthue = new JLabel("THỜI GIAN THUÊ");
        tgthue.setFont(new Font("", Font.PLAIN, 17));
        tgthue.setBounds(250, 180, 150, 30);
        add(tgthue);

        //nhap thoi gian thue
        ftgthue = new JTextField();
        ftgthue.setBounds(400, 180, 100, 30);
        add(ftgthue);

        JLabel ngay = new JLabel("đêm");
        ngay.setFont(new Font("", Font.PLAIN, 17));
        ngay.setBounds(510, 180, 100, 30);
        add(ngay);

        JLabel giathue = new JLabel("GIÁ THUÊ");
        giathue.setFont(new Font("", Font.PLAIN, 17));
        giathue.setBounds(250, 230, 150, 30);
        add(giathue);

        JLabel tienthue = new JLabel("200.000/ĐÊM");
        tienthue.setFont(new Font("", Font.PLAIN, 17));
        tienthue.setBounds(400, 230, 150, 30);
        add(tienthue);
        
        them = new JButton("ĐẶT PHÒNG");
        them.setBounds(230, 270, 120, 30);
        them.setBackground(Color.CYAN);
        them.setForeground(Color.WHITE);
        them.addActionListener(this);
        add(them);
        
        tra = new JButton("TRẢ PHÒNG");
        tra.setBounds(470, 270, 120, 30);
        tra.setBackground(Color.CYAN);
        tra.setForeground(Color.WHITE);
        tra.addActionListener(this);
        add(tra);
        
        
        thoat = new JButton("QUAY LẠI");
        thoat.setBounds(350, 320, 120, 30);
        thoat.setBackground(Color.CYAN);
        thoat.setForeground(Color.WHITE);
        thoat.addActionListener(this);
        add(thoat);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ace) {
        String ten = ftenthue.getText();
        String cccd = fsocc.getText();
        String thoigian = ftgthue.getText();
        
        String sophong = (String) sphong.getSelectedItem();
        
        if(ace.getSource() == them)
        {
            try {
                Ketnoi kn = new Ketnoi();

                Statement st = kn.c.createStatement();
                String capnhat = "update rooms set trangthai = 'đã thuê' where sophong = " + sophong;
                String truyvan = "insert into booking values('" + ten + "', '" + cccd + "', '" + sophong + "', '" + thoigian + "');";
                st.executeUpdate(capnhat);
                st.executeUpdate(truyvan);
                JOptionPane.showMessageDialog(null, "Thêm phòng thành công");
                setVisible(false);
                new Dsphong();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(ace.getSource() ==  thoat)
        {
            setVisible(false);
            new Letan();
        }else if(ace.getSource() == tra)
        {
            setVisible(false);
            new Traphong();
        }
    }
    

    public static void main(String[] args) {
        new Dsphong();
    }
}
