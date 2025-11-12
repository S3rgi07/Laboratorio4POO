import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VistaCMS extends JFrame {

    private JTable tablaContenidos;
    private DefaultTableModel modeloTabla;

    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnPublicar;
    private JButton btnReporte;
    private JButton btnActualizar;

    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtCategoria;
    private JTextArea txtExtra;

    public VistaCMS() {
        setTitle("CMS - Sistema de Gestión de Contenidos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // --- PANEL SUPERIOR: Formulario ---
        JPanel panelFormulario = new JPanel(new GridLayout(4, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Nuevo Contenido"));

        panelFormulario.add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        panelFormulario.add(txtTitulo);

        panelFormulario.add(new JLabel("Autor:"));
        txtAutor = new JTextField();
        panelFormulario.add(txtAutor);

        panelFormulario.add(new JLabel("Categoría:"));
        txtCategoria = new JTextField();
        panelFormulario.add(txtCategoria);

        panelFormulario.add(new JLabel("Descripción / Texto:"));
        txtExtra = new JTextArea(3, 20);
        panelFormulario.add(new JScrollPane(txtExtra));

        add(panelFormulario, BorderLayout.NORTH);

        // --- PANEL CENTRAL: Tabla ---
        modeloTabla = new DefaultTableModel(new String[]{"ID", "Título", "Autor", "Categoría", "Publicado"}, 0);
        tablaContenidos = new JTable(modeloTabla);
        add(new JScrollPane(tablaContenidos), BorderLayout.CENTER);

        // --- PANEL INFERIOR: Botones ---
        JPanel panelBotones = new JPanel(new FlowLayout());
        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar");
        btnPublicar = new JButton("Publicar");
        btnReporte = new JButton("Reporte");
        btnActualizar = new JButton("Actualizar");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnPublicar);
        panelBotones.add(btnReporte);
        panelBotones.add(btnActualizar);

        add(panelBotones, BorderLayout.SOUTH);
    }

    // Métodos para que el controlador acceda a los botones
    public JButton getBtnAgregar() { return btnAgregar; }
    public JButton getBtnEliminar() { return btnEliminar; }
    public JButton getBtnPublicar() { return btnPublicar; }
    public JButton getBtnReporte() { return btnReporte; }
    public JButton getBtnActualizar() { return btnActualizar; }

    // Obtiene los datos del formulario y crea un nuevo objeto Articulo por defecto
    public Contenido obtenerDatosContenido() {
        int id = (int) (Math.random() * 1000);
        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        String categoria = txtCategoria.getText();
        String cuerpo = txtExtra.getText();
        return new Articulo(id, titulo, autor, categoria, cuerpo);
    }

    // Obtiene el ID del contenido seleccionado en la tabla
    public int obtenerIdSeleccionado() {
        int fila = tablaContenidos.getSelectedRow();
        if (fila == -1) return -1;
        Object valor = modeloTabla.getValueAt(fila, 0);
        return (int) valor;
    }

    // Actualiza la tabla con la lista de contenidos
    public void actualizarTabla(List<Contenido> lista) {
        modeloTabla.setRowCount(0);
        for (Contenido c : lista) {
            modeloTabla.addRow(new Object[]{
                c.getId(),
                c.getTitulo(),
                c.getAutor(),
                c.getCategoria(),
                c.isPublicado() ? "Sí" : "No"
            });
        }
    }

    // Muestra el reporte completo en un cuadro de texto
    public void mostrarReporte(String texto) {
        JTextArea area = new JTextArea(texto);
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(600, 400));
        JOptionPane.showMessageDialog(this, scroll, "Reporte del Sistema", JOptionPane.INFORMATION_MESSAGE);
    }
}