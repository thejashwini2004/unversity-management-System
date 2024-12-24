 import java.sql.Connection;
    import java.sql.*;
     
    public class create db {
        //default constructor
        Connection c;
        Statement s;
       db () {
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    c =DriverManager.getConnection("jdbc:mysql://localhost:3306/'universitymanagementsystem'\r\n" + //,
            "root");
            s = c.createStatement();
    } catch (Exception e){
        e.printStackTrace();
    }
       }
    }
    
    
}
