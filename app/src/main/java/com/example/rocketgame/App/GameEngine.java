package com.example.rocketgame.App;

import android.content.res.Resources;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.example.rocketgame.App.ECS.Components.AsteroidComponent;
import com.example.rocketgame.App.ECS.Components.AttackComponent;
import com.example.rocketgame.App.ECS.Components.HandleInput;
import com.example.rocketgame.App.ECS.Components.HealthComponent;
import com.example.rocketgame.App.ECS.Components.ScoreComponent;
import com.example.rocketgame.App.ECS.Components.SpriteComponent;
import com.example.rocketgame.App.ECS.Components.TransformComponent;
import com.example.rocketgame.App.ECS.Entity;
import com.example.rocketgame.App.ECS.Manager;
import com.example.rocketgame.App.HelpClasses.ColliderManager;
import com.example.rocketgame.R;


public class GameEngine{

    public static Manager manager;
    public Entity player;
    public ColliderManager colliderManager;
    public static gameStages GAMESTAGE;

    public static final int SCREEN_WIDTH = Resources.getSystem().getDisplayMetrics().widthPixels;
    public static final int SCREEN_HEIGHT = Resources.getSystem().getDisplayMetrics().heightPixels;

    public enum groupLabels {
        groupPlayer,
        groupBullets,
        groupAsteroids
    }

    public enum gameStages {
        stagePlay,
        stagePause,
        stageDie,
        stageMenu,
        stageRestart,
        stageFlag
    }

    public GameEngine(){

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void init() {
        manager = new Manager();
        player = manager.addEntity();
        colliderManager = new ColliderManager();
        GAMESTAGE = gameStages.stageMenu;
        int playerWidth = SCREEN_WIDTH < 500 ? 80 : 160;
        int playerHeight = SCREEN_WIDTH < 500 ? 110 : 220;
        player.addGroup(groupLabels.groupPlayer.ordinal());
        player.addComponent(new TransformComponent(((SCREEN_WIDTH - playerWidth)/2), (SCREEN_HEIGHT - playerHeight), playerWidth, playerHeight));
        player.addComponent(new SpriteComponent(player.getComponent(new TransformComponent()), R.drawable.rocket, 110));
        player.addComponent(new HandleInput(player.getComponent(new TransformComponent())));
        player.addComponent(new AttackComponent(player.getComponent(new TransformComponent()), 20, 70));
        player.addComponent(new ScoreComponent());

        for (int i = 0; i < 15; i++) {
            Entity asteroid = manager.addEntity();
            asteroid.addComponent(new TransformComponent());
            asteroid.addComponent(new HealthComponent());
            asteroid.addComponent(new SpriteComponent());
            asteroid.addComponent(new AsteroidComponent(asteroid.getComponent(new TransformComponent()), asteroid.getComponent(new HealthComponent()), asteroid.getComponent(new SpriteComponent())));
            asteroid.addGroup(groupLabels.groupAsteroids.ordinal());
        }

    }

    public void update() {
        if(GAMESTAGE == gameStages.stagePlay && player != null && player.hasComponent(new HandleInput())) {
            manager.update();
            colliderManager.checkCollide(manager.getGroup(groupLabels.groupBullets.ordinal()), manager.getGroup(groupLabels.groupAsteroids.ordinal()));
        }
    }

    public boolean handleInput(View v, MotionEvent e) {
        return (player != null && player.hasComponent(new HandleInput())) ?
                player.getComponent(new HandleInput()).onTouch(v, e) : false;
    }

    public void draw() {
        manager.draw();
    }
}
