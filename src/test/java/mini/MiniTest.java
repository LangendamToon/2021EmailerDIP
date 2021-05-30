package mini;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiniTest {

    @Test
    /*
     * Deze test is gebaseerd op de volgende equivalentieklassen (intensief getest met randwaarden):
     *
     * - 0 < tekstlengte < 25: € 5,00
     * - 25 <= tekstlengte < 100: € 0,20/karakter
     * - tekstlengte >= 100: € 0,18/karakter
     */
    void getPrice() {

        String advertiser = "'Name' : 'Karel J. van der Lelij', 'Address' : 'Den Haag'";
        String tekst0 = "{" + advertiser + ", 'Text' : '' }";
        String tekst1 = "{" + advertiser + ", 'Text' : '1' }";
        String tekst24 = "{" + advertiser + ", 'Text' : 'Test Test Test Test Test' }";
        String tekst25 = "{" + advertiser + ", 'Text' : 'Test Test Test Test Test' }";
        String tekst26 = "{" + advertiser + ", 'Text' : 'Test Test Test Test Test T' }";
        String tekst99 = "{" + advertiser + ", 'Text' : 'Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test' }";
        String tekst100 = "{" + advertiser + ", 'Text' : 'Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test ' }";
        String tekst101 = "{" + advertiser + ", 'Text' : 'Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test Test T' }";

        assertEquals (0.0, new MiniTrouw(new JSONObject (tekst0)).getPrice (), 0.001);
        assertEquals (5.0, new MiniTrouw (new JSONObject (tekst1)).getPrice (), 0.001);
        assertEquals (5.0, new MiniTrouw (new JSONObject (tekst24)).getPrice (), 0.001);
        assertEquals (5.0, new MiniTrouw (new JSONObject (tekst25)).getPrice (), 0.001);
        assertEquals (5.2, new MiniTrouw (new JSONObject (tekst26)).getPrice (), 0.001);
        assertEquals (19.8, new MiniTrouw (new JSONObject (tekst99)).getPrice (), 0.001);
        assertEquals (18.0, new MiniTrouw (new JSONObject (tekst100)).getPrice (), 0.001);
        assertEquals (18.18, new MiniTrouw (new JSONObject (tekst101)).getPrice (), 0.001);
    }
}