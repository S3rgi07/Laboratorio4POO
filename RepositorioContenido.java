import java.util.ArrayList;
import java.util.List;

public class RepositorioContenido implements IGestionable<Contenido> {

    private List<Contenido> listaContenidos; // Almacenamiento en memoria

    // Constructor
    public RepositorioContenido() {
        listaContenidos = new ArrayList<>();
    }

    // Agrega un nuevo contenido
    @Override
    public void agregar(Contenido elemento) {
        listaContenidos.add(elemento);
    }

    // Edita un contenido existente según su id
    @Override
    public void editar(int id, Contenido nuevoElemento) {
        for (int i = 0; i < listaContenidos.size(); i++) {
            if (listaContenidos.get(i).getId() == id) {
                listaContenidos.set(i, nuevoElemento);
                break;
            }
        }
    }

    // Elimina un contenido por su id
    @Override
    public boolean eliminar(int id) {
        return listaContenidos.removeIf(c -> c.getId() == id);
    }

    // Busca contenido por id
    @Override
    public Contenido buscarPorId(int id) {
        for (Contenido c : listaContenidos) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    // Devuelve toda la lista
    @Override
    public List<Contenido> listar() {
        return new ArrayList<>(listaContenidos);
    }

    // Filtra contenidos según texto en título, autor o categoría
    @Override
    public List<Contenido> filtrar(String criterio) {
        List<Contenido> filtrados = new ArrayList<>();
        for (Contenido c : listaContenidos) {
            if (c.getTitulo().toLowerCase().contains(criterio.toLowerCase()) ||
                c.getAutor().toLowerCase().contains(criterio.toLowerCase()) ||
                c.getCategoria().toLowerCase().contains(criterio.toLowerCase())) {
                filtrados.add(c);
            }
        }
        return filtrados;
    }
}