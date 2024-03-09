package outlook.pleitez.jdbc.modelo;

public class Categoria {
    private Long id_categorias;
    private String nombre;

    public Long getId_categorias() {
        return id_categorias;
    }

    public void setId_categorias(Long id_categorias) {
        this.id_categorias = id_categorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
