package com.example.tastproject3.ui.household;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tastproject3.R;
import com.example.tastproject3.databinding.FragmentHouseholdBinding;
import com.example.tastproject3.ui.household.HouseholdViewModel;

public class HouseholdFragment extends Fragment {

    private HouseholdViewModel HouseholdViewModel;
    private FragmentHouseholdBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       HouseholdViewModel =
                new ViewModelProvider(this).get(HouseholdViewModel.class);

        binding = FragmentHouseholdBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHousehold;
        HouseholdViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}