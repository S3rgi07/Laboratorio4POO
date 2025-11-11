public interface IPublicable {

    // Marca el contenido como publicado o disponible
    void publicar();

    // Permite que la vista consulte datos para mostrar
    // La implementación puede preparar datos internos pero no imprimir
    void visualizar();
}