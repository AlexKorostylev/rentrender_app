package spain.barcelona.rentrender;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ReadNewRF extends Activity {

    public static final String EXTRA_FARMNO = "farmNo";
    RentrenderDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_new_rf);

        //Получение номера фермы из интента
        int farmNo = (Integer)getIntent().getExtras().get(EXTRA_FARMNO);

        try {
            dbHelper = new RentrenderDBHelper(this);
            // подключаемся к БД
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            // делаем запрос всех данных из таблицы mytable, получаем Cursor*/
            Cursor c = db.query("AddNewRFtable", new String[]{"_id","url", "email", "comment"}, "_id = ?", new String[] {Integer.toString(farmNo)}, null, null, null);
            // ставим позицию курсора на первую строку выборки
            // если в выборке нет строк, вернется false
            if (c.moveToFirst()) {
                // определяем номера столбцов по имени в выборке
                int idColIndex = c.getColumnIndex("_id");
                int urlColIndex = c.getColumnIndex("url");
                int emailColIndex = c.getColumnIndex("email");
                int commentColIndex = c.getColumnIndex("comment");

                int id = c.getInt(idColIndex);
                String addid = Integer.toString(id);
                String url = c.getString(urlColIndex);
                String email = c.getString(emailColIndex);
                String comment = c.getString(commentColIndex);

                TextView addId = findViewById(R.id.addID);
                addId.setText(addid);
                TextView addURL = findViewById(R.id.addURL);
                addURL.setText(url);
                TextView addMail = findViewById(R.id.addMail);
                addMail.setText(email);
                TextView addComment = findViewById(R.id.addComment);
                addComment.setText(getString(R.string.tab) + comment);
            }
            c.close();
            db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
