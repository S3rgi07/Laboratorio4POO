
public class Articulo extends Contenido {

    private String cuerpo; // Texto principal del artículo

    // Constructor
    public Articulo(int id, String titulo, String autor, String categoria, String cuerpo) {
        super(id, titulo, autor, categoria);
        this.cuerpo = cuerpo;
    }

    // Getter y Setter del cuerpo
    public String getCuerpo() { return cuerpo; }
    public void setCuerpo(String cuerpo) { this.cuerpo = cuerpo; }

    // Marca el artículo como publicado
    @Override
    public void publicar() {
        if (!publicado) {
            publicado = true;
        }
    }

    // Devuelve información para mostrar en la GUI
    @Override
    public void visualizar() {
        // No imprime directamente; la Vista mostrará los datos que obtiene
    }

    // Devuelve un resumen del artículo
    @Override
    public String getResumen() {
        String resumen = cuerpo.length() > 60 ? cuerpo.substring(0, 60) + "..." : cuerpo;
        return "Artículo - " + titulo + " (" + categoria + "): " + resumen;
    }

    // Devuelve información detallada (para cuadros de texto o modales)
    public String getDetalle() {
        return "Título: " + titulo + "\nAutor: " + autor +
               "\nCategoría: " + categoria + "\n\n" + cuerpo;
    }
}