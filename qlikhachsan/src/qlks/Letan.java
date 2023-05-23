
package qlks;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Letan extends JFrame implements ActionListener{

    JButton dskh, dsp, tk, ql;
    
    Letan() {
        setLayout(null);
        setBounds(400, 180, 700, 350);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Lễ Tân");
        
        dskh = new JButton("DANH SÁCH KHÁCH HÀNG");
        dskh.setBounds(30, 80, 200, 30);
        dskh.setBackground(Color.blue);
        dskh.setForeground(Color.WHITE);
        dskh.addActionListener(this);
        add(dskh);
        
        dsp = new JButton("DANH SÁCH PHÒNG");
        dsp.setBounds(30, 130, 200, 30);
        dsp.setBackground(Color.blue);
        dsp.setForeground(Color.WHITE);
        dsp.addActionListener(this);
        add(dsp);
        
        tk = new JButton("TÌM KIẾM PHÒNG");
        tk.setBounds(30, 180, 200, 30);
        tk.setBackground(Color.blue);
        tk.setForeground(Color.WHITE);
        tk.addActionListener(this);
        add(tk);
        
        ql = new JButton("QUAY LẠI");
        ql.setBounds(30, 230, 200, 30);
        ql.setBackground(Color.blue);
        ql.setForeground(Color.WHITE);
        ql.addActionListener(this);
        add(ql);
        
        ImageIcon anh4 = new ImageIcon(ClassLoader.getSystemResource("icons/pic4.jpg"));
        Image anh4_1 = anh4.getImage().getScaledInstance(400, 230, Image.SCALE_DEFAULT);
        ImageIcon anh4_2 = new ImageIcon(anh4_1);
        JLabel anh4_3 = new JLabel(anh4_2);
        anh4_3.setBounds(250, 30, 400, 230);
        add(anh4_3);
        
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ace) {
        if(ace.getSource() == dsp)
        {
            setVisible(false);
            new Dsphong();
        }else if(ace.getSource() == ql)
        {
            setVisible(false);
        }else if(ace.getSource() == dskh)
        {
            setVisible(false);
            new Dskhachhang();
        }else if(ace.getSource() == tk)
        {
            new search();
        }
    }
    
    
    
    public static void main(String[] args) {
        new Letan();
    }
}
