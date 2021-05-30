package sender;

import mini.MiniTrouw;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import sender.Emailer;
import sender.EmailerTrouw;

import static org.junit.jupiter.api.Assertions.*;

class EmailerTest {

    @Test
    void prepare () {

        Emailer emailer = new EmailerTrouw();

        String name = "Karel J. van der Lelij";
        String address = "Den Haag";
        String text = "Deze tekst moet worden geplaatst in Trouw";
        JSONObject json = new JSONObject (String.format ("{ 'Name' : '%s', 'Address' : '%s', 'Text' : '%s' }", name, address, text));

        emailer.send (new MiniTrouw(json));

        String expectedBody = String.format ("= Tekst: %s%n" +
                                             "= Prijs: € %.2f%n" +
                                             "= %n" +
                                             "= Naam adverteerder: %s%n" +
                                             "= Adres: %s",
                                             text, 8.20, name, address);
        String expectedMail = String.format ("===============================================================================%n" +
                                             "= Volgende mail wordt aan %s verzonden met onderwerp '%s':%n= %n%s%n" +
                                             "===============================================================================%n",
                                             emailer.getEmailTo(), emailer.getSubject (), expectedBody);

        assertEquals (expectedMail, emailer.getMessageString());
    }
}