
package qlks;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class search extends JFrame implements ActionListener{
    
    JTable ds;
    JComboBox trangthai;
    JButton timkiem, ql;

    search() {
        setLayout(null);
        setBounds(300, 150, 700, 600);
        getContentPane().setBackground(Color.WHITE);
        setTitle("TÌM KIẾM");
        
        String tt[] = {"trống", "đã thuê"};
        trangthai = new JComboBox(tt);
        trangthai.setBounds(80, 20, 120, 30);
        trangthai.setBackground(Color.WHITE);
        add(trangthai);
        
        timkiem = new JButton("SEARCH");
        timkiem.setBounds(230, 20, 120, 30);
        timkiem.setBackground(Color.BLACK);
        timkiem.setForeground(Color.WHITE);
        timkiem.addActionListener(this);
        add(timkiem);
        
        ql = new JButton("RETURN");
        ql.setBounds(380, 20, 120, 30);
        ql.setBackground(Color.BLACK);
        ql.setForeground(Color.WHITE);
        ql.addActionListener(this);
        add(ql);
        
        ds = new JTable();
        ds.setBounds(0, 100, 500, 400);
        add(ds);
        
        try {
            Ketnoi kn = new Ketnoi();
            ResultSet rs = kn.s.executeQuery("select r.sophong, b.tenkh, b.cccd, r.trangthai from rooms as r left join booking as b on r.sophong = b.sophong");
            ds.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        JLabel l1 = new JLabel("SỐ PHÒNG");
        l1.setBounds(0, 60, 100, 30);
        add(l1);
        
        JLabel l2 = new JLabel("TÊN KHÁCH HÀNG");
        l2.setBounds(125, 60, 130, 30);
        add(l2);
        
        JLabel l3 = new JLabel("SỐ CCCD");
        l3.setBounds(250, 60, 100, 30);
        add(l3);
        
        JLabel l4 = new JLabel("TRẠNG THÁI");
        l4.setBounds(375, 60, 100, 30);
        add(l4);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ace) {
        
        Ketnoi kn = new Ketnoi();
        if(ace.getSource() == timkiem)
        {
            try {
                ResultSet rs2 = kn.s.executeQuery("select r.sophong, b.tenkh, b.cccd, r.trangthai from rooms as r left join booking as b on r.sophong = b.sophong where r.trangthai = '" + trangthai.getSelectedItem() + "'");
                ds.setModel(DbUtils.resultSetToTableModel(rs2));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if(ace.getSource() == ql)
        {
            setVisible(false);
        }
    }
    
    
    
    public static void main(String[] args) {
        new search();
    }
}
