package electricty.Biiling.System;

import  java.sql.*;

public class connection {

    Statement s;
    Connection c;
    connection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "Khushi@893");
            s = c.createStatement();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
