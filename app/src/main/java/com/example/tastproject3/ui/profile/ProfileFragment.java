package com.example.tastproject3.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tastproject3.R;
import com.example.tastproject3.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    private ProfileViewModel ProfileViewModel;
    private FragmentProfileBinding binding;
    private Button buttonEdit;


    public ProfileFragment(Button buttonEdit) {
        this.buttonEdit = buttonEdit;
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                            ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        buttonEdit = (Button)v.findViewById(R.id.buttonEdit);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit =new Intent(getActivity(),EditFragment.class);
                startActivity(edit);
            }
        });

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textProfile;
        ProfileViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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

    /*public void setButtonEdit( Button buttonEdit) {
        //buttonEdit = (Button)findViewById(R.id.buttonEdit);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit =new Intent(getActivity(),ProfileFragment.class);
                startActivity(edit);
            }
       });

    }*/
}