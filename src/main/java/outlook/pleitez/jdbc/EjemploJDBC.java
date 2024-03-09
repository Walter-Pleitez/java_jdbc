package outlook.pleitez.jdbc;

import outlook.pleitez.jdbc.modelo.Producto;
import outlook.pleitez.jdbc.repositorio.ProductoRepoImplement;
import outlook.pleitez.jdbc.repositorio.RepositorioGeneric;
import outlook.pleitez.jdbc.util.ConexionBD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class EjemploJDBC {
    public static void main(String[] args) {

        try (Connection conn = ConexionBD.getInstance())
        {
            //Se deja una sola conexion con la BD para toda la aplicacion facilitara el close(); (Pendiente creo)
            RepositorioGeneric<Producto> repositorio = new ProductoRepoImplement();
            System.out.println("========== Listar ==========");
            repositorio.listar().forEach(System.out::println); //Abreviando impresion en consola
            System.out.println("========== Obtener por Id ==========");
            System.out.println(repositorio.porId(1L));
            System.out.println("========== Insertar nuevo producto ==========");
            Producto producto = new Producto();
            producto.setNombre("Perfume");
            producto.setPrecio(10);
            producto.setFechaRegistro(new Date(2024,3,8));
            repositorio.guardar(producto);
            System.out.println("Producto guardado con exito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
