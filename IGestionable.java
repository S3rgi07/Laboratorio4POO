import java.util.List;

public interface IGestionable<T> {

    // Agrega un nuevo elemento a la colección
    void agregar(T elemento);

    // Edita un elemento existente según su id o índice
    void editar(int id, T nuevoElemento);

    // Elimina un elemento de la colección por su id
    boolean eliminar(int id);

    // Busca un elemento por id y devuelve el resultado
    T buscarPorId(int id);

    // Lista todos los elementos disponibles
    List<T> listar();

    // Filtra elementos según un criterio (por título, autor, etc.)
    List<T> filtrar(String criterio);
}