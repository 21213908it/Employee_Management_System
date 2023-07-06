
package employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class view implements ActionListener{
    JFrame f;
    JTextField t;
    JLabel l1,l2;
    JButton b,b2;
     
     
    view(){
        f = new JFrame("View Employee");
        f.setBackground(Color.white);
        f.setLayout(null);
        
        l1 = new JLabel();
        l1.setBounds(0,0,650,370);
        l1.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/view.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 370, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1.setIcon(i3);
        f.add(l1);
        
        l2=new JLabel("Employee Id");
        l2.setVisible(true);
        l2.setBounds(95, 95, 250, 35);
        l2.setForeground(Color.white);
        Font F1 = new Font("Airal",Font.BOLD,32);
        l2.setFont(F1);
        l1.add(l2);
        f.add(l1);
        
        t=new JTextField();
        t.setBounds(300, 95, 220, 35);
        l1.add(t);
        
        b2=new JButton("Search");
        b2.setBackground(Color.red);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(150, 230, 150, 40);
        b2.setFont(new Font("serif", Font.BOLD, 20));
        l1.add(b2);
        
        b=new JButton("Cancel");
        b.setBackground(Color.black);
        b.setForeground(Color.WHITE);
        b.addActionListener(this);
        b.setBounds(340, 230, 150, 40);
        b.setFont(new Font("serif", Font.BOLD, 20));
        l1.add(b);
        
        f.setSize(650, 370);
        f.setLocation(550, 250);
        f.setVisible(true);
        
        
        
    }

    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b2){
            f.setVisible(false);
            new viewdata(t.getText());
        }
        if(e.getSource()==b){
            f.setVisible(false);
            new Home();
        }
    }
    
    public static void main (String[] args) {
        new view();
    }

}
