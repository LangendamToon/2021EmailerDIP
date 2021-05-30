import processor.MiniProcessorAD;
import processor.MiniProcessorTrouw;
import receiver.MarktplaatsReceiver;

public class Main {

    public static void main(String[] args) {
        MarktplaatsReceiver receiver = new MarktplaatsReceiver ();
        new MiniProcessorTrouw(receiver);
        new MiniProcessorAD(receiver);
        receiver.publishMini ("{ 'Name' : 'Karel J. van der Lelij', " +
                              "  'Address' : 'Den Haag', " +
                              "  'Text' : 'Deze tekst moet worden geplaatst in Trouw en AD'," +
                              "  'Titles' : [ 'Trouw', 'AD' ] }");

        receiver.publishMini ("{ 'Name' : 'Karel J. van der Lelij', " +
                              "  'Address' : 'Den Haag', " +
                              "  'Text' : 'Deze tekst moet worden geplaatst in Trouw'," +
                              "  'Titles' : [ 'Trouw' ] }");
    }

}
