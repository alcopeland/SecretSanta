import java.util.Properties;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class SendEmail
{
    // email address = secretSantaSender14@gmail.com
    // password = emailSending
    private final String sender = "secretsantasender14@gmail.com";
    private String msg;
    public SendEmail(Person person, String password)
    {
        msg = "Hello "+person.getForename()+"\n" +
                "\n" +
                "Your Secret Santa is: "+person.getRecipient().getForename()+" "+person.getRecipient().getSurname()+"\n" +
                "\n" +
                "They have said their hobbies are: \n" +
                "" + person.getRecipient().getHobbies() + "\n" +
                "Good Luck\n" +
                "\n" +
                "Santa";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new jakarta.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(sender,password);
                    }
                });
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(person.getEmail()));
            String subject = "Secret Santa";
            message.setSubject(subject);
            message.setText(msg);
            //send message
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (MessagingException e) {throw new RuntimeException(e);}
    }
}
