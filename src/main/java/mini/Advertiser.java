package mini;

public class Advertiser {

    private String name;
    private String address;

    public Advertiser (String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName () {
        return name;
    }

    public String getAddress () {
        return address;
    }
}