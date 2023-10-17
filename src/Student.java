import com.mysql.cj.xdevapi.PreparableStatement;

import java.sql.*;
public class Student {
    public static void main(String[] args) {
        Connection con;
        PreparedStatement pst;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/lbs","root","root");
            System.out.println("Success");
        } catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
