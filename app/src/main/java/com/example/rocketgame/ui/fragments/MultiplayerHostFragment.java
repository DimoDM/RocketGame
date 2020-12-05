package com.example.rocketgame.ui.fragments;

import android.os.Bundle;
import android.view.View;

import com.example.rocketgame.R;
import com.example.rocketgame.databinding.FragmentMultiplayerBinding;

public class MultiplayerHostFragment extends BaseFragment<FragmentMultiplayerBinding, MultiplayerHostFragment.OnMultiplayerHostFragmentIterationListener> {
    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_multiplayer_game_host;
    }

    @Override
    protected void onFragmentCreated(View view, Bundle savedInstanceState) {

    }

    public interface OnMultiplayerHostFragmentIterationListener{

    }
}
