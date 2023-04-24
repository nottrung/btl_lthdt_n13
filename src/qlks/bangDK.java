
package qlks;

import javax.swing.*;
import java.awt.*;

public class bangDK extends JFrame{
    
    bangDK() 
    {
        setBounds(0, 0, 1550, 1000);
        setLayout(null);
        
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/pic3.jpg"));
        Image i3_1 = i3.getImage().getScaledInstance(1550, 1000, Image. SCALE_DEFAULT);
        ImageIcon i3_2 = new ImageIcon(i3_1);
        JLabel anh3 = new JLabel(i3_2);
        anh3.setBounds(0, 0 , 1550, 1000);
        add(anh3);
        
        JMenuBar tccu = new JMenuBar();
        tccu.setBounds(0, 0, 1550, 35);
        anh3.add(tccu);
        
        JMenu menu = new JMenu("Quan ly khach san");
        menu.setForeground(Color.blue);
        tccu.add(menu);
        
        JMenuItem letan =new JMenuItem("Le Tan");
        menu.add(letan);
        
        JMenu admin = new JMenu("admin");
        admin.setForeground(Color.red);
        tccu.add(admin);
        
        JMenuItem themnhanvien = new JMenuItem("Them nhan vien");
        admin.add(themnhanvien);
        
        JMenuItem themphong = new JMenuItem("Them phong");
        admin.add(themphong);
        
        JMenuItem themdieukhien = new JMenuItem("Them dieu khien");
        admin.add(themdieukhien);
        
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new bangDK();
    }
}
