//package travel.management.system;
//
//import java.sql.*;
//
//public class conn 
//{
//    Connection c;
//    Statement s;
//
//    public conn()
//    {
//        try
//        {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            c = DriverManager.getConnection(
//    "jdbc:mysql://localhost:3306/yourdatabase",
//    "root",
//    "123456"
//);
//            s = c.createStatement();
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
//}

package travel.management.system;

import java.sql.*;

public class conn {
    Connection c;
    Statement s;

   public conn() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        c = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/travelmanagementsystem",
            "root",
            "123456"
        );

        s = c.createStatement();
    } catch (Exception e) {
        System.out.println("Database Connection Failed!");
        e.printStackTrace();
    }
}
}