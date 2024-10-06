import javax.mail.MessagingException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Crear cliente
        Cliente cliente = new Cliente("Juan Pérez", "martincasasdaniela@gmail.com");

        // Crear productos
        ProductoVestimenta camisa = new ProductoVestimenta("Camisa", 20.0, "Camisa blanca de algodón", "M");
        ProductoVestimenta pantalon = new ProductoVestimenta("Pantalón", 40.0, "Pantalón negro de vestir", "L");

        // Crear factura
        Factura factura = new Factura(cliente);
        factura.agregarProducto(camisa);
        factura.agregarProducto(pantalon);

        // Generar PDF de la factura
        String filePath = "factura.pdf";
        try {
            // Generar el PDF de la factura
            FacturaPDF.generarPDF(factura, filePath);
            System.out.println("Factura generada en: " + filePath);

            // Enviar la factura por correo
            String asunto = "Factura de Compra";
            String cuerpo = "Adjunto encontrarás tu factura.";
            EnviarEmail email = new EnviarEmail(cliente.getCorreo(), "tu_correo@example.com", asunto, cuerpo);
            email.enviar(filePath); // Llama al método enviar de EnviarEmail con el filePath

        }catch (IOException e) {
            System.err.println("Error al generar el PDF: " + e.getMessage());
        }
        // Esto imprime el stack trace para más detalles sobre el error
        
    }
}
