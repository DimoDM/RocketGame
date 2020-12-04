package com.example.rocketgame.App.HelpClasses;

import com.example.rocketgame.App.ECS.Components.BulletComponent;
import com.example.rocketgame.App.ECS.Components.HealthComponent;
import com.example.rocketgame.App.ECS.Components.TransformComponent;
import com.example.rocketgame.App.ECS.Entity;
import com.example.rocketgame.App.GameEngine;

import java.util.List;

public class ColliderManager {

    public static void checkAttack(List<Entity> bullets, List<Entity> asteroids) {
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

            }
        }
    }
}
