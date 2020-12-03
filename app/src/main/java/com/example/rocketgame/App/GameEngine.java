package com.example.rocketgame.App;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.example.rocketgame.App.ECS.Components.AsteroidComponent;
import com.example.rocketgame.App.ECS.Components.AttackComponent;
import com.example.rocketgame.App.ECS.Components.HandleInput;
import com.example.rocketgame.App.ECS.Components.HealthComponent;
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

    public static Manager manager;
    public Entity player;

    public static final int SCREEN_WIDTH = Resources.getSystem().getDisplayMetrics().widthPixels;
    public static final int SCREEN_HEIGHT = Resources.getSystem().getDisplayMetrics().heightPixels;

    public enum groupLabels {
        groupPlayer,
        groupBullets,
        groupAsteroids
    }

    public GameEngine(){

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void init() {
        manager = new Manager();
        player = manager.addEntity();
        player.addGroup(groupLabels.groupPlayer.ordinal());
        player.addComponent(new TransformComponent(((SCREEN_WIDTH - 80)/2), (SCREEN_HEIGHT - 110), 80, 110));
        player.addComponent(new SpriteComponent(player.getComponent(new TransformComponent()), R.drawable.rocket, 110));
        player.addComponent(new HandleInput(player.getComponent(new TransformComponent())));
        player.addComponent(new AttackComponent(player.getComponent(new TransformComponent()), 20, 80));

        for (int i = 0; i < 3; i++) {
            Entity asteroid = manager.addEntity();
            asteroid.addComponent(new TransformComponent());
            asteroid.addComponent(new HealthComponent());
            asteroid.addComponent(new AsteroidComponent(asteroid.getComponent(new TransformComponent()), asteroid.getComponent(new HealthComponent())));
            asteroid.addComponent(new SpriteComponent(asteroid.getComponent(new TransformComponent()), R.drawable.asteroid, 110));
            asteroid.addGroup(groupLabels.groupAsteroids.ordinal());
        }

    }

    public void update() {
        manager.update();
    }

    public boolean handleInput(View v, MotionEvent e) {
        return player.getComponent(new HandleInput()).onTouch(v, e);
    }

    public void draw() {
        manager.draw();
    }
}
