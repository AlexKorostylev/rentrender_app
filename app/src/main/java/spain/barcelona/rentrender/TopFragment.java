package spain.barcelona.rentrender;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.LinearLayoutManager;

public class TopFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView farmRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_farm_material, container, false);

        String[] farmNames = new String[CardFarm.farms.length];
        for (int i = 0; i < farmNames.length; i++) {
            farmNames[i] = CardFarm.farms[i].getName();
        }
        int[] farmImages = new int[CardFarm.farms.length];
        for (int i = 0; i < farmImages.length; i++) {
            farmImages[i] = CardFarm.farms[i].getImageResourceId();
        }
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(farmNames, farmImages);
        farmRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        farmRecycler.setLayoutManager(layoutManager);
        return farmRecycler;
    }
}