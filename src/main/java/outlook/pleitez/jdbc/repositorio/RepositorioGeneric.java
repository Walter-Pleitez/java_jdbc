package outlook.pleitez.jdbc.repositorio;

import java.util.List;

public interface RepositorioGeneric<T> {
    List<T> listar();                 //lista los objetos buscandolos a todos
    T porId(Long id_producto);        //busca un solo objeto con base en el id
    void guardar(T t);                //Recibe objetos con los datos que se qquieren guardar
    void eliminar(Long id_producto);  // elimina al objeto con el id indicado

}
