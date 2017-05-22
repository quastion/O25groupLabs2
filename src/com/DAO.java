package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by fil-n on 22.04.17.
 */
public abstract class DAO {
    private static Connection connection;
    public static Connection getConnection () throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Locale.setDefault(Locale.getDefault());
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orc","USER_NETCRACKER","123");
        }
        return  connection;
    }
}
