
package employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Home extends JFrame implements ActionListener{
    
    JLabel li;
    Font f1, f2;
    
    Home(){
        super("Employee Home Page");
        setSize(1400,700);
        setLocation(0,0);
        
        f1 = new Font("Lucida Fax", Font.BOLD,16);
        f2 = new Font("Gadugi", Font.BOLD,20);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1400, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        li = new JLabel(i3);
        
        JMenuBar m1 = new JMenuBar();
        JMenu men1111 = new JMenu("                                                                                        ");
        JMenu men1 = new JMenu("Profile");
        JMenuItem ment1a = new JMenuItem("Add Employee");
        JMenuItem ment1b = new JMenuItem("View Employee Profile");
        JMenu men111 = new JMenu("                           ");
        
        JMenu men2 = new JMenu("Manage");
        JMenuItem ment2 = new JMenuItem("Update Details");
        JMenu men222 = new JMenu("                           ");
        
        JMenu men3 = new JMenu("Attendance");
        JMenuItem ment3a = new JMenuItem("Take Attendance");
        JMenu men333 = new JMenu("                           ");
        
        JMenu men4 = new JMenu("Leave");
        JMenuItem ment4a = new JMenuItem("Apply Leave");
        JMenu men444 = new JMenu("                           ");
        
        JMenu men5 = new JMenu("Salary");
        JMenuItem ment5a = new JMenuItem("Add Salary");
        JMenu men555 = new JMenu("                           ");
        
        JMenu men6 = new JMenu("Delete");
        JMenuItem ment6 = new JMenuItem("Delete Employee");
        JMenu men666 = new JMenu("                           ");
        
        JMenu men7 = new JMenu("Exit");
        JMenuItem ment7 = new JMenuItem("Logout");
        

        men1.add(ment1a);
        men1.add(ment1b);
        
        men2.add(ment2);
        
        men3.add(ment3a);
        
        
        men4.add(ment4a);
        
        
        men5.add(ment5a);
                
        men6.add(ment6);
        
        men7.add(ment7);
        
        m1.add(men1111);
        m1.add(men1);
        m1.add(men111);
        m1.add(men2);
        m1.add(men222);
        m1.add(men3);
        m1.add(men333);
        m1.add(men4);
        m1.add(men444);
        m1.add(men5);
        m1.add(men555);
        m1.add(men6);
        m1.add(men666);
        m1.add(men7);
        
        men1.setFont(f1);
        men2.setFont(f1);
        men3.setFont(f1);
        men4.setFont(f1);
        men5.setFont(f1);
        men6.setFont(f1);
        men7.setFont(f1);
        
        ment1a.setFont(f2);
        ment1b.setFont(f2);
        ment2.setFont(f2);
        ment3a.setFont(f2);
        
        ment4a.setFont(f2);
        ment5a.setFont(f2);
        
        ment6.setFont(f2);
        ment7.setFont(f2);
        
        m1.setBackground(Color.black);
        
        men1.setForeground(Color.gray);
        men2.setForeground(Color.gray);
        men3.setForeground(Color.gray);
        men4.setForeground(Color.gray);
        men5.setForeground(Color.gray);
        men6.setForeground(Color.gray);
        men7.setForeground(Color.red);
        
        ment1a.setBackground(Color.blue);
        ment1b.setBackground(Color.blue);
        ment2.setBackground(Color.blue);
        ment3a.setBackground(Color.blue);
        
        ment4a.setBackground(Color.blue);
        ment5a.setBackground(Color.blue);
        
        ment6.setBackground(Color.blue);
        ment7.setBackground(Color.blue);
        
        
        ment1a.setForeground(Color.yellow);
        ment1b.setForeground(Color.yellow);
        ment2.setForeground(Color.yellow);
        ment3a.setForeground(Color.yellow);
        ment4a.setForeground(Color.yellow);
        ment5a.setForeground(Color.yellow);
        ment6.setForeground(Color.yellow);
        ment7.setForeground(Color.yellow);
        
        ment1a.addActionListener(this);
        ment1b.addActionListener(this);
        ment2.addActionListener(this);
        ment3a.addActionListener(this);
        ment4a.addActionListener(this);
        ment5a.addActionListener(this);
        ment6.addActionListener(this);
        ment7.addActionListener(this);
        
        setJMenuBar(m1);
        add(li);
         
        
    }
    public void actionPerformed(ActionEvent ae){
        String comnd = ae.getActionCommand();
        if(comnd.equals("Add Employee")){
           new employee();
      
        }
        else if(comnd.equals("View Employee Profile")){
            new view();
        }
        else if(comnd.equals("Update Details")){
            new update().setVisible(true);
        }
        else if(comnd.equals("Take Attendance")){
            new attendance().setVisible(true);
        }
        else if(comnd.equals("Apply Leave")){
            new leave().setVisible(true);
        }
        else if(comnd.equals("Add Salary")){
            new salary().setVisible(true);
        }
        
        else if(comnd.equals("Delete Employee")){
            //System.out.println("Success");
            new delete().setVisible(true);
        }
        else if(comnd.equals("Logout")){
            System.exit(0);
        }
    }
   
   public static void main(String[] args){
       new Home().setVisible(true);
       
   }
}
