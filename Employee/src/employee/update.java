
package employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class update extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l0,l11;
    JButton b1,b2;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
    
    Font f1,f2;
    Choice ch;
    
    update(){
        getContentPane().setBackground(Color.yellow);
        setLayout(null);
        setSize(850,750);
        setLocation(350,0);
        setVisible(false);
        
        f1 = new Font("Arial", Font.BOLD,22);
        f2 = new Font("Arial", Font.BOLD,16);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 280, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 240, 500, 280);
        add(image);
        
        l1 = new JLabel("Update Employee Details");
        l1.setBounds(320, 50, 350, 50);
        l1.setFont(new Font("SAN SERIF", Font.BOLD, 45));
        l1.setForeground(Color.DARK_GRAY);
        add(l1);
        
        ch = new Choice();
        ch.setBounds(230, 120, 150, 30);
        
        try {
           Connect cc = new Connect();
           String query = "select empId from addem";
           ResultSet rs = cc.stm.executeQuery(query);
           
           while(rs.next()) {
               ch.add(rs.getString("empId"));
           }
           
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
        
        l11 = new JLabel("Employee ID");
        l11.setBounds(80, 120, 150, 30);
        l2 = new JLabel("Name");
        l2.setBounds(80, 170, 150, 30);
        l3 = new JLabel("Father's Name");
        l3.setBounds(80, 220, 150, 30);
        l4 = new JLabel("Date of Birth");
        l4.setBounds(80, 270, 150, 30);
        l5 = new JLabel("Address");
        l5.setBounds(80, 320, 150, 30);
        l6 = new JLabel("Phone");
        l6.setBounds(80, 370, 150, 30);
        l7 = new JLabel("Email");
        l7.setBounds(80, 420, 150, 30);
        l8 = new JLabel("Education");
        l8.setBounds(80, 470, 150, 30);
        l9 = new JLabel("Designation");
        l9.setBounds(80, 520, 150, 30);
        l0 = new JLabel("NIC");
        l0.setBounds(80, 570, 150, 30);
        
        
        tf1 = new JTextField();
        tf1.setBounds(230, 170, 150, 30);
        tf2 = new JTextField();
        tf2.setBounds(230, 220, 150, 30);
        tf3 = new JTextField();
        tf3.setBounds(230, 270, 150, 30);
        tf4 = new JTextField();
        tf4.setBounds(230, 320, 150, 30);
        tf5 = new JTextField();
        tf5.setBounds(230, 370, 150, 30);
        tf6 = new JTextField();
        tf6.setBounds(230, 420, 150, 30);
        tf7 = new JTextField();
        tf7.setBounds(230, 470, 150, 30);
        tf8 = new JTextField();
        tf8.setBounds(230, 520, 150, 30);
        tf9 = new JTextField();
        tf9.setBounds(230, 570, 150, 30);
        
        
        b1 = new JButton("Update Details");
        b1.setBounds(250, 650, 150, 40);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        
        b2 = new JButton("Close");
        b2.setBounds(450, 650, 150, 40);
        b2.addActionListener(this);
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
        add(b2);
        
        l1.setFont(f1);
        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        l6.setFont(f2);
        l7.setFont(f2);
        l8.setFont(f2);
        l9.setFont(f2);
        l0.setFont(f2);
        l11.setFont(f2);
        ch.setFont(f2);
        
        tf1.setFont(f2);
        tf2.setFont(f2);
        tf3.setFont(f2);
        tf4.setFont(f2);
        tf5.setFont(f2);
        tf6.setFont(f2);
        tf7.setFont(f2);
        tf8.setFont(f2);
        tf9.setFont(f2);
        
        add(l11);
        add(ch);
        add(l2);
        add(tf1);
        add(l3);
        add(tf2);
        add(l4);
        add(tf3);
        add(l5);
        add(tf4);
        add(l6);
        add(tf5);
        add(l7);
        add(tf6);
        add(l8);
        add(tf7);
        add(l9);
        add(tf8);
        add(l0);
        add(tf9);
        add(l11);
        
        ch.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent arg0){
                try {
                    Connect cc =new Connect();
                    String eid = ch.getSelectedItem(); 
                    String s = "Select * from addem where empId='"+eid+"'";
                    ResultSet rs  =cc.stm.executeQuery(s);
                    
                    while(rs.next()){
                        tf1.setText(rs.getString("name"));
                        tf2.setText(rs.getString("fname"));
                        tf3.setText(rs.getString("dob"));
                        tf4.setText(rs.getString("address"));
                        tf5.setText(rs.getString("phone"));
                        tf6.setText(rs.getString("email"));
                        tf7.setText(rs.getString("highest_education"));
                        tf8.setText(rs.getString("designation"));
                        tf9.setText(rs.getString("nic"));
                        
                    }
                }
                catch (Exception exx){
                    exx.printStackTrace();
                }
            }
            
            
        });
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
            String empId = ch.getSelectedItem();
            String name = tf1.getText();
            String fname = tf2.getText();
            String dob = tf3.getText();
            String address = tf4.getText();
            String phone = tf5.getText();
            String email = tf6.getText();
            String highest_education = tf7.getText();
            String designation = tf8.getText();
            String nic = tf9.getText();
            
            if(ae.getSource() == b1){
                try {
                    Connect cc = new Connect();
                    String query = "update addem set name = '"+name+"', fname = '"+fname+"', dob = '"+dob+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', highest_education = '"+highest_education+"', designation = '"+designation+"', nic = '"+nic+"' where empId = '"+empId+"'";
                    int aa = cc.stm.executeUpdate(query);
                    
                    if(aa == 1){
                        JOptionPane.showMessageDialog(null, "Details updated successfully");
                        this.setVisible(false);
                        new update();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Please! Fill the details carefully");
                    }
                
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
            }
    }
    
    public static void main (String[] args) {
        new update().setVisible(true);
    }
             
   
        
        
}
            
        


