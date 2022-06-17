package ru.irinavb.parks.ui.parks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import ru.irinavb.parks.R;
import ru.irinavb.parks.adapter.OnParkClickListener;
import ru.irinavb.parks.adapter.ParkRecyclerViewAdapter;
import ru.irinavb.parks.data.Repository;
import ru.irinavb.parks.databinding.FragmentParksBinding;
import ru.irinavb.parks.model.Park;
import ru.irinavb.parks.viewmodel.ParkViewModel;

public class ParksFragment extends Fragment implements OnParkClickListener {

    private FragmentParksBinding binding;
    private ParkRecyclerViewAdapter adapter;
    private ParkViewModel viewModel;
    private List<Park> parkList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parkList = new ArrayList<>();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentParksBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(ParkViewModel.class);
        if (viewModel.getSelectedParks().getValue() != null) {
            parkList = viewModel.getSelectedParks().getValue();
        }
        binding.parkRecyclerView.setHasFixedSize(true);
        binding.parkRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.parkRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(),
                DividerItemDecoration.VERTICAL));
        adapter = new ParkRecyclerViewAdapter(parkList, this);
        binding.parkRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onParkClicked(View view, Park park) {
        viewModel.setSelectedPark(park);
        Navigation.findNavController(view).navigate(R.id.action_navigation_parks_to_navigation_details);
    }
}