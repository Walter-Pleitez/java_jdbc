package outlook.pleitez.jdbc;
//Codigo antes de que se hiciera un invento de copiar y pegar el proyecto, cosa que no funciono siguiendo intrucciones
import outlook.pleitez.jdbc.modelo.Categoria;
import outlook.pleitez.jdbc.modelo.Producto;
import outlook.pleitez.jdbc.repositorio.ProductoRepoImplement;
import outlook.pleitez.jdbc.repositorio.RepositorioGeneric;
import outlook.pleitez.jdbc.util.ConexionBD;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

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
            producto.setNombre("Perfume recargado");
            producto.setPrecio(12);
            producto.setFechaRegistro(new Date());
            Categoria categoria = new Categoria();
            categoria.setId_categorias(2L);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto guardado con exito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
