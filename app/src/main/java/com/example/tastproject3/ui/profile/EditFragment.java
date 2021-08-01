package com.example.tastproject3.ui.profile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tastproject3.databinding.FragmentEditBinding;
import com.example.tastproject3.ui.profile.EditViewModel;

public class EditFragment extends Fragment {

    private EditViewModel EditViewModel;
    private FragmentEditBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        EditViewModel =
                new ViewModelProvider(this).get(com.example.tastproject3.ui.profile.EditViewModel.class);

        binding = FragmentEditBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textEdit;
        EditViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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