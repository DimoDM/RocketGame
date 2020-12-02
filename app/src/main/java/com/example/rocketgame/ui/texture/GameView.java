package com.example.rocketgame.ui.texture;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.example.rocketgame.App.GameEngine;
import com.example.rocketgame.R;

//import androidx.annotation.MainThread;


public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private GameEngine gameEngine;


    public GameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);

        setFocusable(true);

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return super.onTouchEvent(event);
    }

    public void Move() {
        this.setOnTouchListener((v, event) -> {
            return gameEngine.handleInput(v, event);
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        gameEngine = new GameEngine();
        gameEngine.init();

        thread.setRunning(true);
        thread.start();

    }


    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    public void update() {
        gameEngine.update();

    }

    @Override
    public void draw(Canvas canvas) {

        super.draw(canvas);
        if (canvas != null) {
            gameEngine.draw();
        }
    }



}
