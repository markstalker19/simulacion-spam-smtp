/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.gm.emailsender;
import java.io.InputStream;
import java.util.Properties;
/**
 *
 * @author Mark
 */
public class ConfiguracioSMTP {
     private static final Properties props = new Properties();

    static {
        try (InputStream in = ConfiguracioSMTP.class.getClassLoader()
                .getResourceAsStream("mail.properties")) {

            if (in == null) {
                throw new RuntimeException("No se encontró mail.properties");
            }

            props.load(in);

        } catch (Exception e) {
            throw new RuntimeException("Error cargando configuración SMTP", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
    
    public static String enviarEmail(){
        String html = "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "    <title>Amplia \n" +
                        "    </title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    \n" +
                        "    <h1>Amplia tu almacenamiento</h1>\n" +
                        "    \n" +
                        "    <p>Hemos detectado que te queda poco espacio de almacenamiento</p>\n" +
                        "    <img id=\"imagenFondo\" src=\"https://www.shutterstock.com/image-vector/suraba-id-nov-01-2022-260nw-2342551277.jpg\">\n" +
                        "    <P><strong>AMPLIAR TU ALMACENCENAMIENTO PARA<br>\n" +
                        "    PODER SEGUIR MANTENIENDO TU INFORMACION</strong> \n" +
                        "    </P>\n" +
                        "    <p>\n" +
                        "        <a href=\"http://google.es\">Amplia tu almacenamiento clicando aqui!!</a>\n" +
                        "    </p>\n" +
                        "</body>\n" +
                        "</html>";
        
        return html;
    }
}
