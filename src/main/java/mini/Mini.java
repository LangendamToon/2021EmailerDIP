package mini;

import org.json.JSONObject;

public abstract class Mini {

    private String text;
    private Advertiser advertiser;

    public Mini (JSONObject json) {
        text = json.getString ("Text");
        advertiser = new Advertiser (json.getString("Name"), json.getString("Address"));
    }

    public String getText() {
        return text;
    }

    public Advertiser getAdvertiser() {
        return advertiser;
    }

    public abstract double getPrice ();
}
