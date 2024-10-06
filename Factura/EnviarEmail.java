import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class EnviarEmail {
    private String destinatario;
    private String remitente;
    private String asunto;
    private String cuerpo;

    public EnviarEmail(String destinatario, String remitente, String asunto, String cuerpo) {
        this.destinatario = destinatario;
        this.remitente = remitente;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
    }

    public void enviar(String filePath) {
        // Configuración del servidor de correo
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.example.com"); // Cambia esto al servidor SMTP adecuado
        props.put("mail.smtp.port", "587"); // Cambia al puerto adecuado (25, 465, 587, etc.)
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Autenticación
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("tu_correo@example.com", "tu_contraseña"); // Cambia a tus credenciales
            }
        });

        try {
            // Crear un nuevo mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asunto);

            // Cuerpo del mensaje
            MimeBodyPart bodyPart = new MimeBodyPart();
            bodyPart.setText(cuerpo);

            // Adjuntar el archivo PDF
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(new File(filePath)); // Asegúrate de que filePath sea la ruta correcta

            // Combinar partes del mensaje
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(bodyPart);
            multipart.addBodyPart(attachmentPart);

            // Establecer el contenido del mensaje
            message.setContent(multipart);

            // Enviar el mensaje
            Transport.send(message);

            System.out.println("Correo enviado con éxito.");

        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }
}

