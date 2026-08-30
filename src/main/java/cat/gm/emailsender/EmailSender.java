/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package cat.gm.emailsender;

import java.util.Properties;
import jakarta.mail.Session;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.io.Console;
import java.io.InputStream;

/**
 *
 * @author Pau
 */
public class EmailSender {

    public static void main(String[] args) {
        /*
        final String username = "pcasals@insgabrielamistral.cat";
        final String password = "la vostra contrasenya d'app"; // no la normal, sino App Password

        /* Importar datos de conexión desde el archivo de configuración */
       
        String username = ConfiguracioSMTP.get("mail.smtp.username");
        String password = ConfiguracioSMTP.get("mail.smtp.password");
        String host = ConfiguracioSMTP.get("mail.smtp.host");
        String port = ConfiguracioSMTP.get("mail.smtp.port");
        String auth = ConfiguracioSMTP.get("mail.smtp.auth");
        String tls = ConfiguracioSMTP.get("mail.smtp.starttls.enable");
        
        
        /* Migrar esta configuración al archivo de configuración mail.properties */
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        }
        );
                           
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("ElEmailReceptor@gmail.com")
            );
            message.setSubject("Campaña Publicitaria - Mark Stalker");
            
            String html = ConfiguracioSMTP.enviarEmail();
            message.setContent(html, "text/html; charset=UTF-8");
            
            Transport.send(message);
            System.out.println("Correo enviado correctamente.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
