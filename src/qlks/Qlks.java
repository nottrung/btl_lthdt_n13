
package qlks;

import javax.swing.*;

public class Qlks extends JFrame{

    Qlks(){
        setSize(2500, 1668);
        setLocation(200, 200);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ks3.jpg"));
        JLabel image = new JLabel(i1);
        add(image);
        
        setVisible(true);
        
    }
    public static void main(String[] args) {
        new Qlks();
    }
    
}
