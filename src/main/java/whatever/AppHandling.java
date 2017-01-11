package whatever;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.io.Files;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.lineSeparator;

/**
 * Created by Piotr on 10.01.2017.
 */
public class AppHandling {
    public static void createContent(File file) {
        System.out.println("Wprowadź treść maila, który chcesz wysłać: ");

        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine();
        try {
            Files.write(content, file, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(File file) throws IOException {
        String content;
        content = Files.toString(file, Charsets.UTF_8);
        return content;
    }

    public static void sendMail(String address, String title, String content) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("javandwro1@gmail.com", "javand1wro"));
        email.setSSLOnConnect(true);
        email.setFrom("javandwro1@gmail.com");
        email.setSubject(title);
        email.setMsg(content);
        email.addTo(address);
        email.send();
    }

//    public static void sendMailWithMessageFromFile(String address, String title, String filePath) throws IOException, EmailException {
//        File file = new File(filePath);
//        List<String> linesFiles = Files.readLines(file, Charsets.UTF_8);
//
//        Joiner joiner = Joiner.on(System.lineSeparator());
//        String text = joiner.join(linesFiles);
//
//        sendMail(address, title, text);
//
//    }
}
