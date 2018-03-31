package spain.barcelona.rentrender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
    }
    // При щелчке на кнопке
    public void onAboutUs(View view) {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }
    public void onAddFarm(View view) {
        Intent intent = new Intent(this, AddFarm.class);
        startActivity(intent);
    }
    public void onEditFarm(View view) {
        Intent intent = new Intent(this, EditFarm.class);
        startActivity(intent);
    }
    public void onContactUs(View view) {
        Intent intent = new Intent(this, Contact.class);
        startActivity(intent);
    }
    public void onAdvert(View view) {
        Intent intent = new Intent(this, Advert.class);
        startActivity(intent);
    }
    public void onFarmDetail(View view) {
        Intent intent = new Intent(this, FarmDetail.class);
        startActivity(intent);
    }
}
