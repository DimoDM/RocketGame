package com.example.rocketgame.ui.fragments;

import android.os.Bundle;
import android.view.View;

import com.example.rocketgame.R;
import com.example.rocketgame.databinding.FragmentMultiplayerJoinBinding;

public class JoinMultiplayerFragment
extends BaseFragment<FragmentMultiplayerJoinBinding, JoinMultiplayerFragment.JoinMultiplayerFragmentIterationListener> {

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_multiplayer_join;
    }

    @Override
    protected void onFragmentCreated(View view, Bundle savedInstanceState) {

    }

    public interface JoinMultiplayerFragmentIterationListener{

    }
}
