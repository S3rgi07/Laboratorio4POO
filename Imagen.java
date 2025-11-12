public class Imagen extends Contenido {

    private String resolucion;  // Resolución (por ejemplo, "1920x1080")
    private String formato;     // Formato (PNG, JPG, GIF, etc.)

    // Constructor
    public Imagen(int id, String titulo, String autor, String categoria, String resolucion, String formato) {
        super(id, titulo, autor, categoria);
        this.resolucion = resolucion;
        this.formato = formato;
    }

    // Getters y Setters
    public String getResolucion() { return resolucion; }
    public void setResolucion(String resolucion) { this.resolucion = resolucion; }

    public String getFormato() { return formato; }
    public void setFormato(String formato) { this.formato = formato; }

    // Publica la imagen
    @Override
    public void publicar() {
        if (!publicado) {
            publicado = true;
        }
    }

    // Visualización para GUI (no imprime directamente)
    @Override
    public void visualizar() {
        // Los detalles se mostrarán en la interfaz Swing mediante Controller
    }

    // Resumen corto para listas o reportes
    @Override
    public String getResumen() {
        return "Imagen - " + titulo + " (" + categoria + ") [" + resolucion + " - " + formato + "]";
    }

    // Información detallada (para JTextArea o JOptionPane)
    public String getDetalle() {
        return "Título: " + titulo +
               "\nAutor: " + autor +
               "\nCategoría: " + categoria +
               "\nResolución: " + resolucion +
               "\nFormato: " + formato;
    }
}