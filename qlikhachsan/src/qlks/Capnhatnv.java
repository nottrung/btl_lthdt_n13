package qlks;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Capnhatnv  extends JFrame implements ActionListener{
    
    Choice scccd;
    JTextField fname, fage, fadr, fluong, fsdt, fgt, fvt;
    JButton check, capnhat, sathai, thoat;
    
    Capnhatnv() {
        setLayout(null);
        setBounds(600, 100, 400, 600);
        getContentPane().setBackground(Color.WHITE);
        setTitle("CẬP NHẬT NHÂN VIÊN");
        
        JLabel cccd = new JLabel("SỐ CCCD");
        cccd.setBounds(30, 30, 120, 30);
        cccd.setFont(new Font("", Font.PLAIN, 17));
        add(cccd);
        
        scccd = new Choice();
        scccd.setBounds(150, 35, 150, 30);
        scccd.setBackground(Color.WHITE);
        add(scccd);
        
        Ketnoi kn = new Ketnoi();
        try 
        {
            
            ResultSet rs = kn.s.executeQuery("select * from employee");
            while(rs.next())
            {
                scccd.add(rs.getString("socccd"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        JLabel name = new JLabel("HỌ TÊN");
        name.setBounds(30, 80, 120, 30);
        name.setFont(new Font("", Font.PLAIN, 17));
        add(name);

        //nhap ten
        fname = new JTextField();
        fname.setBounds(150, 80, 150, 30);
        add(fname);

        JLabel age = new JLabel("TUỔI");
        age.setBounds(30, 130, 120, 30);
        age.setFont(new Font("", Font.PLAIN, 17));
        add(age);

        //nhap tuoi
        fage = new JTextField();
        fage.setBounds(150, 130, 150, 30);
        add(fage);

        JLabel adr = new JLabel("ĐIA CHỈ");
        adr.setBounds(30, 180, 120, 30);
        adr.setFont(new Font("", Font.PLAIN, 17));
        add(adr);

        //nhap dia chi
        fadr = new JTextField();
        fadr.setBounds(150, 180, 150, 30);
        add(fadr);

        JLabel gender = new JLabel("GIỚI TÍNH");
        gender.setBounds(30, 230, 120, 30);
        gender.setFont(new Font("", Font.PLAIN, 17));
        add(gender);

        fgt = new JTextField();
        fgt.setBounds(150, 230, 150, 30);
        add(fgt);

        JLabel congviec = new JLabel("VỊ TRÍ");
        congviec.setBounds(30, 280, 120, 30);
        congviec.setFont(new Font("", Font.PLAIN, 17));
        add(congviec);
        
        fvt = new JTextField();
        fvt .setBounds(150, 280, 150, 30);
        add(fvt);


        JLabel luong = new JLabel("LƯƠNG LẬU");
        luong.setBounds(30, 330, 120, 30);
        luong.setFont(new Font("", Font.PLAIN, 17));
        add(luong);

        //nhap luong
        fluong = new JTextField();
        fluong.setBounds(150, 330, 150, 30);
        add(fluong);

        JLabel sdt = new JLabel("SỐ PHONE");
        sdt.setBounds(30, 380, 120, 30);
        sdt.setFont(new Font("", Font.PLAIN, 17));
        add(sdt);

        //nhap sdt
        fsdt = new JTextField();
        fsdt.setBounds(150, 380, 150, 30);
        add(fsdt);
        
        check = new JButton("KIỂM TRA");
        check.setBounds(30, 450, 120, 30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.white);
        check.addActionListener(this);
        add(check);
        
        capnhat = new JButton("CẬP NHẬT");
        capnhat.setBounds(180, 450, 120, 30);
        capnhat.setBackground(Color.BLACK);
        capnhat.setForeground(Color.white);
        capnhat.addActionListener(this);
        add(capnhat);
        
        sathai = new JButton("SA THẢI");
        sathai.setBounds(30, 500, 120, 30);
        sathai.setBackground(Color.BLACK);
        sathai.setForeground(Color.white);
        sathai.addActionListener(this);
        add(sathai);
        
        thoat = new JButton("THOÁT");
        thoat.setBounds(180, 500, 120, 30);
        thoat.setBackground(Color.BLACK);
        thoat.setForeground(Color.white);
        thoat.addActionListener(this);
        add(thoat);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ace) {
        Ketnoi kn = new Ketnoi();
        
        String socccd = (String) scccd.getSelectedItem();
        
        
        if(ace.getSource() == check)
        {
            try {
                String sql1 = "select * from employee where socccd = " + socccd;
                ResultSet rs1 = kn.s.executeQuery(sql1);
                while(rs1.next())
                {
                    fname.setText(rs1.getString("ten"));
                    fage.setText(rs1.getString("tuoi"));
                    fadr.setText(rs1.getString("dchi"));
                    fgt.setText(rs1.getString("gtinh"));
                    fvt.setText(rs1.getString("vitri"));
                    fluong.setText(rs1.getString("luong"));
                    fsdt.setText(rs1.getString("phone"));
                }
            }  catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if(ace.getSource() == capnhat)
        {
            String ten = fname.getText();
            String tuoi = fage.getText();
            String diachi = fadr.getText();
            String gioitinh = fgt.getText();
            String vitri = fvt.getText();
            String luong = fluong.getText();
            String sdt = fsdt.getText();
            try {               
                String sql2 = "update employee set ten = '" + ten + "', tuoi = '" + tuoi + "', dchi = '" + diachi + "', gtinh = '" + gioitinh + "', vitri = '" + vitri + "', luong = '" + luong + "', phone = '" + sdt + "' where socccd = " + socccd;
                kn.s.executeUpdate(sql2);
                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                setVisible(false);
                new Dsnhanvien();
            }  catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(ace.getSource() == sathai)
        {
            String sathai = "delete from employee where socccd = " + socccd;
            try {
                kn.s.executeUpdate(sathai);
                JOptionPane.showMessageDialog(null, "Đã sa thải nhân viên");
                setVisible(false);
                new Dsnhanvien();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if (ace.getSource() == thoat) {
            setVisible(false);
            new Dsnhanvien();
        }
    }
    
    
    
    public static void main(String[] args) {
        new Capnhatnv();
    }
}
