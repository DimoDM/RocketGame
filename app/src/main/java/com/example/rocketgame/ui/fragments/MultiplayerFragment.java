package com.example.rocketgame.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.rocketgame.R;
import com.example.rocketgame.core.contract.MultiplayerContract;
import com.example.rocketgame.databinding.FragmentMultiplayerBinding;

import javax.inject.Inject;

public class MultiplayerFragment
        extends BaseFragment<FragmentMultiplayerBinding, MultiplayerFragment.OnMultiplayerFragmentIterationListener>
        implements MultiplayerContract.ViewListener {

    @Inject
    MultiplayerContract.PresenterListener presenterListener;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_multiplayer;
    }

    @Override
    protected void onFragmentCreated(View view, Bundle savedInstanceState) {
        presenterListener.setViewListener(this);

        binding.btnHome.setOnClickListener(v -> presenterListener.onHomeButtonClicked());
        binding.btnCreate.setOnClickListener(v -> presenterListener.onCreateRoomButtonClicked());
        binding.btnJoin.setOnClickListener(v -> presenterListener.onJoinGameButtonClicked());
    }

    @Override
    public void goToMainScreen() {
        activityListener.goToMainScreen();
    }

    @Override
    public void goToEnterGameScreen() {
        activityListener.goToEnterGameScreen();
    }

    @Override
    public void createGameAndJoin() {
        activityListener.createGameAndJoin();
    }

    public interface OnMultiplayerFragmentIterationListener {
        void goToMainScreen();

        void goToEnterGameScreen();

        void createGameAndJoin();

    }
}
