public abstract class Usuario {

    protected String nombre;   // Nombre del usuario
    protected String correo;   // Correo del usuario
    protected String rol;      // Rol: "Admin" o "Editor"

    // Constructor
    public Usuario(String nombre, String correo, String rol) {
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getRol() { return rol; }

    // Métodos comunes
    public abstract boolean puedePublicar();  // Define permisos
    public abstract boolean puedeEliminar();  // Define permisos
    public abstract boolean puedeEditar();    // Define permisos

    // Devuelve una descripción del usuario (para mostrar en la GUI)
    @Override
    public String toString() {
        return nombre + " (" + rol + ")";
    }
}
