package com.example.tastproject3.ui.household;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HouseholdViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public HouseholdViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}
