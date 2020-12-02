package com.example.rocketgame.App.ECS.Components;

import com.example.rocketgame.App.ECS.Component;
import com.example.rocketgame.App.GameEngine;
import com.example.rocketgame.App.UI.TextureManager;
import com.example.rocketgame.R;
import com.example.rocketgame.ui.texture.GameView;

public class BulletComponent extends Component {

    TransformComponent transform;
    int bulletSpeed;
    int attackSpeed;

    public BulletComponent() {}

    public BulletComponent(TransformComponent transformComponent, int bulletSpeed, int attackSpeed) {
        transform = transformComponent;
        this.bulletSpeed = bulletSpeed;
        this.attackSpeed = attackSpeed;
        transform.setVelY(-bulletSpeed);
    }

    @Override
    public void init() {
    }

    @Override
    public void update() {
        if(transform.getPosition().y < 0) {
            transform.setX(GameEngine.manager.getGroup(GameEngine.groupLabels.groupPlayer.ordinal()).get(0).getComponent(new TransformComponent()).getPosition().x);
            transform.setY(GameEngine.SCREEN_HEIGHT);
            stop();
        }
    }

    @Override
    public void draw() {
    }

    public void stop() {
        transform.setVelY(0);
    }

    public boolean isStopped() {
        return transform.getVelY() == 0;
    }

    public void start() {
        transform.setVelY(-bulletSpeed);
    }
}
