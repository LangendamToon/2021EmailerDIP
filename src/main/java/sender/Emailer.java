package sender;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Properties;

import mini.*;

public abstract class Emailer {

    protected static final String EMAIL_MINIMARKT = "minimarkt@dpgmedia.nl";

    private MimeMessage message;

    protected abstract String getEmailTo ();
    protected abstract String getSubject ();

    protected void prepare (Mini mini) {

        // Om dit te laten werken, moet natuurlijk een mailserver zijn geïnstalleerd op 'host'.
        String host = "localhost";

        // Initialiseer de server.
        Properties properties = System.getProperties ();
        properties.setProperty ("mail.smtp.host", host);
        Session session = Session.getDefaultInstance (properties);

        // Bereid de mail voor.
        try {
            message = new MimeMessage (session);
            message.setFrom (new InternetAddress (EMAIL_MINIMARKT));
            message.addRecipient (Message.RecipientType.TO, new InternetAddress (getEmailTo ()));
            message.setSubject (getSubject ());

            // Bereid de tekst voor de mail voor.
            Advertiser advertiser = mini.getAdvertiser ();
            message.setText (String.format ("= Tekst: %s%n" +
                                            "= Prijs: € %.2f%n" +
                                            "= %n" +
                                            "= Naam adverteerder: %s%n" +
                                            "= Adres: %s",
                                            mini.getText(), mini.getPrice(), advertiser.getName(), advertiser.getAddress()));
        }
        catch (MessagingException mex) {
            mex.printStackTrace ();
        }
    }

    protected String getMessageString () {

        try {
            return String.format ("===============================================================================%n" +
                                  "= Volgende mail wordt aan %s verzonden met onderwerp '%s':%n" +
                                  "= %n" +
                                  "%s%n" +
                                  "===============================================================================%n",
                                  message.getAllRecipients () [0], message.getSubject (), message.getContent ());
        }
        catch (IOException | MessagingException e) {
            e.printStackTrace ();
            return "";
        }
    }

    public void send (Mini mini) {

        // De mail wordt voorbereid.
        prepare (mini);

        // Zolang de mailserver niet is geïnstalleerd, wordt de mail alleen op het scherm getoond.
        System.out.println (getMessageString());

        /*
         * // Het bericht wordt verzonden.
         * try {
         *     TODO: Installeer mailserver op localhost.
         *     Transport.send (message);
         * }
         * catch (MessagingException mex) {
         *     mex.printStackTrace();
         *     return String.format ("Het is niet gelukt om de mail te verzenden naar %s", EMAIL_TROUW);
         * }
         */
    }
}