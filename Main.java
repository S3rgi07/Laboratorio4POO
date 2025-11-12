/*
 * Autor: Antony Portillo, sergio Lopez, Daniela Montenegro 
 * Proyecto: CMS con GUI (Sistema de Gestión de Contenidos)
 * Descripción: Punto de entrada de la aplicación. Configura las capas del patrón MVC
 *              (Modelo, Vista, Controlador) e inicia la interfaz gráfica (Swing).
 *              Crea datos de ejemplo en memoria y un usuario administrador por defecto.
 * Notas:
 *  - Se ejecuta en el hilo de eventos de Swing (invokeLater) para evitar errores de GUI.
 *  - Demuestra el funcionamiento de la aplicación con datos precargados.
 * Auxiliares: Kevin Villagran y Esteban Carcamo los mejores :D
 */

import javax.swing.SwingUtilities;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // arranque seguro de Swing en el EDT
        SwingUtilities.invokeLater(() -> {
            // modelo
            RepositorioContenido repo = new RepositorioContenido();

            // datos de ejemplo para que la GUI no arranque vacía
            repo.agregar(new Articulo(1, "Patrones de Diseño", "Gamma et al", "Arquitectura", 
                    "Resumen de patrones clásicos y su aplicación práctica en proyectos"));
            repo.agregar(new Video(2, "Introducción a POO", "Antony", "Programación", 15.5, "MP4"));
            repo.agregar(new Imagen(3, "Diagrama UML", "Daniela", "Documentación", "1920x1080", "PNG"));

            // vista
            VistaCMS vista = new VistaCMS();

            // usuario por defecto
            Usuario usuario = new Admin("Administrador General", "admin@cms.edu");

            // controlador
            Controller controller = new Controller(repo, vista, usuario);

            // sincroniza la tabla con el estado inicial del repositorio
            vista.actualizarTabla(repo.listar());

            // muestra la ventana
            vista.setVisible(true);
        });
    }
}