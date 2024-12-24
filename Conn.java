import java.sql.Connection;
import java.sql.*;
public class Conn {

        //default constructor
        Connection c;
        Statement s;
       Conn () {
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    c =DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem","root","984586Rr*" );
            s = c.createStatement();
    } catch (Exception e){
        e.printStackTrace();
    }
       }
    }
        

