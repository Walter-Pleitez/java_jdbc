package outlook.pleitez.jdbc.repositorio;

import outlook.pleitez.jdbc.modelo.Producto;
import outlook.pleitez.jdbc.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepoImplement implements RepositorioGeneric<Producto>{
    //Se necesita un metodo que devuelva la conexion a la BD
    private Connection getConnection() throws Exception {
        return ConexionBD.getInstance();
    }

    //IMPLEMENTACION DE METODOS BASICOS PARA EL CRUD
    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        try {
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM producto");
            while(rs.next()){
                Producto p = getProducto(rs); //crearProducto(rs); con refactor Extract Method
                productos.add(p);
            }
        } catch (Exception e) {
            //Aquí podría llevar un "SQLException e" con su "e.PrintStackTrace();"
            throw new RuntimeException(e);
        }
        return productos;
    }

    @Override
    public Producto porId(Long id_producto) {
        Producto producto = null;
        try(PreparedStatement stmt = getConnection().
                        prepareStatement("SELECT * FROM producto WHERE id_producto = ?")) {
            stmt.setLong(1, id_producto);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                producto = getProducto(rs);
            }
            rs.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void eliminar(Long id_producto) {

    }

    //METODO CREADO CON Extract Method para reutlizar codigo de los metodos del CRUD
    private static Producto getProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId_producto(rs.getLong("id_producto"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFechaRegistro(rs.getDate("fecha_registro"));
        return p;
    }
}
