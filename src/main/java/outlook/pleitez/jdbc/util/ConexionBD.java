package outlook.pleitez.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    private static String url = "jdbc:mysql://localhost:3306/java_curso";
    private static String username = "root";
    private static String password = "root";
    private static Connection connection = null;

    public static Connection getInstance() throws Exception{
        if(connection == null){
            connection = DriverManager.getConnection(url, username, password);
        }

        return connection;
    }
}
