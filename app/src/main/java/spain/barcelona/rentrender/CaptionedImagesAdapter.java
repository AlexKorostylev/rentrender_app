package spain.barcelona.rentrender;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.drawable.Drawable;

class CaptionedImagesAdapter extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder> {

    private String[] name;
    public String[] price;
    public String[] power;
    private int[] imageIds;
    private Listener listener;

    public static interface Listener {
        public void onClick(int position);
    }

    // Активности и фрагменты используют этот метод для регистрации себя в качестве слушателя
    public void setListener(Listener listener){
        this.listener = listener;
    }

    //Предоставляет ссылку на представления, используемые в RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //Определение класса ViewHolder
        private CardView cardView;


        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }
    // Получение данных
    public CaptionedImagesAdapter(String[] name, String[] price, String[] power, int[] imageIds){
        this.name = name;
        this.price = price;
        this.power = power;
        this.imageIds = imageIds;
    }
    @Override
    public CaptionedImagesAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
//Создание нового представления
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_captioned_image, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
//Заполнение заданного представления данными
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView)cardView.findViewById(R.id.info_image);
        Drawable drawable = cardView.getResources().getDrawable(imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(name[position]);
        TextView textView = (TextView)cardView.findViewById(R.id.info_text);
        textView.setText(name[position]);
        TextView priceFarm = (TextView)cardView.findViewById(R.id.info_price);
        priceFarm.setText(price[position]);
        TextView powerFarm = (TextView)cardView.findViewById(R.id.info_power);
        powerFarm.setText(power[position]);
        // При щелчке на CardView вызвать
        //метод onClick() интерфейса Listener.
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
    //Возвращает количество вариантов в наборе данных
        return name.length;
    }
}
