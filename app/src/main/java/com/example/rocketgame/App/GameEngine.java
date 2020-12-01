package com.example.rocketgame.App;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import com.example.rocketgame.App.UI.TextureManager;
import com.example.rocketgame.R;
import com.example.rocketgame.RocketGameApplication;
import com.example.rocketgame.ui.activities.MainActivity;
import com.example.rocketgame.ui.texture.GameView;


public class GameEngine{

    TextureManager texture;

    public GameEngine(){
        texture = new TextureManager(R.drawable.sprite1, 123, 123, 123, 123);
    }

    public void update(){}

    public void draw(Canvas canvas) {
        texture.draw(canvas);
    }
}
