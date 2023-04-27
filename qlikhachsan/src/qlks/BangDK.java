
package qlks;

import javax.swing.*;
import java.awt.*;

public class BangDK extends JFrame{
    
    BangDK() 
    {
        setBounds(0, 0, 1550, 1000);
        setLayout(null);
        
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
        JMenu qlks = new JMenu("Quan ly khach san");
        qlks.setForeground(Color.blue);
        tccu.add(qlks);
        
        //them phan le tan vao phan qlks 
        JMenuItem letan =new JMenuItem("Le Tan");
        qlks.add(letan);
        
        //them phan admin vao tccu
        JMenu admin = new JMenu("admin");
        admin.setForeground(Color.red);
        tccu.add(admin);
        
        //them phan them nhan vien vao phan admin
        JMenuItem themnhanvien = new JMenuItem("Them nhan vien");
        admin.add(themnhanvien);
        
        //them phan them phong vao phan admin
        JMenuItem themphong = new JMenuItem("Them phong");
        admin.add(themphong);
        
        //them phan them dk vao phan admin
        JMenuItem themdieukhien = new JMenuItem("Them tai xe");
        admin.add(themdieukhien);
        
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new BangDK();
    }
}
