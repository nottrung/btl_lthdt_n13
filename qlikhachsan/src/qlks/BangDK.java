
package qlks;

import javax.swing.*;
import java.awt.*;

public class BangDK extends JFrame {
    
    BangDK() 
    {
        setBounds(0, 0, 1550, 1000);
        setLayout(null);
        setTitle("Trang Chủ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/pic3.jpg"));
        Image i3_1 = i3.getImage().getScaledInstance(1550, 1000, Image. SCALE_DEFAULT);
        ImageIcon i3_2 = new ImageIcon(i3_1);
        JLabel anh3 = new JLabel(i3_2);
        anh3.setBounds(0, 0 , 1550, 1000);
        add(anh3);
        
        //tao thanh ccu
        JMenuBar tccu = new JMenuBar();
        tccu.setBounds(0, 0, 1550, 35);
        anh3.add(tccu);
        
        //them qlks vaof tccu
        JMenu qlks = new JMenu("Quản Lý Khách Sạn");
        qlks.setForeground(Color.blue);
        tccu.add(qlks);
        
        //them phan le tan vao phan qlks 
        JMenuItem letan =new JMenuItem("Lễ Tân");
        qlks.add(letan);
        
        //them phan admin vao tccu
        JMenu admin = new JMenu("Quản Lý");
        admin.setForeground(Color.red);
        tccu.add(admin);
        
        JMenu dichvu = new JMenu("Dịch Vụ");
        dichvu.setForeground(Color.ORANGE);
        tccu.add(dichvu);
        
        //them phan them nhan vien vao phan admin
        JMenuItem themnhanvien = new JMenuItem("Thêm Nhân Viên");
        admin.add(themnhanvien);
        
        //them phan sua thong tin nhan vien vao phan admin
        JMenuItem suathongtin = new JMenuItem("Sửa Thông Tin Nhân Viên");
        admin.add(suathongtin);
        
        //them phan xoa nhan vien vao phan admin
        JMenuItem sathai = new JMenuItem("Sa Thải Nhân Viên");
        admin.add(sathai);
        
        //them phan them phong vao phan dich vu
        JMenuItem themphong = new JMenuItem("Thêm Phòng");
        dichvu.add(themphong);
        
        //them phan tra phong vao phan dich vu
        JMenuItem traphong = new JMenuItem("Trả Phòng");
        dichvu.add(traphong);
        
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new BangDK();
    }
}
