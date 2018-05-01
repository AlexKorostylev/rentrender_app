package spain.barcelona.rentrender;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class RentrenderDBHelper extends SQLiteOpenHelper {

    public final String LOG_TAG = "myLogs";
    private static final String DB_NAME = "rentrenderDB"; // Имя базы данных
    private static final int DB_VERSION = 1; // Версия базы данных

    public RentrenderDBHelper(Context context) {
        // конструктор суперкласса
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "--- onCreate database ---");
        // создаем таблицу с полями
        db.execSQL("create table allFarmsTable ("
                + "_id integer primary key autoincrement,"
                + "name text,"
                + "type text,"
                + "url text,"
                + "country text,"
                + "email text,"
                + "support_inf text,"
                + "update_date text,"
                + "power text,"
                + "node text,"
                + "cpu_per_node text,"
                + "cpu_description text,"
                + "core_per_node text,"
                + "ram_per_node text,"
                + "upload_options text,"
                + "download_options text,"
                + "price text,"
                + "payment_options text,"
                + "discount_options text,"
                + "more_detail text" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
