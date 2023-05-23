
package qlks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BangDK extends JFrame implements ActionListener {
    
    BangDK() 
    {
        setBounds(300, 100, 900, 600);
        setLayout(null);
        setTitle("Trang Chủ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/pic2.jpg"));
        Image i3_1 = i3.getImage().getScaledInstance(1550, 1000, Image. SCALE_DEFAULT);
        ImageIcon i3_2 = new ImageIcon(i3_1);
        JLabel anh3 = new JLabel(i3_2);
        anh3.setBounds(0, 0 , 900, 600);
        add(anh3);
        
        //tao thanh ccu
        JMenuBar tccu = new JMenuBar();
        tccu.setBounds(0, 0, 900, 35);
        anh3.add(tccu);
        
        //them qlks vaof tccu
        JMenu qlks = new JMenu("Quản Lý Khách Sạn");
        qlks.setForeground(Color.blue);
        tccu.add(qlks);        
        
        //them phan le tan vao phan qlks 
        JMenuItem letan =new JMenuItem("Lễ Tân");
        letan.addActionListener(this);
        qlks.add(letan);
        
        JMenu dx = new JMenu("Đăng Xuất");
        dx.setForeground(Color.blue);
        tccu.add(dx);
        
        JMenuItem doitk = new JMenuItem("ĐỔI TÀI KHOẢN");
        doitk.addActionListener(this);
        dx.add(doitk);
        
        JMenuItem dgxt = new JMenuItem("ĐĂNG XUẤT");
        dgxt.addActionListener(this);
        dx.add(dgxt);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ace) {
        if(ace.getActionCommand().equals("Lễ Tân"))
        {
            new Letan();
        }else if(ace.getActionCommand().equals("ĐĂNG XUẤT"))
        {
            setVisible(false);
        }else if(ace.getActionCommand().equals("ĐỔI TÀI KHOẢN"))
        {
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args)
    {
        new BangDK();
    }
}
