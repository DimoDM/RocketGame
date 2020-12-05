package com.example.rocketgame.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rocketgame.R;
import com.example.rocketgame.core.contract.GameTypeChooseFragmentContract;
import com.example.rocketgame.core.contract.MainMenuFragmentContract;
import com.example.rocketgame.databinding.FragmentGameTypeChooseBinding;

import javax.inject.Inject;

public class GameTypeChooseFragment extends BaseFragment<FragmentGameTypeChooseBinding, GameTypeChooseFragment.OnGameTypeChooseFragmentContractIterationListener>
        implements GameTypeChooseFragmentContract.ViewListener {

    @Inject
    GameTypeChooseFragmentContract.PresentListener presentListener;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_game_type_choose;
    }

    @Override
    protected void onFragmentCreated(View view, Bundle savedInstanceState) {
        presentListener.setViewListener(this);
        binding.btnSingleplayer.setOnClickListener(v -> presentListener.onSinglePlayerBtnClicked());
        //binding.btnMultiplayer.setOnClickListener(v -> presentListener.onMultiplayerPlayerBtnClicked());
    }

    @Override
    public void goToSinglePlayerFragment() {
        activityListener.goToSinglePlayerFragment();
    }

    @Override
    public void goToMultiplayerPlayerFragment() {
        activityListener.goToMultiplayerPlayerFragment();
    }

    public interface OnGameTypeChooseFragmentContractIterationListener{
        void goToMultiplayerPlayerFragment();
        void goToSinglePlayerFragment();
    }
}