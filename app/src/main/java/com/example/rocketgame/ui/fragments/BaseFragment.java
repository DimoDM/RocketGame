package com.example.rocketgame.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;

public abstract class BaseFragment<T extends ViewDataBinding, L> extends DaggerFragment {

    public static final String TAG = BaseFragment.class.getSimpleName();

    protected T binding;
    protected L activityListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onFragmentCreated(view, savedInstanceState);
    }

    protected abstract int getLayoutRes();

    protected abstract void onFragmentCreated(View view, Bundle savedInstanceState);

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);

        try {
            activityListener = (L) context;
        } catch (ClassCastException e) {
            throw new RuntimeException(context.toString()
                    + " must implement the fragment listener.");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activityListener = null;
    }
}