package spain.barcelona.rentrender;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.LinearLayoutManager;
import android.content.Intent;

public class FarmMaterialFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView farmRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_farm_material, container, false);

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