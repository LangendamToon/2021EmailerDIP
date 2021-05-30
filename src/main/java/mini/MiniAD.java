package mini;

import org.json.JSONObject;

public class MiniAD extends Mini {

    public MiniAD (JSONObject json) {
        super (json);
    }

    public double getPrice () {
        return getText ().length () * 0.22;
    }
}