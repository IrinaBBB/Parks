package ru.irinavb.parks.ui.details;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.irinavb.parks.R;
import ru.irinavb.parks.databinding.FragmentDetailsBinding;
import ru.irinavb.parks.databinding.FragmentParksBinding;

public class DetailsFragment extends Fragment {

    private FragmentDetailsBinding binding;

    public DetailsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }
}