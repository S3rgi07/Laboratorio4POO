import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class Controller {

    private RepositorioContenido repositorio;
    private Reporte reporte;
    private VistaCMS vista;
    private Usuario usuarioActivo;

    // Constructor: recibe vista y modelo
    public Controller(RepositorioContenido repositorio, VistaCMS vista, Usuario usuario) {
        this.repositorio = repositorio;
        this.vista = vista;
        this.usuarioActivo = usuario;
        this.reporte = new Reporte(repositorio);

        inicializarEventos();
    }

    // Asocia los eventos de los botones con las acciones correspondientes
    private void inicializarEventos() {
        vista.getBtnAgregar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarContenido();
            }
        });

        vista.getBtnEliminar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarContenido();
            }
        });

        vista.getBtnPublicar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                publicarContenido();
            }
        });

        vista.getBtnReporte().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarReporte();
            }
        });

        vista.getBtnActualizar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refrescarLista();
            }
        });
    }

    // Agrega un nuevo contenido al repositorio
    private void agregarContenido() {
        try {
            Contenido nuevo = vista.obtenerDatosContenido();
            repositorio.agregar(nuevo);
            JOptionPane.showMessageDialog(null, "Contenido agregado correctamente");
            refrescarLista();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar: " + ex.getMessage());
        }
    }

    // Elimina un contenido por ID
    private void eliminarContenido() {
        if (!usuarioActivo.puedeEliminar()) {
            JOptionPane.showMessageDialog(null, "No tienes permisos para eliminar contenidos");
            return;
        }
        int id = vista.obtenerIdSeleccionado();
        if (repositorio.eliminar(id)) {
            JOptionPane.showMessageDialog(null, "Contenido eliminado correctamente");
            refrescarLista();
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró contenido con ese ID");
        }
    }

    // Publica un contenido existente
    private void publicarContenido() {
        if (!usuarioActivo.puedePublicar()) {
            JOptionPane.showMessageDialog(null, "No tienes permisos para publicar contenidos");
            return;
        }
        int id = vista.obtenerIdSeleccionado();
        Contenido c = repositorio.buscarPorId(id);
        if (c != null) {
            c.publicar();
            JOptionPane.showMessageDialog(null, "Contenido publicado con éxito");
            refrescarLista();
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el contenido");
        }
    }

    // Muestra un reporte general
    private void mostrarReporte() {
        String texto = reporte.generarReporte();
        vista.mostrarReporte(texto);
    }

    // Actualiza la lista visible en la vista
    private void refrescarLista() {
        List<Contenido> lista = repositorio.listar();
        vista.actualizarTabla(lista);
    }
}