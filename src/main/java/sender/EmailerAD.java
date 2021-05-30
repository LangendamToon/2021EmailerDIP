package sender;

import sender.Emailer;

public class EmailerAD extends Emailer {

    protected String getEmailTo () {
        return "mini@ad.nl";
    }

    protected String getSubject () {
        return "Onderstaand Kleintje moet in AD worden geplaatst";
    }
}