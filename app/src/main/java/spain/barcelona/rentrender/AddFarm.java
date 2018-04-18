package spain.barcelona.rentrender;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class AddFarm extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_farm);
    }
    //Вызвать onSendMessage() при щелчке на кнопке
    public void onSendMessage(View view) {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }
}
