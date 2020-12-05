package com.example.rocketgame.ui.fragments;

import android.os.Bundle;
import android.view.View;

import com.example.rocketgame.R;
import com.example.rocketgame.core.contract.MultiplayerHostFragmentContract;
import com.example.rocketgame.databinding.FragmentMultiplayerGameHostBinding;

import javax.inject.Inject;

public class MultiplayerHostFragment extends BaseFragment<FragmentMultiplayerGameHostBinding, MultiplayerHostFragment.OnMultiplayerHostFragmentIterationListener>
implements MultiplayerHostFragmentContract.ViewListener {

    @Inject
    MultiplayerHostFragmentContract.PresentListener presentListener;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_multiplayer_game_host;
    }

    @Override
    protected void onFragmentCreated(View view, Bundle savedInstanceState) {
        presentListener.setViewListener(this);
        binding.btnHome.setOnClickListener(v -> presentListener.onHomeButtonClicked());
        binding.btnReadyUnready.setOnClickListener(v -> presentListener.onReadyUnradyButtonClicked());
        binding.imageButton.setOnClickListener(v-> presentListener.onSwitchViewButtonClicked());
    }

    @Override
    public void goToMainMenu() {
        activityListener.goToMainMenu();
    }

    @Override
    public void switchView() {
        activityListener.switchView();
    }

    @Override
    public void setReady() {
        activityListener.setReady();
    }


    public interface OnMultiplayerHostFragmentIterationListener{
        void goToMainMenu();
        void switchView();
        void setReady();
    }
}
