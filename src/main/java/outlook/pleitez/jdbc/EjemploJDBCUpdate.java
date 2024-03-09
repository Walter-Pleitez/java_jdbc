package outlook.pleitez.jdbc;

import outlook.pleitez.jdbc.modelo.Categoria;
import outlook.pleitez.jdbc.modelo.Producto;
import outlook.pleitez.jdbc.repositorio.ProductoRepoImplement;
import outlook.pleitez.jdbc.repositorio.RepositorioGeneric;
import outlook.pleitez.jdbc.util.ConexionBD;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJDBCUpdate {
    public static void main(String[] args) {

        try (Connection conn = ConexionBD.getInstance())
        {
            //Se deja una sola conexion con la BD para toda la aplicacion facilitara el close(); (Pendiente creo)
            RepositorioGeneric<Producto> repositorio = new ProductoRepoImplement();
            System.out.println("========== Listar ==========");
            repositorio.listar().forEach(System.out::println); //Abreviando impresion en consola

            System.out.println("========== Obtener por Id ==========");
            System.out.println(repositorio.porId(1L));

            System.out.println("========== Editar producto ==========");
            Producto producto = new Producto();
            producto.setId_producto(3L);
            producto.setNombre("Cera Liquida litro");
            producto.setPrecio(2);
            Categoria categoria = new Categoria();
            categoria.setId_categorias(3L);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto actualizado con exito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
