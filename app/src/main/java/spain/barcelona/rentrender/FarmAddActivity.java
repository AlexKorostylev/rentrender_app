package spain.barcelona.rentrender;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FarmAddActivity extends Activity implements View.OnClickListener {

    final String LOG_TAG = "myLogs";
    Button btnAdd;
    EditText fName, fType, fURL, fCountry, fEmail, fSupport, fUpdate, fPower, fNode, fCPUnode, fCPU, fCores, fRAM, fUpload, fDownload, fPay, fPrice, fDiscount, fMore;
    SQLiteOpenHelper rentrenderDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_farm);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        fName = findViewById(R.id.fName);
        fType = findViewById(R.id.fType);
        fURL = findViewById(R.id.fURL);
        fCountry = findViewById(R.id.fCountry);
        fEmail = findViewById(R.id.fEmail);
        fSupport = findViewById(R.id.fSupport);
        fUpdate = findViewById(R.id.fUpdate);
        fPower = findViewById(R.id.fPower);
        fNode = findViewById(R.id.fNode);
        fCPUnode = findViewById(R.id.fCPUnode);
        fCPU = findViewById(R.id.fCPU);
        fCores = findViewById(R.id.fCores);
        fRAM = findViewById(R.id.fRAM);
        fUpload = findViewById(R.id.fUpload);
        fDownload = findViewById(R.id.fDownload);
        fPay = findViewById(R.id.fPay);
        fPrice = findViewById(R.id.fPrice);
        fDiscount = findViewById(R.id.fDiscount);
        fMore = findViewById(R.id.fMore);

        rentrenderDBHelper = new RentrenderDBHelper(this);
    }

    @Override
    public void onClick(View v) {

        // создаем объект для данных
        ContentValues cv = new ContentValues();

        // получаем данные из полей ввода
        String name = fName.getText().toString();
        String type = fType.getText().toString();
        String url = fURL.getText().toString();
        String country = fCountry.getText().toString();
        String email = fEmail.getText().toString();
        String support = fSupport.getText().toString();
        String update = fUpload.getText().toString();
        String power = fPower.getText().toString();
        String node = fNode.getText().toString();
        String cpu_node = fCPUnode.getText().toString();
        String cpu = fCPU.getText().toString();
        String cores = fCores.getText().toString();
        String ram = fRAM.getText().toString();
        String upload = fUpload.getText().toString();
        String download = fDownload.getText().toString();
        String pay = fPay.getText().toString();
        String price = fPrice.getText().toString();
        String discount = fDiscount.getText().toString();
        String more = fMore.getText().toString();

        // подключаемся к БД
        SQLiteDatabase db = rentrenderDBHelper.getWritableDatabase();

        switch (v.getId()) {
            case R.id.btnAdd:
                Log.d(LOG_TAG, "--- Insert data to DB: ---");
                // подготовим данные для вставки в виде пар: наименование столбца - значение
                cv.put("name", name);
                cv.put("type", type);
                cv.put("url", url);
                cv.put("country", country);
                cv.put("email", email);
                cv.put("support_inf", support);
                cv.put("update_date", update);

                cv.put("power", power);
                cv.put("node", node);
                cv.put("cpu_per_node", cpu_node);
                cv.put("cpu_description", cpu);
                cv.put("core_per_node", cores);
                cv.put("ram_per_node", ram);
                cv.put("upload_options", upload);
                cv.put("download_options", download);

                cv.put("price", price);
                cv.put("payment_options", pay);
                cv.put("discount_options", discount);

                cv.put("more_detail", more);

                // вставляем запись и получаем ее ID
                long rowID = db.insert("allFarmsTable", null, cv);
                Log.d(LOG_TAG, "row inserted, ID = " + rowID);

                // Переходим к другой активности
                Intent intent = new Intent(this, FarmDetailActivity.class);
                startActivity(intent);
                break;
        }
        // закрываем подключение к БД
        db.close();
    }
}
