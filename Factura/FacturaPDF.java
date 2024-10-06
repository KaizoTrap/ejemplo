import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.FileOutputStream;
import java.io.IOException;

public class FacturaPDF {
    // Método para generar un archivo PDF
    public static void generarPDF(Factura factura, String filePath) throws IOException {
        // Create a FileOutputStream to write the PDF to a file
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        
        // Create a PdfWriter instance
        PdfWriter writer = new PdfWriter(fileOutputStream);
        
        // Create a PdfDocument instance
        PdfDocument pdfDocument = new PdfDocument(writer);
        
        // Create a Document instance
        Document document = new Document(pdfDocument);
        
        // Add a paragraph to the document
        document.add(new Paragraph(factura.generarContenidoFactura()));
        
        // Close the documentg
        document.close();
    }
}