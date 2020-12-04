package com.example.rocketgame.App.HelpClasses;

import android.app.Activity;
import android.net.SocketKeepalive;

import com.example.rocketgame.App.ECS.Components.BulletComponent;
import com.example.rocketgame.App.ECS.Components.HealthComponent;
import com.example.rocketgame.App.ECS.Components.TransformComponent;
import com.example.rocketgame.App.ECS.Entity;
import com.example.rocketgame.App.GameEngine;
import com.example.rocketgame.RocketGameApplication;
import com.example.rocketgame.core.contract.GameFragmentContract;
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
                GameEngine.GAMESTAGE = GameEngine.gameStages.stageDie;
            }
        }
    }
}
