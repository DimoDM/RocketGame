package com.example.rocketgame.ui.fragments;

import android.os.Bundle;
import android.view.View;

import com.example.rocketgame.R;
import com.example.rocketgame.core.contract.MainMenuFragmentContract;
import com.example.rocketgame.databinding.FragmentMainMenuBinding;

import javax.inject.Inject;

public class MainMenuFragment extends BaseFragment<FragmentMainMenuBinding, MainMenuFragment.OnFragmentInteractionListener>
implements MainMenuFragmentContract.ViewListener {

    public static final String TAG = MainMenuFragment.class.getSimpleName();

    @Inject
    MainMenuFragmentContract.PresentListener presentListener;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_main_menu;
    }

    @Override
    protected void onFragmentCreated(View view, Bundle savedInstanceState) {
        presentListener.setViewListener(this);

    }

    public interface OnFragmentInteractionListener {

    }
}
