package com.example.rocketgame.ui.fragments;

import android.app.Application;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.rocketgame.R;
import com.example.rocketgame.RocketGameApplication;
import com.example.rocketgame.core.contract.ClassationFragmentContract;
import com.example.rocketgame.core.contract.GameFragmentContract;
import com.example.rocketgame.databinding.FrgmentClassationBinding;
import com.example.rocketgame.ui.adapter.ClassationAdapter;

import javax.inject.Inject;
public class ClassationFragment extends BaseFragment<FrgmentClassationBinding, ClassationFragment.OnClassationFragmentInteractionListener>
implements ClassationFragmentContract.ViewListener{

    @Inject
    ClassationFragmentContract.PresentListener presentListener;

    @Override
    protected int getLayoutRes() {
        return R.layout.frgment_classation;
    }

    @Override
    protected void onFragmentCreated(View view, Bundle savedInstanceState) {
        presentListener.setViewListener(this);
        binding.resView.setLayoutManager(new LinearLayoutManager(RocketGameApplication.APP.getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        ClassationAdapter adapter = new ClassationAdapter();
        binding.resView.setAdapter(adapter);
        binding.backToMenu.setOnClickListener(v -> presentListener.onHomeBtnClicked());
    }

    @Override
    public void goToMainMenu() {
        activityListener.goToMainMenu();
    }

    public interface OnClassationFragmentInteractionListener {

        void goToMainMenu();
    }
}
