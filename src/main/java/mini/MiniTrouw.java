package mini;

import org.json.JSONObject;

public class MiniTrouw extends Mini {

    public MiniTrouw (JSONObject json) {
        super (json);
    }

    public double getPrice () {

        int aantalKarakters = getText ().length ();

        if (aantalKarakters >= 100) {
            return aantalKarakters * 0.18;
        }
        else if (aantalKarakters >= 25) {
            return aantalKarakters * 0.20;
        }
        else if (aantalKarakters > 0) {
            return 5.0;
        }
        else {
            return 0.0;
        }
    }
}