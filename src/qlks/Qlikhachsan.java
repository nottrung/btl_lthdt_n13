package qlks;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Qlikhachsan extends JFrame implements ActionListener {

    Qlikhachsan() {
//        setSize(500, 500);//kich co
//        setLocation(100,100);
        setBounds(100, 100, 500, 500);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/pic1.jpg"));
        JLabel anh1 = new JLabel(i1);
        anh1.setBounds(0, 0, 500, 500); //toa do, chieu dài, rong
        add(anh1);

        JLabel nd1 = new JLabel("PHAN MEM QUAN LY KHACH SAN");
        nd1.setBounds(0, 0, 1000, 60);
        nd1.setForeground(Color.BLACK);
        nd1.setFont(new Font("serif", Font.PLAIN, 22));
        anh1.add(nd1);

        JButton next = new JButton("Next");
        next.setBounds(300, 400, 150, 50);
        next.setBackground(Color.white);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        next.setFont(new Font("Time New Roman", Font.ROMAN_BASELINE, 24));
        anh1.add(next);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new login();
    }

    public static void main(String[] args) {
        new Qlikhachsan();
    }

}
