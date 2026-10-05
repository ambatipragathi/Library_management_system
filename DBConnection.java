package library;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static final String URL =
            "jdbc:mysql://localhost:3305/library_db";

    static final String USERNAME = "root";

    static final String PASSWORD = "@Pragathi124";

    public static Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
                URL,
                USERNAME,
                PASSWORD
        );
    }
}