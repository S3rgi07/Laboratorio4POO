import java.time.LocalDateTime;

public abstract class Contenido implements IPublicable {

    protected int id;                    // Identificador único
    protected String titulo;             // Título del contenido
    protected String autor;              // Nombre del autor
    protected String categoria;          // Categoría principal
    protected LocalDateTime fechaCreacion; // Fecha de creación
    protected boolean publicado;         // Estado de publicación

    // Constructor base
    public Contenido(int id, String titulo, String autor, String categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.fechaCreacion = LocalDateTime.now();
        this.publicado = false;
    }

    // Getters y setters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getCategoria() { return categoria; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public boolean isPublicado() { return publicado; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    // Elimina (simulado)
    public void eliminar() {
        this.publicado = false;
        this.titulo = "[ELIMINADO] " + this.titulo;
    }

    // Método abstracto para obtener un resumen del contenido
    public abstract String getResumen();

    // Devuelve una descripción general (usada en GUI)
    @Override
    public String toString() {
        return "ID: " + id +
               " | Título: " + titulo +
               " | Autor: " + autor +
               " | Categoría: " + categoria +
               " | Publicado: " + (publicado ? "Sí" : "No");
    }
}