public interface IReportable {

    // Genera un reporte detallado en texto para que la Vista lo muestre
    String generarReporte();

    // Devuelve un resumen breve en texto para paneles o notificaciones
    String mostrarResumen();
}