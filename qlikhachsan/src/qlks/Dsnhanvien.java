package qlks;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Dsnhanvien extends JFrame implements ActionListener{

    JTable danhsach;
    JTextField fname, fage, fadr, fluong, fsdt, fcccd;
    JRadioButton nam, nu;
    JComboBox vitri;
    JButton xacnhan, thoat, capnhat;
    
    Dsnhanvien() {
        setLayout(null);
        setBounds(100, 150, 1100, 600);
        getContentPane().setBackground(Color.WHITE);
        setTitle("DANH SÁCH NHÂN VIÊN");

        danhsach = new JTable();
        danhsach.setBounds(0, 40, 720, 350);
        add(danhsach);
        
        try {
            Ketnoi kn = new Ketnoi();
            ResultSet rs = kn.s.executeQuery("select * from employee");
            danhsach.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        JLabel l1 = new JLabel("Tên nhân viên");
        l1.setBounds(0, 10, 90, 40);
        add(l1);
        
        JLabel l2 = new JLabel("Tuổi");
        l2.setBounds(90, 10, 90, 40);
        add(l2);
        
        JLabel l3 = new JLabel("Quê quán");
        l3.setBounds(180, 10, 90, 40);
        add(l3);
        
        JLabel l4 = new JLabel("Số CCCD");
        l4.setBounds(270, 10, 90, 40);
        add(l4);
        
        JLabel l5 = new JLabel("Giới tính");
        l5.setBounds(360, 10, 90, 40);
        add(l5);
        
        JLabel l6 = new JLabel("Vị trí");
        l6.setBounds(450, 10, 90, 40);
        add(l6);
        
        JLabel l7 = new JLabel("Lương");
        l7.setBounds(540, 10, 90, 40);
        add(l7);
        
        JLabel l8 = new JLabel("Số điện thoại");
        l8.setBounds(630, 10, 90, 40);
        add(l8);
        
        JLabel name = new JLabel("HỌ TÊN");
        name.setBounds(780, 30, 120, 30);
        name.setFont(new Font("", Font.PLAIN, 17));
        add(name);

        //nhap ten
        fname = new JTextField();
        fname.setBounds(890, 30, 150, 30);
        add(fname);
        
        JLabel age = new JLabel("TUỔI");
        age.setBounds(780, 80, 120, 30);
        age.setFont(new Font("", Font.PLAIN, 17));
        add(age);

        //nhap tuoi
        fage = new JTextField();
        fage.setBounds(890, 80, 150, 30);
        add(fage);
        
        JLabel adr = new JLabel("ĐIA CHỈ");
        adr.setBounds(780, 130, 120, 30);
        adr.setFont(new Font("", Font.PLAIN, 17));
        add(adr);

        //nhap dia chi
        fadr = new JTextField();
        fadr.setBounds(890, 130, 150, 30);
        add(fadr);
        
        JLabel cccd = new JLabel("SỐ CCCD");
        cccd.setBounds(780, 180, 120, 30);
        cccd.setFont(new Font("", Font.PLAIN, 17));
        add(cccd);

        //nhap so cccd
        fcccd = new JTextField();
        fcccd.setBounds(890, 180, 150, 30);
        add(fcccd);

        JLabel gender = new JLabel("GIỚI TÍNH");
        gender.setBounds(780, 230, 120, 30);
        gender.setFont(new Font("", Font.PLAIN, 17));
        add(gender);

        //chon gioi tinh
        nam = new JRadioButton("NAM");
        nam.setBounds(890, 235, 70, 20);
        nam.setBackground(Color.WHITE);
        add(nam);

        nu = new JRadioButton("NỮ");
        nu.setBounds(960, 235, 70, 20);
        nu.setBackground(Color.WHITE);
        add(nu);

        ButtonGroup bg = new ButtonGroup();
        bg.add(nam);
        bg.add(nu);

        JLabel congviec = new JLabel("VỊ TRÍ");
        congviec.setBounds(780, 280, 120, 30);
        congviec.setFont(new Font("", Font.PLAIN, 17));
        add(congviec);

        //tao list danh sach vi tri lam viec
        String vt[] = {"quản lý", "bảo vệ", "nhân viên lễ tân", "nhân viên bê đồ", "nhân viên giặt là", "nhân viên kê toán", "nhân viên vệ sinh"};
        vitri = new JComboBox(vt);
        vitri.setBounds(890, 280, 150, 30);
        vitri.setBackground(Color.WHITE);
        add(vitri);

        JLabel luong = new JLabel("LƯƠNG");
        luong.setBounds(780, 330, 120, 30);
        luong.setFont(new Font("", Font.PLAIN, 17));
        add(luong);

        //nhap luong
        fluong = new JTextField();
        fluong.setBounds(890, 330, 150, 30);
        add(fluong);

        JLabel sdt = new JLabel("SỐ PHONE");
        sdt.setBounds(780, 380, 120, 30);
        sdt.setFont(new Font("", Font.PLAIN, 17));
        add(sdt);

        //nhap sdt
        fsdt = new JTextField();
        fsdt.setBounds(890, 380, 150, 30);
        add(fsdt);
        
        xacnhan = new JButton("THÊM");
        xacnhan.setBackground(Color.BLACK);
        xacnhan.setForeground(Color.WHITE);
        xacnhan.setFont(new Font("", Font.PLAIN, 17));
        xacnhan.setBounds(780, 450, 120, 30);
        xacnhan.addActionListener(this);
        add(xacnhan);

        capnhat = new JButton("CẬP NHẬT");
        capnhat.setBounds(920, 450, 120, 30);
        capnhat.setBackground(Color.BLACK);
        capnhat.setForeground(Color.white);
        capnhat.setFont(new Font("", Font.PLAIN, 17));
        capnhat.addActionListener(this);
        add(capnhat);
        
        thoat = new JButton("THOÁT");
        thoat.setBounds(850, 500, 120, 30);
        thoat.setBackground(Color.BLACK);
        thoat.setForeground(Color.white);
        thoat.setFont(new Font("", Font.PLAIN, 17));
        thoat.addActionListener(this);
        add(thoat);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ace) {
        String name = fname.getText();
        String age = fage.getText();
        String address = fadr.getText();
        String scccd = fcccd.getText();
        String salary = fluong.getText();
        String phone = fsdt.getText();

        String gender = null;
        if (nam.isSelected()) {
            gender = "nam";
        } else if (nu.isSelected()) {
            gender = "nữ";
        }

        String cviec = (String) vitri.getSelectedItem();

        if (ace.getSource() == xacnhan) {
            try {
                Ketnoi kn = new Ketnoi();
                String truyvan = "insert into employee values('" + name + "', '" + age + "', '" + address + "', '" + scccd + "', '" + gender + "', '" + cviec + "', '" + salary + "', '" + phone + "');";
                kn.s.executeUpdate(truyvan);
                JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công");
                setVisible(false);
                new Dsnhanvien();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (ace.getSource() == thoat) {
            setVisible(false);
        }else if(ace.getSource() == capnhat)
        {
            setVisible(false);
            new Capnhatnv();
        }
    }
       
    public static void main(String[] args) {
        new Dsnhanvien();
    }
}
