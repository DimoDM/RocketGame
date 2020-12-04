package com.example.rocketgame.App.ECS.Components;

import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.example.rocketgame.App.ECS.Component;
import com.example.rocketgame.R;
import com.example.rocketgame.RocketGameApplication;
import com.example.rocketgame.ui.activities.MainActivity;

import java.util.zip.Inflater;

public class HandleInput extends Component implements SurfaceView.OnTouchListener{

    private TransformComponent transform;

    public HandleInput(){}

    public HandleInput(TransformComponent transformComponent) {
        transform = transformComponent;
    }

    @Override
    public void init() { }

    @Override
    public void update() { }

    @Override
    public void draw() { }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        transform.setX((int)event.getRawX() - (transform.getPosition().width / 2));
        return true;
    }
}
