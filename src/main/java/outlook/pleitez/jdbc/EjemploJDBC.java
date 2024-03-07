package outlook.pleitez.jdbc;

import java.sql.*;

public class EjemploJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java_curso";
        String username = "root";
        String password = "root";

        try (
                Connection conn = DriverManager.getConnection(url, username, password);
                Statement stmt = conn.createStatement();
                ResultSet resultado = stmt.executeQuery("SELECT * FROM producto")
                )
        {
            while(resultado.next()){
                System.out.print(" | ");
                System.out.print(resultado.getString("id_producto"));
                System.out.print(" | ");
                System.out.print(resultado.getString("nombre"));
                System.out.print(" | ");
                System.out.print("$");
                System.out.print(resultado.getString("precio"));
                System.out.print(" | ");
                System.out.println(resultado.getString("fecha_registro"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
