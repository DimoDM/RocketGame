package com.example.rocketgame.ui.fragments;

import android.os.Bundle;
import android.view.View;

import com.example.rocketgame.R;
import com.example.rocketgame.databinding.FragmentSinglePlayerBinding;

public class GameFragment extends BaseFragment<FragmentSinglePlayerBinding, GameFragment.OnFragmentInteractionListener> {

    public static final String TAG = GameFragment.class.getSimpleName();

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_single_player;
    }

    @Override
    protected void onFragmentCreated(View view, Bundle savedInstanceState) {

    }

    public interface OnFragmentInteractionListener {

        void startGame();
        void goToShop();
        void showClassation();
    }
}
