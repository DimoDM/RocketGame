package com.example.rocketgame.App.HelpClasses;

import com.example.rocketgame.App.ECS.Components.BulletComponent;
import com.example.rocketgame.App.ECS.Components.HealthComponent;
import com.example.rocketgame.App.ECS.Components.TransformComponent;
import com.example.rocketgame.App.GameEngine;

public class ColliderManager {

    public static void checkAttack() {
        for (int i = 0; i < GameEngine.manager.getGroup(GameEngine.groupLabels.groupBullets.ordinal()).size(); i++) {
            for (int j = 0; j < GameEngine.manager.getGroup(GameEngine.groupLabels.groupAsteroids.ordinal()).size(); j++) {
                if(Collide.AABB(
                        GameEngine.manager.getGroup(GameEngine.groupLabels.groupBullets.ordinal()).get(i).getComponent(new TransformComponent()).getPosition(),
                        GameEngine.manager.getGroup(GameEngine.groupLabels.groupAsteroids.ordinal()).get(j).getComponent(new TransformComponent()).getPosition()
                )) {
                    GameEngine.manager.getGroup(GameEngine.groupLabels.groupBullets.ordinal()).get(i).getComponent(new BulletComponent()).destroy();
                    GameEngine.manager.getGroup(GameEngine.groupLabels.groupAsteroids.ordinal()).get(j).getComponent(new HealthComponent()).takeDamage(1);
                }
            }
        }
    }
}
