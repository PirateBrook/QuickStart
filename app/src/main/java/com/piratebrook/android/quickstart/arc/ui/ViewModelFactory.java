package com.piratebrook.android.quickstart.arc.ui;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.piratebrook.android.quickstart.arc.UserDataSource;

/**
 * Factory for ViewModels
 */
public class ViewModelFactory implements ViewModelProvider.Factory {

    private final UserDataSource mDataSource;

    public ViewModelFactory(UserDataSource mDataSource) {
        this.mDataSource = mDataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(UserViewModel.class)) {
            return (T) new UserViewModel(mDataSource);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
