package com.example.rocketgame.App.ECS.Components;

import com.example.rocketgame.App.ECS.Component;
import com.example.rocketgame.App.ECS.Entity;
import com.example.rocketgame.App.GameEngine;
import com.example.rocketgame.R;

public class AttackComponent extends Component {

    TransformComponent transform;
    int attackSpeed;
    int bulletSpeed;
    Entity bullet;


    public AttackComponent() {}

    public AttackComponent(TransformComponent transformComponent) {
        transform = transformComponent;
    }

    @Override
    public void init() {
        bullet = GameEngine.manager.addEntity();
        bullet.addComponent(new TransformComponent(transform.getPosition().x, transform.getPosition().y, 30, 30));
        bullet.addComponent(new SpriteComponent(bullet.getComponent(new TransformComponent()), R.drawable.sprite1, 100));
        bullet.addComponent(new BulletComponent(bullet.getComponent(new TransformComponent()), bulletSpeed));
    }

    @Override
    public void update() {

    }

    @Override
    public void draw() { }
}
