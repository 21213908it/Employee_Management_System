
package employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class salary extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l0;
    Choice c1,c2,c3;
    JButton b1,b2;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
    Font f;
   
    
    salary() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        setSize(800,900);
        setLocation(300,0);
        setVisible(false);
        
        f = new Font("senserif", Font.BOLD,15);
        
        JLabel lbl = new JLabel("Add salary");
        lbl.setBounds(300, 40, 350, 50);
        lbl.setFont(new Font("SAN SERIF", Font.BOLD, 40));
        lbl.setForeground(Color.MAGENTA);
        add(lbl);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/salary.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(430, 230, 300, 300);
        add(image);
        
        l1 = new JLabel("Select Employee ID");
        l1.setBounds(80, 150, 150, 30);
        l2 = new JLabel("Name");
        l2.setBounds(80, 200, 150, 30);
        l3 = new JLabel("Email");
        l3.setBounds(80, 250, 150, 30);
        l4 = new JLabel("HRA");
        l4.setBounds(80, 300, 150, 30);
        l5 = new JLabel("DA");
        l5.setBounds(80, 350, 150, 30);
        l6 = new JLabel("MID");
        l6.setBounds(80, 400, 150, 30);
        l7 = new JLabel("PF");
        l7.setBounds(80, 450, 150, 30);
        l8 = new JLabel("Basic Salary");
        l8.setBounds(80, 500, 150, 30);
        l9 = new JLabel("Select Month");
        l9.setBounds(80, 550, 150, 30);
        l0 = new JLabel("Select Year");
        l0.setBounds(80, 600, 150, 30);
        
        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        l5.setFont(f);
        l6.setFont(f);
        l7.setFont(f);
        l8.setFont(f);
        l9.setFont(f);
        l0.setFont(f);
        
        tf1 = new JTextField();
        tf1.setBounds(230, 200, 150, 30);
        tf2 = new JTextField();
        tf2.setBounds(230, 250, 150, 30);
        tf3 = new JTextField();
        tf3.setBounds(230, 300, 150, 30);
        tf4 = new JTextField();
        tf4.setBounds(230, 350, 150, 30);
        tf5 = new JTextField();
        tf5.setBounds(230, 400, 150, 30);
        tf6 = new JTextField();
        tf6.setBounds(230, 450, 150, 30);
        tf7 = new JTextField();
        tf7.setBounds(230, 500, 150, 30);
        
        
        tf1.setFont(f);
        tf2.setFont(f);
        
        tf1.setEditable(false);
        tf2.setEditable(false);
        
        c2 = new Choice();
        c2.setBounds(230, 550, 150, 30);
        c2.add("January");
        c2.add("February");
        c2.add("March");
        c2.add("April");
        c2.add("May");
        c2.add("June");
        c2.add("July");
        c2.add("Auguest");
        c2.add("September");
        c2.add("October");
        c2.add("November");
        c2.add("December");
        
        c3 = new Choice();
        c3.setBounds(230, 600, 150, 30);
        c3.add("2021");
        c3.add("2022");
        
        b1 = new JButton("Add Salary");
        b1.setBounds(200, 650, 150, 40);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        
        b2 = new JButton("Close");
        b2.setBounds(480, 650, 150, 40);
        b2.addActionListener(this);
        b2.setBackground(Color.RED);
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
        add(c2);
        add(l0);
        add(c3);
        
        
        
        c1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent arg0){
                
                try {
                    Connect cc =new Connect();
                    String eid = c1.getSelectedItem(); 
                    String q2 = "Select * from addem where empId='"+eid+"'";
                    ResultSet rs  =cc.stm.executeQuery(q2);
                    
                    while(rs.next()){
                        tf1.setText(rs.getString("name"));
                        tf2.setText(rs.getString("email"));
                    }
                }
                catch (Exception exx) {
                    exx.printStackTrace();
                }
                
            }
        });
        
    }
    
     public void actionPerformed(ActionEvent ae) {
         if(ae.getSource() == b1){
             String empId = c1.getSelectedItem();
             String name = tf1.getText();
             String email = tf2.getText();
             float hra = Float.parseFloat(tf3.getText());
             float da = Float.parseFloat(tf4.getText());
             float mid = Float.parseFloat(tf5.getText());
             float pf = Float.parseFloat(tf6.getText());
             float basicsalary = Float.parseFloat(tf7.getText());
             String month = c2.getSelectedItem();
             String year = c3.getSelectedItem();
             
             try {
                 Connect cc =new Connect();
                 String q1 = "insert into salary values('"+empId+"', '"+name+"', '"+email+"' , '"+hra+"','"+da+"', '"+mid+"' , '"+pf+"','"+basicsalary+"', '"+month+"' , '"+year+"')"; 
                 cc.stm.execute(q1);
                 JOptionPane.showMessageDialog(null,"Salary inserted");
                 setVisible(false);
             
             }
             catch (Exception ex1) {
                 ex1.printStackTrace();
             }
         }
         if(ae.getSource() == b2){
             JOptionPane.showMessageDialog(null,"Are you sure to Close?");
             setVisible(false);
         }
     }
     
     public static void main (String[] args) {
        new salary().setVisible(true);
    }
}

