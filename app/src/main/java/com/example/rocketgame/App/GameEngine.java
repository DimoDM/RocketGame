package com.example.rocketgame.App;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

import com.example.rocketgame.App.ECS.Components.HandleInput;
import com.example.rocketgame.App.ECS.Components.SpriteComponent;
import com.example.rocketgame.App.ECS.Components.TransformComponent;
import com.example.rocketgame.App.ECS.Entity;
import com.example.rocketgame.App.ECS.Manager;
import com.example.rocketgame.App.UI.TextureManager;
import com.example.rocketgame.R;
import com.example.rocketgame.RocketGameApplication;
import com.example.rocketgame.ui.activities.MainActivity;
import com.example.rocketgame.ui.texture.GameView;


public class GameEngine{

    public Manager manager;
    public Entity player;

    public TextureManager texture;
    private static final int SCREEN_WIDTH = Resources.getSystem().getDisplayMetrics().widthPixels;
    private static final int SCREEN_HEIGHT = Resources.getSystem().getDisplayMetrics().heightPixels;

    public GameEngine(){
        texture = new TextureManager(R.drawable.sprite1, 123, 123, 123, 123);
    }

    public void init() {
        manager = new Manager();
        player = manager.addEntity();
        player.addComponent(new TransformComponent(((SCREEN_WIDTH - 150)/2), (SCREEN_HEIGHT - 150), 150, 150));
        player.addComponent(new SpriteComponent(player.getComponent(new TransformComponent()), R.drawable.sprite1, 150));
        player.addComponent(new HandleInput(player.getComponent(new TransformComponent())));
    }

    public void update() {
        manager.update();
    }

    public boolean handleInput(View v, MotionEvent e) {
        return player.getComponent(new HandleInput()).onTouch(v, e);
    }

    public void draw() {
        manager.draw();
        texture.draw();
    }
}
