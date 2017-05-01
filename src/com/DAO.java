package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by fil-n on 22.04.17.
 */
public abstract class DAO {
    public static Connection getConnection () throws ClassNotFoundException, SQLException {
        Locale.setDefault(Locale.ENGLISH);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orc","USER_NETCRACKER","123");
    }

}
