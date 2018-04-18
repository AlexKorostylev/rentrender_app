package spain.barcelona.rentrender;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FarmDetailActivity extends Activity {

    public static final String EXTRA_FARMNO = "farmNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_detail);

        //Включение кнопки Вверх
        getActionBar().setDisplayHomeAsUpEnabled(true);

        //Вывод подробной информации о пицце
        int farmNo = (Integer)getIntent().getExtras().get(EXTRA_FARMNO);
        String farmName = CardFarm.farms[farmNo].getName();
        TextView textView = (TextView)findViewById(R.id.farm_text_name);
        textView.setText(farmName);
    }
}
