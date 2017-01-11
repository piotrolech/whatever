package whatever;


import org.apache.commons.mail.EmailException;

import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, EmailException {
        File file = new File("content.csv");
        AppHandling.createContent(file);
        String content = AppHandling.readFile(file);
        AppHandling.sendMail("javandwro1@gmail.com", "Test z pliku", content);
    }
}
