package spain.barcelona.rentrender;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


public class NewFarmCategory extends ListActivity {

    RentrenderDBHelper dbHelper;
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listNewRF = getListView();

        try {
            dbHelper = new RentrenderDBHelper(this);
            // Подключаемся к БД. Получить ссылку на базу данных.
            db = dbHelper.getReadableDatabase();
            // Создать курсор.
            cursor = db.query("AddNewRFtable",
                    new String[]{"_id", "url"},
                    null, null, null, null, null);
            // Создать адаптер курсора.
            CursorAdapter listAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[]{"url"},
                    new int[]{android.R.id.text1},
                    0);
            // Связь списка и адавтера
            listNewRF.setAdapter(listAdapter);

        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }

    @Override
    public void onListItemClick(ListView listView,
                                View itemView,
                                int position,
                                long id) {
        Intent intent = new Intent(NewFarmCategory.this, ReadNewRF.class);
        intent.putExtra(ReadNewRF.EXTRA_FARMNO, (int) id);
        startActivity(intent);
    }
}
