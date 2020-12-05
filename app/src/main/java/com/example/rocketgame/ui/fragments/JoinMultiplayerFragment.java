package com.example.rocketgame.ui.fragments;

import android.os.Bundle;
import android.view.View;

import com.example.rocketgame.R;
import com.example.rocketgame.core.contract.JoinMultiplayerFragmentContract;
import com.example.rocketgame.core.contract.MultiplayerFragmentContract;
import com.example.rocketgame.databinding.FragmentMultiplayerJoinBinding;

import javax.inject.Inject;

public class JoinMultiplayerFragment
extends BaseFragment<FragmentMultiplayerJoinBinding, JoinMultiplayerFragment.JoinMultiplayerFragmentIterationListener>
implements JoinMultiplayerFragmentContract.ViewListener{

    @Inject
    JoinMultiplayerFragmentContract.PresentListener presentListener;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_multiplayer_join;
    }

    @Override
    protected void onFragmentCreated(View view, Bundle savedInstanceState) {
        presentListener.setViewListener(this);
    }

    @Override
    public void joinMultiplayerWithQRCode() {
        activityListener.joinMultiplayerWithQRCode();
    }

    @Override
    public void joinMultiplayerWithManualCode() {
        activityListener.joinMultiplayerWithManualCode();
    }


    @Override
    public void goToMainScreen() {
        activityListener.goToMainScreen();
    }


    public interface JoinMultiplayerFragmentIterationListener{

        void goToMainScreen();
        void joinMultiplayerWithManualCode();
        void joinMultiplayerWithQRCode();

    }
}
