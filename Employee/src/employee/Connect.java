
package employee;

import java.sql.*;

public class Connect {
    
    Connection con;
    Statement stm;
    
    Connect (){
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///employee_management_system", "root", "Sasi12#+");
            stm = con.createStatement();
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new Connect();
    }
}


