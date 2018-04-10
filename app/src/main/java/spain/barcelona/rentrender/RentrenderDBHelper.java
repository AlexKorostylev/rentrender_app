package spain.barcelona.rentrender;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class RentrenderDBHelper extends SQLiteOpenHelper {

    final String LOG_TAG = "myLogs";
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
        db.execSQL("create table AddNewRFtable ("
                + "_id integer primary key autoincrement,"
                + "url text,"
                + "email text,"
                + "comment text" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
