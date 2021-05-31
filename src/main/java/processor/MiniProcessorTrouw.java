package processor;

import ISender.ISender;
import org.json.JSONObject;

import receiver.MarktplaatsReceiver;
import mini.*;
import sender.*;

public class MiniProcessorTrouw extends MiniProcessor {

    public MiniProcessorTrouw (MarktplaatsReceiver receiver) {
        super (receiver);
    }

    @Override
    protected String getName () {
        return "Trouw";
    }

    @Override
    public Mini getMini(JSONObject json) {
        return new MiniTrouw (json);
    }

    @Override
    public ISender getSender () {
        return new EmailerTrouw ();
    }
}
