package spain.barcelona.rentrender;

import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.LinearLayoutManager;
import android.content.Intent;
import android.util.Log;


public class FarmMaterialFragment extends Fragment {


    final String LOG_TAG = "myLogs";
    public static int farmCount;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView farmRecycler = (RecyclerView) inflater.inflate(
                R.layout.fragment_farm_material, container, false);


        // Узнаем сколько Имен ферм в БД; столько эментов будет в массиве
        // Запрос к БД чтобы узнать сколько "Имен" в столбце _id таблцы allFarmsTable




        /*RentrenderDBHelper rentrenderDBHelper = new RentrenderDBHelper(getActivity());*/
/*       SQLiteDatabase db = rentrenderDBHelper.getReadableDatabase();
        Cursor cCount = db.query("allFarmsTable",
                new String[]{"COUNT(_id) AS count"},
                null, null, null, null, null);
        if (cCount != null) {

            if (cCount.moveToFirst()) {
                int countColIndex = cCount.getColumnIndex
                        ("count");
                farmCount = cCount.getInt(countColIndex);
                Log.d(LOG_TAG, "--- DB row_COUNT =" + farmCount);
            }
            cCount.close();
            db.close();
        }
        String[] farmNames = new String[farmCount];*/
        /*String[] farmNames = new String[5];
        // Получить из БД все значения колонки Name это можно сделать в методе оnCreate
        SQLiteDatabase dba = rentrenderDBHelper.getReadableDatabase();
*//*        try {*//*
            Cursor c = dba.query("allFarmsTable",
                    new String[]{"_id", "name"},
                    null, null,
                    null, null, null);
            //Переход к первой записи в курсоре

//            if (c.moveToFirst()) {
        c.moveToFirst();
//Получение данных название фермы из курсора
                int idColIndex = c.getColumnIndex("_id");
                int nameColIndex = c.getColumnIndex("name");
                int idText = c.getInt(idColIndex);
                String nameText = c.getString(nameColIndex);
        Log.d(LOG_TAG,
                "---Сursor at first position " +" ID = " + idText +
                        ", name = " + nameText);
*/



//Заполнение масиива именами из курсора
                // a) создаем массив в колчеством элемнтов равным farmCount

                // б) каждому элементу массива присваиваем имя из стобца

/*
                Log.d(LOG_TAG,
                        "--- Answer from cursor " + "ID = " + idText +
                                ", name = " + nameText);
*/
/*                do {
//                    int a = 1;
//                    int pos = c.getInt(idColIndex) - a;
                    //farmNames[0] = c.getString(nameColIndex);
                    //farmNames[c.getInt(idColIndex)] = c.getString(nameColIndex);
                    Log.d(LOG_TAG,
                            "--- Answer from DB " + "ID = " + c.getInt(idColIndex) + ", name = " + c.getString(nameColIndex) + " array value = " +farmNames[c.getInt(idColIndex)] );*/

/*
                    farmNames[pos] = nameText;
                    Log.d(LOG_TAG,
                            "ID = " + idText +
                                    ", name = " + nameText);*/
                    // переход на следующую строку
                    // а если следующей нет (текущая - последняя), то false - выходим из цикла
               // } while (c.moveToNext());

/*        c.moveToNext();
        farmNames[c.getInt(idColIndex)] = c.getString(nameColIndex);
         Log.d(LOG_TAG,

                "--- Answer from cursor " + "ID = " + c.getInt(idColIndex) +
                        ", name = " + c.getString(nameColIndex) +farmNames[c.getInt(idColIndex)] );*/



/*                Log.d(LOG_TAG,
                        "---End do_while");
                c.close();
            }else
                Log.d(LOG_TAG, "0 rows");*/


/*        } catch (SQLiteException e) {

        }*/

        // Каждое значение из Name передать в массив
        // Вызвать массив в FarmMaterialFragment для передачи данных адаптеру


        String[] farmNames = new String[CardFarm.farms.length];
        for (int i = 0; i < farmNames.length; i++) {
            farmNames[i] = CardFarm.farms[i].getName();
        }

        String[] farmPrice = new String[CardFarm.farms.length];
        for (int i = 0; i < farmPrice.length; i++) {
            farmPrice[i] = CardFarm.farms[i].getPrice();
        }

        String[] farmPower = new String[CardFarm.farms.length];
        for (int i = 0; i < farmPower.length; i++) {
            farmPower[i] = CardFarm.farms[i].getPower();
        }

        int[] farmImages = new int[CardFarm.farms.length];
        for (int i = 0; i < farmImages.length; i++) {
            farmImages[i] = CardFarm.farms[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(farmNames, farmPrice, farmPower, farmImages);
        farmRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        farmRecycler.setLayoutManager(layoutManager);
        // Реализация метода onClick() интерфейса Listener запускает
        //активность PizzaDetailActivity, передавая ей идентификатор
        //пиццы, выбранной пользователем.
        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), FarmDetailActivity.class);
                intent.putExtra(FarmDetailActivity.EXTRA_FARMNO, position);
                getActivity().startActivity(intent);
            }
        });
        return farmRecycler;
    }
}