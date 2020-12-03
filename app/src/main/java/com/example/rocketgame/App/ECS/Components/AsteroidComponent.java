package com.example.rocketgame.App.ECS.Components;

import com.example.rocketgame.App.ECS.Component;
import com.example.rocketgame.App.ECS.Entity;
import com.example.rocketgame.App.GameEngine;
import com.example.rocketgame.App.HelpClasses.Collide;
import com.example.rocketgame.App.HelpClasses.Rect;
import com.example.rocketgame.R;

import java.util.Random;

public class AsteroidComponent extends Component {

    private TransformComponent transform;
    private HealthComponent health;
    private SpriteComponent sprite;
    int width;
    int height;

    public AsteroidComponent() {
    }

    public AsteroidComponent(TransformComponent transformComponent, HealthComponent healthComponent, SpriteComponent spriteComponent) {
        transform = transformComponent;
        health = healthComponent;
        sprite = spriteComponent;
    }

    @Override
    public void init() {
        destroy();
    }

    @Override
    public void update() {
        for (int i = 0; i < GameEngine.manager.getGroup(GameEngine.groupLabels.groupAsteroids.ordinal()).size(); i++) {
            TransformComponent transformComponent = GameEngine.manager.getGroup(GameEngine.groupLabels.groupAsteroids.ordinal()).get(i).getComponent(new TransformComponent());
            if(transformComponent.getPosition().x != transform.getPosition().x) {
                if(transform.getPosition().x > transformComponent.getPosition().x
                        && transform.getPosition().x < transformComponent.getPosition().x + transformComponent.getPosition().width
                        && Collide.AABB(transformComponent.getPosition(), transform.getPosition())){
                    transform.setVelX(0.5f);
                    GameEngine.manager.getGroup(GameEngine.groupLabels.groupAsteroids.ordinal()).get(i).getComponent(new TransformComponent()).setVelX(-0.5f);
                }
            }
        }

        if(transform.getPosition().x + width > GameEngine.SCREEN_WIDTH) transform.setVelX(-0.5f);
        if(transform.getPosition().x < 0) transform.setVelX(0.5f);
        if(!health.isAlive()) destroy();
    }

    public void destroy() {
        width = ((int) (Math.random() * 3 + 1)) * 50;
        height = width;
        transform.setPosition(new Rect((int) (Math.random() * GameEngine.SCREEN_WIDTH), -height * 2, width, height));
        transform.setVelY(1);
        transform.setVelX((int)(Math.random() * 2) == 1 ? 0.5f : -0.5f);
        health.setHealth(width / 50);
        sprite.setPath(R.drawable.asteroid);
        sprite.setTransform(transform);
        sprite.reloadTexture();
    }

    @Override
    public void draw() {

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
