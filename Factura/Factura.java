import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Producto> productos;
    private static int contadorFacturas = 0;
    private int numeroFactura;
    private double total;

    // Constructor
    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.numeroFactura = ++contadorFacturas;
        this.total = 0.0;
    }

    // Métodos getter y setter
    public Cliente getCliente() {
        return cliente;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public double getTotal() {
        return total;
    }

    // Añadir un producto a la factura
    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
        this.total += producto.getPrecio();
    }

    // Método que genera el contenido de la factura
    public String generarContenidoFactura() {
        StringBuilder contenido = new StringBuilder();
        contenido.append("Factura N°: ").append(numeroFactura).append("\n");
        contenido.append("Cliente: ").append(cliente.getNombre()).append("\n");
        contenido.append("Productos:\n");
        for (Producto producto : productos) {
            contenido.append(producto.detallesProducto()).append("\n");
        }
        contenido.append("Total: $").append(total).append("\n");
        return contenido.toString();
    }
}
