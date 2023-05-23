
package qlks;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Dskhachhang extends JFrame implements ActionListener{

    JButton thoat, capnhat;
    
    Dskhachhang() {
        setLayout(null);
        setBounds(300, 150, 900, 500);
        getContentPane().setBackground(Color.WHITE);
        setTitle("DANH SÁCH KHÁCH HÀNG");
        
        ImageIcon anh5 = new ImageIcon(ClassLoader.getSystemResource("icons/pic5.png"));
        Image anh5_1 = anh5.getImage().getScaledInstance(400, 230, Image.SCALE_DEFAULT);
        ImageIcon anh5_2 = new ImageIcon(anh5_1);
        JLabel anh5_3 = new JLabel(anh5_2);
        anh5_3.setBounds(450, 100, 500, 230);
        add(anh5_3);
        
        
        JTable danhsach = new JTable();
        danhsach.setBounds(0, 30, 480, 350);
        add(danhsach);
        
        try {
            Ketnoi kn = new Ketnoi();
            ResultSet rs = kn.s.executeQuery("select * from booking");
            danhsach.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        JLabel l1 = new JLabel("Họ tên khách hàng");
        l1.setBounds(0, 0, 120, 30);
        add(l1);
        
        JLabel l2 = new JLabel("Số CCCD");
        l2.setBounds(120, 0, 120, 30);
        add(l2);
        
        JLabel l3 = new JLabel("Số phòng");
        l3.setBounds(240, 0, 120, 30);
        add(l3);
        
        JLabel l4 = new JLabel("Số đêm thuê");
        l4.setBounds(360, 0, 120, 30);
        add(l4);
        
        thoat = new JButton("QUAY LẠI");
        thoat.setBounds(300, 400, 120, 30);
        thoat.setBackground(Color.CYAN);
        thoat.setForeground(Color.WHITE);
        thoat.addActionListener(this);
        add(thoat);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ace) {
        if(ace.getSource() == thoat)
        {
            setVisible(false);
            new Letan();
        }
    }
    
    public static void main(String[] args) {
        new Dskhachhang();
    }
}
