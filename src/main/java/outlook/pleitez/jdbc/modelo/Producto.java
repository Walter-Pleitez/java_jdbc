package outlook.pleitez.jdbc.modelo;

import java.util.Date;

public class Producto {
    private long id_producto;
    private String nombre;
    private Integer precio;
    private Date fechaRegistro;
    private Categoria categoria;

    public Producto() {
    }
    public Producto(long id_producto, String nombre, Integer precio, Date fechaRegistro) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return id_producto +
                " | " +
                nombre +
                " | " +
                precio +
                " | " +
                fechaRegistro +
                " | " +
                categoria.getNombre();
    }

    public long getId_producto() {
        return id_producto;
    }

    public void setId_producto(long id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
