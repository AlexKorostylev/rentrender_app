package spain.barcelona.rentrender;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class FarmDetailActivity extends Activity {

    public static final String EXTRA_FARMNO = "farmNo";
    RentrenderDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_detail);

        //Получение номера фермы из интента
        int farmNo = (Integer)getIntent().getExtras().get(EXTRA_FARMNO);

        try {
            dbHelper = new RentrenderDBHelper(this);
            // подключаемся к БД
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            // делаем запрос всех данных из таблицы allFarmsTable, получаем Cursor*/
            Cursor c = db.query("allFarmsTable", new String[]{"_id","name", "type","url", "country","email", "support_inf", "update_date", "power", "node", "cpu_per_node", "cpu_description", "core_per_node", "ram_per_node", "upload_options", "download_options", "price", "payment_options", "discount_options", "more_detail"}, "_id = ?", new String[] {Integer.toString(farmNo)}, null, null, null);
            // ставим позицию курсора на первую строку выборки
            // если в выборке нет строк, вернется false
            if (c.moveToFirst()) {
                // определяем номера столбцов по имени в выборке
                // int idColIndex = c.getColumnIndex("_id");
                int nameColIndex = c.getColumnIndex("name");
                int typeColIndex = c.getColumnIndex("type");
                int urlColIndex = c.getColumnIndex("url");
                int countryColIndex = c.getColumnIndex("country");
                int emailColIndex = c.getColumnIndex("email");
                int support_infColIndex = c.getColumnIndex("support_inf");
                int update_dateColIndex = c.getColumnIndex("update_date");
                int powerColIndex = c.getColumnIndex("power");
                int nodeColIndex = c.getColumnIndex("node");
                int cpu_per_nodeColIndex = c.getColumnIndex("cpu_per_node");
                int cpu_descriptionColIndex = c.getColumnIndex("cpu_description");
                int core_per_nodeColIndex = c.getColumnIndex("core_per_node");
                int ram_per_nodeColIndex = c.getColumnIndex("ram_per_node");
                int upload_optionsColIndex = c.getColumnIndex("upload_options");
                int download_optionsColIndex = c.getColumnIndex("download_options");
                int priceColIndex = c.getColumnIndex("price");
                int payment_optionsColIndex = c.getColumnIndex("payment_options");
                int discount_optionsColIndex = c.getColumnIndex("discount_options");
                int more_detailColIndex = c.getColumnIndex("more_detail");

                // int id = c.getInt(idColIndex);
                // String addid = Integer.toString(id);
                String name = c.getString(nameColIndex);
                String type = c.getString(typeColIndex);
                String url = c.getString(urlColIndex);
                String country = c.getString(countryColIndex);
                String email = c.getString(emailColIndex);
                String support = c.getString(support_infColIndex);
                String update = c.getString(update_dateColIndex);
                String power = c.getString(powerColIndex);
                String node = c.getString(nodeColIndex);
                String cpuPerNode = c.getString(cpu_per_nodeColIndex);
                String cpuDescription = c.getString(cpu_descriptionColIndex);
                String corePerNode = c.getString(core_per_nodeColIndex);
                String ramPerNode = c.getString(ram_per_nodeColIndex);
                String upload = c.getString(upload_optionsColIndex);
                String download = c.getString(download_optionsColIndex);
                String price = c.getString(priceColIndex);
                String payment = c.getString(payment_optionsColIndex);
                String discount = c.getString(discount_optionsColIndex);
                String more = c.getString(more_detailColIndex);

                // Вставка значение в макет (layout)
                TextView addName = findViewById(R.id.rfName);
                addName.setText(name);
                TextView addType = findViewById(R.id.rfType);
                addType.setText(type);
                TextView addURL = findViewById(R.id.rfURL);
                addURL.setText(url);
                TextView addCountry = findViewById(R.id.rfCountry);
                addCountry.setText(country);
                TextView addEmail = findViewById(R.id.rfEmail);
                addEmail.setText(email);
                TextView addSupport = findViewById(R.id.rfSupport);
                addSupport.setText(support);
                TextView addUpdate = findViewById(R.id.rfUpdate);
                addUpdate.setText(update);
                TextView addPower = findViewById(R.id.rfPower);
                addPower.setText(power);
                TextView addNode = findViewById(R.id.rfNode);
                addNode.setText(node);
                TextView addCpuPerNode = findViewById(R.id.rfCpuPerNode);
                addCpuPerNode.setText(cpuPerNode);
                TextView addCpuDescription = findViewById(R.id.rfCpuDescription);
                addCpuDescription.setText(cpuDescription);
                TextView addCorePerNode = findViewById(R.id.rfCorePerNode);
                addCorePerNode.setText(corePerNode);
                TextView addRamPerNode = findViewById(R.id.rfRamPerNode);
                addRamPerNode.setText(ramPerNode);
                TextView addUpload = findViewById(R.id.rfUpload);
                addUpload.setText(upload);
                TextView addDownload = findViewById(R.id.rfDownload);
                addDownload.setText(download);
                TextView addPrice = findViewById(R.id.rfPrice);
                addPrice.setText(price);
                TextView addPayment = findViewById(R.id.rfPayment);
                addPayment.setText(payment);
                TextView addDiscount = findViewById(R.id.rfDiscount);
                addDiscount.setText(discount);
                TextView addMore = findViewById(R.id.rfMore);
                addMore.setText(more);
            }
            c.close();
            db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }

        //Включение кнопки Вверх
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
