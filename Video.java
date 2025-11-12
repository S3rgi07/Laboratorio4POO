public class Video extends Contenido {

    private double duracion;   // Duración del video en minutos
    private String formato;    // Formato del archivo (MP4, AVI, MKV, etc.)

    // Constructor
    public Video(int id, String titulo, String autor, String categoria, double duracion, String formato) {
        super(id, titulo, autor, categoria);
        this.duracion = duracion;
        this.formato = formato;
    }

    // Getters y Setters
    public double getDuracion() { return duracion; }
    public void setDuracion(double duracion) { this.duracion = duracion; }

    public String getFormato() { return formato; }
    public void setFormato(String formato) { this.formato = formato; }

    // Publica el video
    @Override
    public void publicar() {
        if (!publicado) {
            publicado = true;
        }
    }

    // Visualización para la GUI (sin impresión)
    @Override
    public void visualizar() {
        // La Vista mostrará esta información con botones o paneles
    }

    // Resumen corto del video
    @Override
    public String getResumen() {
        return "Video - " + titulo + " (" + categoria + ") [" + duracion + " min, " + formato + "]";
    }

    // Información detallada (para cuadro de texto en GUI)
    public String getDetalle() {
        return "Título: " + titulo +
               "\nAutor: " + autor +
               "\nCategoría: " + categoria +
               "\nDuración: " + duracion + " minutos" +
               "\nFormato: " + formato;
    }
}
