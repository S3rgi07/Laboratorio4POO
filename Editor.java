public class Editor extends Usuario {

    // Constructor
    public Editor(String nombre, String correo) {
        super(nombre, correo, "Editor");
    }

    // Permisos del editor
    @Override
    public boolean puedePublicar() { return false; }

    @Override
    public boolean puedeEliminar() { return false; }

    @Override
    public boolean puedeEditar() { return true; }

    // Información del usuario
    @Override
    public String toString() {
        return "Editor: " + nombre + " | Correo: " + correo;
    }
}