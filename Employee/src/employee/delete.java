
package employee;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class delete extends JFrame implements ActionListener{
    
    Choice cEmpId;
    JButton delete, back;
    Font f;
    
    delete() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        //setSize(1000, 400);
        //setLocation(300, 150);
        //setVisible(false);
        //getContentPane().setBackground(Color.white);
        //setLayout(null);
        
        JLabel l5 = new JLabel("Delete Employee");
        l5.setBounds(50, 10, 350, 50);
        l5.setFont(new Font("SAN SERIF", Font.BOLD, 35));
        l5.setForeground(Color.blue);
        add(l5);
        
        JLabel labelempId = new JLabel("Employee Id ");
        labelempId.setBounds(50, 100, 130, 30);
        labelempId.setFont(new Font("SAN SERIF", Font.PLAIN, 18));
        add(labelempId);
        
        f = new Font("senserif", Font.BOLD,15);
        
        cEmpId = new Choice();
        cEmpId.setBounds(190, 100, 150, 30);
        cEmpId.setFont(f);
        add(cEmpId);
        
        try {
            Connect cc = new Connect();
            String query = "select * from addem";
            ResultSet rs = cc.stm.executeQuery(query);
            
            while (rs.next()) {
                cEmpId.add(rs.getString("empId"));
                
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Name :");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(f);
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30 );
        lblname.setFont(f);
        add(lblname);
        
        JLabel labelphone = new JLabel("Phone :");
        labelphone.setBounds(50, 200, 150, 30);
        labelphone.setFont(f);
        add(labelphone);
        
        JLabel lblphone = new JLabel();
        lblphone.setBounds(200, 200, 150, 30 );
        lblphone.setFont(f);
        add(lblphone);
        
        JLabel labelemail = new JLabel("Email :");
        labelemail.setBounds(50, 250, 150, 30);
        labelemail.setFont(f);
        add(labelemail);
        
        JLabel lblemail = new JLabel();
        lblemail.setBounds(200, 250, 150, 30 );
        lblemail.setFont(f);
        add(lblemail);
        
        try {
            Connect cc = new Connect();
            String query = "select * from addem where empId = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = cc.stm.executeQuery(query);
            
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        cEmpId.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Connect cc = new Connect();
                    String q = "select * from addem where empId = '"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs = cc.stm.executeQuery(q);
            
                    while (rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                    }
            
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(70, 300, 100, 30);
        delete.addActionListener(this);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220, 300, 100, 30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);
        
        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== delete) {
            try {
                Connect cc = new Connect();
                String q = "delete from addem where empId = '"+cEmpId.getSelectedItem()+"'";
                String q1 = "delete from attendance2 where empId = '"+cEmpId.getSelectedItem()+"'";
                String q2 = "delete from apply_leaves where empId = '"+cEmpId.getSelectedItem()+"'";
                String q3 = "delete from salary where empId = '"+cEmpId.getSelectedItem()+"'";
                cc.stm.executeUpdate(q);
                cc.stm.executeUpdate(q1);
                cc.stm.executeUpdate(q2);
                cc.stm.executeUpdate(q3);
                JOptionPane.showMessageDialog(null, "Employee Details deleted successfully");
                setVisible(false);
                new Home();
                
              }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args) {
        new delete().setVisible(true);
        //System.out.println("Success");
    }
    
}

