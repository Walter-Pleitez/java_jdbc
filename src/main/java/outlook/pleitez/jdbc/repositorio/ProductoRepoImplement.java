package outlook.pleitez.jdbc.repositorio;

import outlook.pleitez.jdbc.modelo.Producto;
import outlook.pleitez.jdbc.util.ConexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
                Producto p = new Producto();
                p.setId_producto(rs.getLong("id_producto"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getInt("precio"));
                p.setFechaRegistro(rs.getDate("fecha_registro"));
                productos.add(p);
            }
            //Aquí podría llevar un "SQLException e" con su "e.PrintStackTrace();"
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return productos;
    }

    @Override
    public Producto porId(Long id_producto) {
        return null;
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void eliminar(Long id_producto) {

    }
}
