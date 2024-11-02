package modelo;

public class Factura {
    private DetallePedido detallepedido;
    private DetalleCliente detallecliente;
    private String fechapedido;

    public DetallePedido getDetallepedido() {
        return detallepedido;
    }

    public void setDetallepedido(DetallePedido detallepedido) {
        this.detallepedido = detallepedido;
    }

    public DetalleCliente getDetallecliente() {
        return detallecliente;
    }

    public void setDetallecliente(DetalleCliente detallecliente) {
        this.detallecliente = detallecliente;
    }

    public String getFechapedido() {
        return fechapedido;
    }

    public void setFechapedido(String fechapedido) {
        this.fechapedido = fechapedido;
    }
      
}
