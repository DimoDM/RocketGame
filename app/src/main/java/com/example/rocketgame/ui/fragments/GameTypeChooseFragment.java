package com.example.rocketgame.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rocketgame.R;
import com.example.rocketgame.databinding.FragmentGameTypeChooseBinding;

public class GameTypeChooseFragment extends BaseFragment<FragmentGameTypeChooseBinding, GameTypeChooseFragment.OnGameTypeChooseFragmentContractIterationListener> {

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_game_type_choose;
    }

    @Override
    protected void onFragmentCreated(View view, Bundle savedInstanceState) {

    }

    public interface OnGameTypeChooseFragmentContractIterationListener{

    }
}