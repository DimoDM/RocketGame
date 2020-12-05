package com.example.rocketgame.ui.activities;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.rocketgame.App.GameEngine;
import com.example.rocketgame.R;

import com.example.rocketgame.core.contract.PauseMenuFragmentContract;
import com.example.rocketgame.ui.fragments.GameFragment;
import com.example.rocketgame.ui.fragments.MainMenuFragment;

import com.example.rocketgame.ui.fragments.PauseMenuFragment;
import com.example.rocketgame.ui.texture.GameView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainMenuFragment.OnFragmentInteractionListener,
GameFragment.OnGameFragmentInteractionListener,
GameView.OnDieListener, PauseMenuFragment.OnPauseMenuFragmentInteractionListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(getLayoutRes());
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewCreated() {
        pushFragment(new MainMenuFragment(), MainMenuFragment.TAG, false);
    }


    private void pushFragment(Fragment fragment, String fragmentTag, boolean addToStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment, fragmentTag);
        if (addToStack) {
            fragmentTransaction.addToBackStack(fragmentTag);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void goToMenu() {
        pushFragment(new MainMenuFragment(), MainMenuFragment.TAG, false);
    }

    @Override
    public void startGame() {
        pushFragment(new GameFragment(), GameFragment.TAG, false);
    }

    @Override
    public void goToShop() {

    }

    @Override
    public void showClassation() {

    }

    @Override
    public void pauseGame() {
        pushFragment(new PauseMenuFragment(), PauseMenuFragment.TAG, false);
    }

    @Override
    public void goToMainMenu() {
        GameEngine.GAMESTAGE = GameEngine.gameStages.stageDie;
        pushFragment(new MainMenuFragment(), MainMenuFragment.TAG, false);
    }


    @Override
    public void goToGameFragment() {
        pushFragment(new GameFragment(), GameFragment.TAG, false);
    }

    @Override
    public void RestartGame() {
        GameEngine.GAMESTAGE = GameEngine.gameStages.stageRestart;
    }

}