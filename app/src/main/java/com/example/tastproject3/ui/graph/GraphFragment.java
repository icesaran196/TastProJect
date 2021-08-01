package com.example.tastproject3.ui.graph;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tastproject3.R;
import com.example.tastproject3.databinding.FragmentGraphBinding;
import com.example.tastproject3.ui.graph.GraphViewModel;

public class GraphFragment extends Fragment {

    private GraphViewModel graphViewModel;
    private FragmentGraphBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        graphViewModel =
                new ViewModelProvider(this).get(GraphViewModel.class);

        binding = FragmentGraphBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGraph;
        graphViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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