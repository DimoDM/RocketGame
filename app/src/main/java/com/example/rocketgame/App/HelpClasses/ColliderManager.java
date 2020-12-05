package com.example.rocketgame.App.HelpClasses;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.SocketKeepalive;

import com.example.rocketgame.App.ECS.Components.BulletComponent;
import com.example.rocketgame.App.ECS.Components.HealthComponent;
import com.example.rocketgame.App.ECS.Components.ScoreComponent;
import com.example.rocketgame.App.ECS.Components.TransformComponent;
import com.example.rocketgame.App.ECS.Entity;
import com.example.rocketgame.App.GameEngine;
import com.example.rocketgame.RocketGameApplication;
import com.example.rocketgame.core.contract.GameFragmentContract;
import com.example.rocketgame.repository.FirebaseRepository;
import com.example.rocketgame.ui.activities.MainActivity;

import java.util.List;

import javax.inject.Inject;

public class ColliderManager {



    public void checkCollide(List<Entity> bullets, List<Entity> asteroids) {
        for (int j = 0; j < asteroids.size(); j++) {
            for (int i = 0; i < bullets.size(); i++) {
                if(Collide.AABB(
                        bullets.get(i).getComponent(new TransformComponent()).getPosition(),
                        asteroids.get(j).getComponent(new TransformComponent()).getPosition()
                )) {
                    GameEngine.manager.getGroup(GameEngine.groupLabels.groupBullets.ordinal()).get(i).getComponent(new BulletComponent()).destroy();
                    GameEngine.manager.getGroup(GameEngine.groupLabels.groupAsteroids.ordinal()).get(j).getComponent(new HealthComponent()).takeDamage(1);
                }
            }
            if(Collide.AABB(
                    asteroids.get(j).getComponent(new TransformComponent()).getPosition(),
                    GameEngine.manager.getGroup(GameEngine.groupLabels.groupPlayer.ordinal()).get(0).getComponent(new TransformComponent()).getPosition()
            )) {

                SharedPreferences sharedPreferences = RocketGameApplication.APP.getSharedPreferences(RocketGameApplication.MYPREFERENCE, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                int score = GameEngine.manager.getGroup(GameEngine.groupLabels.groupPlayer.ordinal()).get(0).getComponent(new ScoreComponent()).getScore();
                editor.putString(RocketGameApplication.LASTSCORE, score  + "" );
                editor.apply();
                FirebaseRepository.getInstance().updateHighScore(score);
                GameEngine.GAMESTAGE = GameEngine.gameStages.stageDie;
            }
        }
    }
}
