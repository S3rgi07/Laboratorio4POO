import java.util.List;

public class Reporte implements IReportable {

    private RepositorioContenido repositorio; // Referencia al repositorio principal

    // Constructor
    public Reporte(RepositorioContenido repositorio) {
        this.repositorio = repositorio;
    }

    // Genera un reporte detallado del contenido
    @Override
    public String generarReporte() {
        StringBuilder sb = new StringBuilder();
        List<Contenido> contenidos = repositorio.listar();

        sb.append("=== REPORTE DE CONTENIDOS ===\n");
        sb.append("Total de contenidos: ").append(contenidos.size()).append("\n\n");

        int publicados = 0;
        int articulos = 0;
        int videos = 0;
        int imagenes = 0;

        for (Contenido c : contenidos) {
            if (c.isPublicado()) publicados++;
            if (c instanceof Articulo) articulos++;
            else if (c instanceof Video) videos++;
            else if (c instanceof Imagen) imagenes++;
        }

        sb.append("Publicados: ").append(publicados).append("\n");
        sb.append("Artículos: ").append(articulos).append("\n");
        sb.append("Videos: ").append(videos).append("\n");
        sb.append("Imágenes: ").append(imagenes).append("\n\n");

        sb.append("=== Detalles ===\n");
        for (Contenido c : contenidos) {
            sb.append(c.toString()).append("\n");
        }

        return sb.toString();
    }

    // Muestra un resumen más breve
    @Override
    public String mostrarResumen() {
        List<Contenido> lista = repositorio.listar();
        long publicados = lista.stream().filter(Contenido::isPublicado).count();
        return "Contenidos: " + lista.size() + " | Publicados: " + publicados;
    }
}