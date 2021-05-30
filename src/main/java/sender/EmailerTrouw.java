package sender;

import sender.Emailer;

public class EmailerTrouw extends Emailer {

    protected String getEmailTo () {
        return "mini@trouw.nl";
    }

    protected String getSubject () {
        return "Graag plaatsing van onderstaande Mini in Trouw";
    }
}