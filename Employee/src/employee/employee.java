
package employee;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class employee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(9999);
    
    JTextField tfname, tffname, tfaddress, tfphone, tfnic, tfemail, tfsalary, tfempId, tfdesignation ;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel labelempId;
    JButton addDetails, back;

    employee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(380, 30, 500, 50);
        heading.setFont(new Font("SAN SERIF", Font.BOLD, 30));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.BOLD, 20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30 );
        add(tfname);
        
        JLabel labelfname = new JLabel("Father's name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.BOLD, 20));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30 );
        add(tffname);
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.BOLD, 20));
        add(labeldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);
        
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30 );
        add(tfaddress);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.BOLD, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30 );
        add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.BOLD, 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30 );
        add(tfemail);
        
        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.BOLD, 20));
        add(labeleducation);
        
        String courses[] = {"None" , "BBA", "BCA", "BA", "BSC" ,"B.COM", "B.TECH", "MBA", "MA", "MSC"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(600, 300, 150, 30 );
        add(cbeducation);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.BOLD, 20));
        add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30 );
        add(tfdesignation);
        
        JLabel labelnic = new JLabel("NIC");
        labelnic.setBounds(400, 200, 150, 30);
        labelnic.setFont(new Font("serif", Font.BOLD, 20));
        add(labelnic);
        
        tfnic = new JTextField();
        tfnic.setBounds(600, 200, 150, 30 );
        add(tfnic);
        
        labelempId = new JLabel("Employee ID");
        labelempId.setBounds(400, 350, 150, 30);
        labelempId.setFont(new Font("serif", Font.BOLD, 20));
        add(labelempId);
        
        tfempId = new JTextField("" +number);
        tfempId.setBounds(600, 350, 150, 30 );
        add(tfempId);
        
        addDetails = new JButton("Add Details");
        addDetails.setBounds(300, 500, 150, 40);
        addDetails.addActionListener(this);
        addDetails.setBackground(Color.BLACK);
        addDetails.setForeground(Color.WHITE);
        add(addDetails);
        
        back = new JButton("Back");
        back.setBounds(550, 500, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/aa.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(750, 150, 300, 300);
        add(image);
        
        
        setSize(1100, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == addDetails ){
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String highest_education = (String)cbeducation.getSelectedItem();
            String designation = tfdesignation.getText();
            String nic = tfnic.getText();
            String empId = tfempId.getText();
            
            try {
                Connect cc = new Connect();
                String query = "insert into addem values('"+name+"', '"+fname+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+highest_education+"', '"+designation+"', '"+nic+"','"+empId+"')";
                cc.stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
                
              }catch (Exception e){
                e.printStackTrace();
            }
     }   else {
          setVisible(false);
          new Home();
        
        }
        
        
}
    
    public static void main(String[] args) {
        new employee(); 
    }

    
}

