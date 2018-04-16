package spain.barcelona.rentrender;

public class CardFarm {
    private String name;
    private int imageResourceId;

    public static final CardFarm[] farms = {
            new CardFarm("RebusFarm", R.drawable.classic_render_farm),
            new CardFarm("Sheepit! Render Farm", R.drawable.cloud_render_farm)
    };
    private CardFarm(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }
    public String getName() {
        return name;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }
}
