package com.example.rocketgame.App.ECS.Components;

import com.example.rocketgame.App.ECS.Component;
import com.example.rocketgame.App.GameEngine;
import com.example.rocketgame.App.UI.TextureManager;
import com.example.rocketgame.R;
import com.example.rocketgame.ui.texture.GameView;

public class BulletComponent extends Component {

    TransformComponent transform;
    SpriteComponent sprite;
    int bulletSpeed;

    public BulletComponent() {}

    public BulletComponent(TransformComponent transformComponent, int bulletSpeed) {
        transform = transformComponent;
        this.bulletSpeed = bulletSpeed;
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
        }
    }

    @Override
    public void draw() {
    }
}
