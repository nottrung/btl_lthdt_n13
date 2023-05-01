package qlks;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Themnhanvien extends JFrame implements ActionListener{

    JTextField fname, fage, fadr, fluong, fsdt;
    JRadioButton nam, nu;
    JComboBox vitri;
    JButton xacnhan;
    
    Themnhanvien() {
        setLayout(null);
        setBounds(350, 180, 350, 500);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Thêm Nhân Viên");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel name = new JLabel("HỌ TÊN");
        name.setBounds(30, 30, 120, 30);
        name.setFont(new Font("", Font.PLAIN, 17));
        add(name);

        //nhap ten
        fname = new JTextField();
        fname.setBounds(150, 30, 150, 30);
        add(fname);

        JLabel age = new JLabel("TUỔI");
        age.setBounds(30, 80, 120, 30);
        age.setFont(new Font("", Font.PLAIN, 17));
        add(age);

        //nhap tuoi
        fage = new JTextField();
        fage.setBounds(150, 80, 150, 30);
        add(fage);

        JLabel adr = new JLabel("ĐIA CHỈ");
        adr.setBounds(30, 130, 120, 30);
        adr.setFont(new Font("", Font.PLAIN, 17));
        add(adr);

        //nhap dia chi
        fadr = new JTextField();
        fadr.setBounds(150, 130, 150, 30);
        add(fadr);

        JLabel gender = new JLabel("GIỚI TÍNH");
        gender.setBounds(30, 180, 120, 30);
        gender.setFont(new Font("", Font.PLAIN, 17));
        add(gender);

        //chon gioi tinh
        nam = new JRadioButton("NAM");
        nam.setBounds(150, 185, 70, 20);
        nam.setBackground(Color.WHITE);
        add(nam);

        nu = new JRadioButton("NỮ");
        nu.setBounds(230, 185, 70, 20);
        nu.setBackground(Color.WHITE);
        add(nu);

        ButtonGroup bg = new ButtonGroup();
        bg.add(nam);
        bg.add(nu);
        
        JLabel congviec = new JLabel("VỊ TRÍ");
        congviec.setBounds(30, 230, 120, 30);
        congviec.setFont(new Font("", Font.PLAIN, 17));
        add(congviec);

        //tao list danh sach vi tri lam viec
        String vt[] = {"quản lý", "bảo vệ", "nhân viên lễ tân", "nhân viên bê đồ", "nhân viên giặt là", "nhân viên kê toán", "nhân viên vệ sinh"};
        vitri = new JComboBox(vt);
        vitri.setBounds(150, 230, 150, 30);
        vitri.setBackground(Color.WHITE);
        add(vitri);

        JLabel luong = new JLabel("LƯƠNG LẬU");
        luong.setBounds(30, 280, 120, 30);
        luong.setFont(new Font("", Font.PLAIN, 17));
        add(luong);

        //nhap luong
        fluong = new JTextField();
        fluong.setBounds(150, 280, 150, 30);
        add(fluong);

        JLabel sdt = new JLabel("SỐ PHONE");
        sdt.setBounds(30, 330, 120, 30);
        sdt.setFont(new Font("", Font.PLAIN, 17));
        add(sdt);

        //nhap sdt
        fsdt = new JTextField();
        fsdt.setBounds(150, 330, 150, 30);
        add(fsdt);

        xacnhan = new JButton("XÁC NHẬN");
        xacnhan.setBackground(Color.BLACK);
        xacnhan.setForeground(Color.WHITE);
        sdt.setFont(new Font("", Font.PLAIN, 17));
        xacnhan.setBounds(120, 400, 100, 30);
        xacnhan.addActionListener(this);
        add(xacnhan);

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ace) {
        String name = fname.getText();
        String age = fage.getText();
        String address = fadr.getText();
        String salary = fluong.getText();
        String phone = fsdt.getText();
        
        String gender = null;
        if(nam.isSelected())
        {
            gender = "male";
        }else if(nu.isSelected())
        {
            gender = "female";
        }
        
        String cviec = (String) vitri.getSelectedItem();
        
        try
        {
            Ketnoi kn = new Ketnoi();
            String truyvan = "insert into employee values('" + name + "', '" + age +"', '"+ address +"', '" + gender +"', '" + cviec +"', '" + salary +"', '" + phone +"');";
            kn.s.executeUpdate(truyvan);
            JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công");
            setVisible(false);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Themnhanvien();
    }

}
