package com.example.rocketgame.ui.fragments;

import android.os.Bundle;
import android.view.View;

import com.example.rocketgame.App.GameEngine;
import com.example.rocketgame.R;
import com.example.rocketgame.core.contract.GameFragmentContract;
import com.example.rocketgame.databinding.FragmentSinglePlayerBinding;

import javax.inject.Inject;

public class GameFragment extends BaseFragment<FragmentSinglePlayerBinding, GameFragment.OnGameFragmentInteractionListener>
implements GameFragmentContract.ViewListener {

    public static final String TAG = GameFragment.class.getSimpleName();


    @Inject
    GameFragmentContract.PresentListener presentListener;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_single_player;
    }

    @Override
    protected void onFragmentCreated(View view, Bundle savedInstanceState) {
        presentListener.setViewListener(this);
        if(GameEngine.GAMESTAGE != GameEngine.gameStages.stageDie) GameEngine.GAMESTAGE = GameEngine.gameStages.stagePlay;
        else activityListener.pauseGame();
        System.out.println(GameEngine.GAMESTAGE);

        binding.pauseBtn.setOnClickListener(v -> presentListener.onPauseClicked());
        if(GameEngine.GAMESTAGE == GameEngine.gameStages.stageDie) binding.pauseBtn.performClick();
    }

    @Override
    public void goToPauseScreen() {
        activityListener.pauseGame();
    }

    public interface OnGameFragmentInteractionListener {

        void pauseGame();
    }
}
