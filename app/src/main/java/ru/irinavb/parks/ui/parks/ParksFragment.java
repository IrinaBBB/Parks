package ru.irinavb.parks.ui.parks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import ru.irinavb.parks.adapter.ParkRecyclerViewAdapter;
import ru.irinavb.parks.data.AsyncResponse;
import ru.irinavb.parks.data.Repository;
import ru.irinavb.parks.databinding.FragmentParksBinding;
import ru.irinavb.parks.model.Park;

public class ParksFragment extends Fragment {

    private FragmentParksBinding binding;
    private ParkRecyclerViewAdapter adapter;
    private List<Park> parkList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentParksBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.parkRecyclerView.setHasFixedSize(true);
        binding.parkRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.parkRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(),
                DividerItemDecoration.VERTICAL));
        Repository.getParks(new AsyncResponse() {
            @Override
            public void processPark(List<Park> parks) {
                adapter = new ParkRecyclerViewAdapter(parks);
                binding.parkRecyclerView.setAdapter(adapter);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}