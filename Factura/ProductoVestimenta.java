public class ProductoVestimenta extends Producto {
    private String talla;

    // Constructor
    public ProductoVestimenta(String nombre, double precio, String descripcion, String talla) {
        super(nombre, precio, descripcion);
        this.talla = talla;
    }

    // Métodos getter y setter
    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    // Sobrescribimos el método detallesProducto para incluir la talla
    @Override
    public String detallesProducto() {
        return super.detallesProducto() + " (Talla: " + talla + ")";
    }
}
