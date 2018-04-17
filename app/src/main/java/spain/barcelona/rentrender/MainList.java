package spain.barcelona.rentrender;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.widget.DrawerLayout;
import android.widget.AdapterView;
import android.app.Fragment;
import android.app.FragmentTransaction;

public class MainList extends Activity {


    private String[] titles;
    private ListView drawerList;
    private DrawerLayout drawerLayout;

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Код, выполняемый при щелчке на элементе списка.
            //Code to run when an item in the navigation drawer gets clicked
            selectItem(position);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
        titles = getResources().getStringArray(R.array.titles);
        drawerList = (ListView) findViewById(R.id.drawer);
        // получение ссылки на DrawerLayout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_activated_1, titles));
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
        // При исходном создании MainActivity использовать метод selectItem()
        // для отображения TopFragment
        if (savedInstanceState == null) {
            selectItem(0);
        }
    }

    private void selectItem(int position) {
        Fragment fragment;
        switch(position) {
            case 1:
                // Определить, какой фрагмент должен отображаться
                fragment = new SoftFragment();
                break;
            case 2:
                fragment = new CountryFragment();
                break;
            case 3:
                fragment = new PriceFragment();
                break;
            default:
                fragment = new TopFragment();
        }
        // Вывести фрагмент с использованием транзакции фрагмента
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
        //Назначение заголовка панели действий (action bar).
        setActionBarTitle(position);
        //Закрыть выдвижную панель
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(drawerList);
    }
    private void setActionBarTitle(int position) {
        String title;
        if (position == 0){
            // Если пользователь выбирает вариант “Home”, в качестве
            //текста заголовка используется имя приложения.
            title = getResources().getString(R.string.app_name);
        } else {
            title = titles[position];
        }
        // Вывести заголовок на панели действий
        getActionBar().setTitle(title);
    }

}
