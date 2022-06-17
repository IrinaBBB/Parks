package ru.irinavb.parks.ui.map;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import ru.irinavb.parks.R;
import ru.irinavb.parks.data.AsyncResponse;
import ru.irinavb.parks.data.Repository;
import ru.irinavb.parks.model.Park;
import ru.irinavb.parks.viewmodel.ParkViewModel;

public class MapsFragment extends Fragment {

    private ParkViewModel viewModel;
    private List<Park> parkList;

    private final OnMapReadyCallback callback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            parkList = new ArrayList<>();
            parkList.clear();

            Repository.getParks(parks ->  {
                parkList = parks;
                    LatLng middle = new LatLng(Double.parseDouble(parks.get(0).getLatitude()),
                            Double.parseDouble(parks.get(0).getLongitude()));
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(middle, 4));
                    for (Park park : parks) {
                        Log.d("TAG", "processPark: " + park.getLatitude());
                        LatLng parkLatLong = new LatLng(Double.parseDouble(park.getLatitude()),
                                Double.parseDouble(park.getLongitude()));
                        googleMap.addMarker(new MarkerOptions().position(parkLatLong).title(park.getFullName()));
                    }
                viewModel.setSelectedParks(parkList);
            });
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(ParkViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}