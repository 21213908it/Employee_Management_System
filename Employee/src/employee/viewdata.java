
package employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class viewdata implements ActionListener{
    
    JFrame f;
    JLabel id,aid,id1,aid1,id2,aid2,id3,idd3,aid3,aidd3,id4,aid4,id5,aid5,id6,aid6,id7,aid7,id8,id9;
    String empid,name,nic,address,phone,email,education,designation,dob;
    JButton b1,b2;
    
    viewdata(String empId){
        
        try{
            
            Connect cc =new Connect();
            String s = "Select * from addem where empId='"+empId+"'";
            ResultSet rs=cc.stm.executeQuery(s);
            
            while(rs.next())
            {
                name=rs.getString("name");
                nic=rs.getString("nic");
                dob=rs.getString("dob");
                address=rs.getString("address");
                phone=rs.getString("phone");
                email=rs.getString("email");
                education=rs.getString("highest_education");
                designation=rs.getString("designation");
                empid=rs.getString("empId");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        f = new JFrame("Display Employee Details");
        f.setVisible(true);
        f.setBackground(Color.WHITE);
        f.setSize(595, 642);
        f.setLocation(450, 200);
        f.setLayout(null);
        
        id9 = new JLabel();
        id9.setBounds(0,0,595,642);
        id9.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/gray.png"));
        id9.setIcon(img);
        
        id8=new JLabel("Employee Details");
        id8.setBounds(170, 20, 250, 40);
        id8.setForeground(Color.white);
        f.add(id8);
        id8.setFont(new Font("Arial", Font.BOLD, 30));
        id9.add(id8);
        f.add(id9);
        
        id=new JLabel("Employee Id");
        id.setBounds(150, 80, 120, 30);
        id.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id);
        
        aid=new JLabel(empid);
        aid.setBounds(330, 80, 200, 30);
        aid.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid);
        
        id1=new JLabel("Name:");
        id1.setBounds(150, 130, 100, 30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id1);
        
        aid1=new JLabel(name);
        aid1.setBounds(330, 130, 300, 30);
        aid1.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid1);
        
        id2=new JLabel("NIC:");
        id2.setBounds(150, 180, 100, 30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id2);
        
        aid2=new JLabel(nic);
        aid2.setBounds(330, 180, 300, 30);
        aid2.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid2);
        
        id3=new JLabel("Address:");
        id3.setBounds(150, 230, 100, 30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id3);
        
        aid3=new JLabel(address);
        aid3.setBounds(330, 230, 300, 30);
        aid3.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid3);
        
        id4=new JLabel("Mobile NO:");
        id4.setBounds(150, 280, 100, 30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id4);
        
        aid4=new JLabel(phone);
        aid4.setBounds(330, 280, 300, 30);
        aid4.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid4);
        
        id5=new JLabel("Email Add:");
        id5.setBounds(150, 330, 100, 30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id5);
        
        aid5=new JLabel(email);
        aid5.setBounds(330, 330, 300, 30);
        aid5.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid5);
        
        id6=new JLabel("Education:");
        id6.setBounds(150, 380, 100, 30);
        id6.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id6);
        
        aid6=new JLabel(education);
        aid6.setBounds(330, 380, 300, 30);
        aid6.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid6);
        
        id7=new JLabel("Designation:");
        id7.setBounds(150, 430, 100, 30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id7);
        
        aid7=new JLabel(designation);
        aid7.setBounds(330, 430, 300, 30);
        aid7.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid7);
        
        b1=new JButton("Print");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(130, 520, 120, 40);
        b1.setFont(new Font("serif", Font.BOLD, 20));
        id9.add(b1);
        
        b2=new JButton("cancel");
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(360, 520, 120, 40);
        b2.setFont(new Font("serif", Font.BOLD, 20));
        id9.add(b2);

    }

    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==b1){
            JOptionPane.showMessageDialog(null,"printed successfully");
            f.setVisible(false);
            new Home();
        }
        if(e.getSource()==b2){
            f.setVisible(false);
            new Home();
        }
    
    }
}
