package outlook.pleitez.jdbc;

import outlook.pleitez.jdbc.modelo.Producto;
import outlook.pleitez.jdbc.repositorio.ProductoRepoImplement;
import outlook.pleitez.jdbc.repositorio.RepositorioGeneric;
import outlook.pleitez.jdbc.util.ConexionBD;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJDBC {
    public static void main(String[] args) {

        try (Connection conn = ConexionBD.getInstance())
        {
            //Se deja una sola conexion con la BD para toda la aplicacion facilitara el close(); (Pendiente creo)
            RepositorioGeneric<Producto> repositorio = new ProductoRepoImplement();
            repositorio.listar().forEach(p -> System.out.println(p.getNombre()));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
