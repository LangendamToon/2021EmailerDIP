package processor;

import org.json.JSONArray;
import org.json.JSONObject;

import receiver.MarktplaatsReceiver;
import mini.Mini;
import sender.Emailer;

import java.util.Observable;
import java.util.Observer;

public abstract class MiniProcessor implements Observer {

    public MiniProcessor (MarktplaatsReceiver receiver) {
        receiver.addObserver (this);
    }

    protected abstract String getName ();

    private boolean mustBePlacedInThisTitle (JSONObject json) {

        String nameOfTitle = getName ();
        JSONArray titles = json.getJSONArray ("Titles");

        for (int i = 0; i < titles.length (); i++) {

            if (titles.getString (i).equals (nameOfTitle)) {
                return true;
            }
        }

        return false;
    }

    protected abstract Mini getMini (JSONObject json);
    protected abstract Emailer getEmailer ();

    public void update (Observable o, Object arg) {

        if (mustBePlacedInThisTitle ((JSONObject) arg)) {

            Mini mini = getMini ((JSONObject) arg);
            Emailer sender = getEmailer ();
            sender.send (mini);
        }
    }
}