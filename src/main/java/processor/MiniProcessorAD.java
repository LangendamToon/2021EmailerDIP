package processor;

import ISender.ISender;
import mini.MiniAD;
import org.json.JSONObject;

import receiver.MarktplaatsReceiver;
import mini.Mini;
import sender.Emailer;
import sender.EmailerAD;

public class MiniProcessorAD extends MiniProcessor {

    public MiniProcessorAD (MarktplaatsReceiver receiver) {
        super (receiver);
    }

    @Override
    protected String getName () {
        return "AD";
    }

    @Override
    protected Mini getMini (JSONObject json) {
        return new MiniAD(json);
    }

    @Override
    protected ISender getSender () {
        return new EmailerAD();
    }
}
