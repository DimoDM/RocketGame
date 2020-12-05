package com.example.rocketgame.ui.fragments;

import android.os.Bundle;
import android.view.View;

import com.example.rocketgame.App.GameEngine;
import com.example.rocketgame.R;
import com.example.rocketgame.core.contract.GameFragmentContract;
import com.example.rocketgame.core.contract.PauseMenuFragmentContract;
import com.example.rocketgame.databinding.FragmentPauseMenuBinding;

import javax.inject.Inject;

public class PauseMenuFragment extends BaseFragment<FragmentPauseMenuBinding, PauseMenuFragment.OnPauseMenuFragmentInteractionListener>
implements PauseMenuFragmentContract.ViewListener{

    @Inject
    PauseMenuFragmentContract.PresentListener presentListener;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_pause_menu;
    }

    @Override
    protected void onFragmentCreated(View view, Bundle savedInstanceState) {
        presentListener.setViewListener(this);
        GameEngine.GAMESTAGE = GameEngine.gameStages.stagePause;
        binding.btnMainMenu.setOnClickListener(v -> presentListener.onMenuBtnClicked());
        binding.btnContinue.setOnClickListener(v -> presentListener.onContinueBtnClicked());
        binding.btnRestart.setOnClickListener(v -> presentListener.onRestartBtnClicked());
    }

    @Override
    public void goToMainMenu() {
        activityListener.goToMainMenu();
    }

    @Override
    public void goToGameFragment() {
        activityListener.goToGameFragment();
    }

    @Override
    public void RestartGame() {
        activityListener.RestartGame();
    }

    public interface OnPauseMenuFragmentInteractionListener {

        void goToMainMenu();
        void goToGameFragment();
        void RestartGame();
    }
}
