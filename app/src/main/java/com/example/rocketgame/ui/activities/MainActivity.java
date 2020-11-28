package com.example.rocketgame.ui.activities;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;

import com.example.rocketgame.R;
import com.example.rocketgame.di.DaggerApplicationComponent;
import com.example.rocketgame.ui.texture.GameView;
import com.google.firebase.database.FirebaseDatabase;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    FirebaseDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(getLayoutRes());
        DaggerApplicationComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewCreated() {
    }
}