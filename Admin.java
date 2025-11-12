public class Admin extends Usuario {

    // Constructor
    public Admin(String nombre, String correo) {
        super(nombre, correo, "Administrador");
    }

    // Permisos del administrador
    @Override
    public boolean puedePublicar() { return true; }

    @Override
    public boolean puedeEliminar() { return true; }

    @Override
    public boolean puedeEditar() { return true; }

    // Información del usuario
    @Override
    public String toString() {
        return "Administrador: " + nombre + " | Correo: " + correo;
    }
}