public class Cliente {
    private String nombre;
    private String correo;

    // Constructor
    public Cliente(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    // Métodos getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

