
package employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class leave extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    Choice c1,c2;
    JButton b1,b2;
    JTextField tf1,tf2,tf3,tf4;
    Font f;
    
    
    leave() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        setSize(1050,750);
        setLocation(300,50);
        setVisible(false);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/leave.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(530, 280, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 150, 530, 280);
        add(image);
        
        f = new Font("senserif", Font.BOLD,15);
        
        l7 = new JLabel("Apply Leave");
        l7.setBounds(400, 50, 350, 50);
        l7.setFont(new Font("SAN SERIF", Font.BOLD, 40));
        l7.setForeground(Color.red);
        add(l7);
        
        l1 = new JLabel("Select Employee ID");
        l1.setBounds(80, 150, 150, 30);
        l2 = new JLabel("Start Date");
        l2.setBounds(80, 300, 150, 30);
        l3 = new JLabel("End Date");
        l3.setBounds(80, 350, 150, 30);
        l4 = new JLabel("Name");
        l4.setBounds(80, 200, 150, 30);
        l5 = new JLabel("Email");
        l5.setBounds(80, 250, 150, 30);
        l6 = new JLabel("Leave Reason");
        l6.setBounds(80, 400, 150, 30);
        
        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        l5.setFont(f);
        l6.setFont(f);
        
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        
        tf1.setFont(f);
        tf1.setBounds(230, 200, 150, 30);
        tf2.setFont(f);
        tf2.setBounds(230, 250, 150, 30);
        tf3.setFont(f);
        tf3.setBounds(230, 300, 150, 30);
        tf4.setFont(f);
        tf4.setBounds(230, 350, 150, 30);
        
        tf1.setEditable(false);
        tf2.setEditable(false);
        
        c2 = new Choice();
        c2.setBounds(230, 400, 150, 30);
        c2.add("Employee Health Issue");
        c2.add("Family Member Health Issue");
        c2.add("Function / Celebration");
        c2.add("Party");
        c2.add("Personal Things");
        c2.add("Others");
        
        b1 = new JButton("Submit");
        b1.setBounds(250, 550, 150, 40);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        
        b2 = new JButton("Close");
        b2.setBounds(450, 550, 150, 40);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        
        c1 = new Choice();
        c1.setBounds(230, 150, 150, 30);
        
        try {
           Connect cc = new Connect();
           String query = "select empId from addem";
           ResultSet rs = cc.stm.executeQuery(query);
           
           while(rs.next()) {
               c1.add(rs.getString("empId"));
           }
           
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        
       
        
        add(l1);
        add(c1);
        add(l4);
        add(tf1);
        add(l5);
        add(tf2);
        add(l2);
        add(tf3);
        add(l3);
        add(tf4);
        add(l6);
        add(c2);
        add(b1);
        add(b2);
        
        
        
        c1.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent arg0){
                try {
                    Connect cc =new Connect();
                    String eid = c1.getSelectedItem(); 
                    String s = "Select * from addem where empId='"+eid+"'";
                    ResultSet rs  =cc.stm.executeQuery(s);
                    
                    while(rs.next()){
                        tf1.setText(rs.getString("name"));
                        tf2.setText(rs.getString("email"));
                    }
                }
                catch (Exception exx){
                    exx.printStackTrace();
                }
            }
            
            
        });
        
    }
    
    public void actionPerformed(ActionEvent ae){
            
            if(ae.getSource() == b1){
                
                String empId = c1.getSelectedItem();
                String name = tf1.getText();
                String email = tf2.getText();
                String startdt = tf3.getText();
                String enddt = tf4.getText();
                String reason = c2.getSelectedItem();
                String apply_dt = new java.util.Date().toString();
             
                try {
                    Connect cc =new Connect();
                    String q1 = "insert into apply_leaves values('"+empId+"', '"+name+"', '"+email+"' , '"+startdt+"','"+enddt+"', '"+reason+"', '"+apply_dt+"')";
                    cc.stm.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null, "your data successfully updated");
                    setVisible(false);
                    new Home();    
                    
                    
                
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            if(ae.getSource() == b2){
                JOptionPane.showMessageDialog(null,"Are you sure to Close?");
                this.setVisible(false);
            }
    
        
    }
    
    public static void main (String[] args) {
        new leave().setVisible(true);
    }
             
   
        
        
}