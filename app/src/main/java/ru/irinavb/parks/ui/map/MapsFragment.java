package ru.irinavb.parks.ui.map;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import ru.irinavb.parks.R;
import ru.irinavb.parks.data.AsyncResponse;
import ru.irinavb.parks.data.Repository;
import ru.irinavb.parks.model.Park;

public class MapsFragment extends Fragment {

    private final OnMapReadyCallback callback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            Repository.getParks(new AsyncResponse() {
                @Override
                public void processPark(List<Park> parks) {
                    // LatLng middle = new LatLng(39.50, -98.35);
                    LatLng middle = new LatLng(Double.parseDouble(parks.get(0).getLatitude()),
                            Double.parseDouble(parks.get(0).getLongitude()));
                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(middle));
                    for (Park park : parks) {
                        Log.d("TAG", "processPark: " + park.getLatitude());
                        LatLng parkLatLong = new LatLng(Double.parseDouble(park.getLatitude()),
                                Double.parseDouble(park.getLongitude()));
                        googleMap.addMarker(new MarkerOptions().position(parkLatLong).title(park.getFullName()));
                    }
                }
            });
        }
    };

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