package spain.barcelona.rentrender;

public class CardFarm {
    private int imageResourceId;
    private String name;
    private String power;
    private String price;

    public static final CardFarm[] farms = {
            new CardFarm(R.drawable.classic_farm,"RebusFarm", "0.003 per Ghz.H","5 THz / 5,000 GHz" ),
            new CardFarm(R.drawable.cloud_farm,"Copernicus Computing", "$0.004/Ghz /hour","22 500 Ghz + 15 superfast GPU Supermicro server with 10 Ge-Force 10-80 Ti" ),
            new CardFarm(R.drawable.cloud_farm,"PeaRender", "<1$ per node per hour","more then 1000 GHz" ),
            new CardFarm(R.drawable.classic_farm,"Ypa", "<1$ per node per hour","more then 1000 GHz" ),
            new CardFarm(R.drawable.community_farm,"Felix online rendering", "price is 14 cent Euro x 320.000 pixel","500 render nodes total: 41THz / 41600 GHz + 51200 CUDA cores" )
    };

    private CardFarm(int imageResourceId, String name, String price, String power) {
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.power = power;
        this.price = price;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }
    public String getName() {
        return name;
    }
    public String getPower() {
        return power;
    }
    public String getPrice() {
        return price;
    }
}
