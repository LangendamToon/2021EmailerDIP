package receiver;

import org.json.JSONObject;

import java.util.Observable;

public class MarktplaatsReceiver extends Observable {

    public void publishMini (String mini) {
        setChanged ();
        notifyObservers (new JSONObject (mini));
    }
}
