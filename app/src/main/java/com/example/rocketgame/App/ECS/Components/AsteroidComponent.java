package com.example.rocketgame.App.ECS.Components;

import com.example.rocketgame.App.ECS.Component;
import com.example.rocketgame.App.GameEngine;
import com.example.rocketgame.App.HelpClasses.Rect;

import java.util.Random;

public class AsteroidComponent extends Component {

    private TransformComponent transform;
    int width;
    int height;

    public AsteroidComponent() {
    }

    public AsteroidComponent(TransformComponent transformComponent) {
        transform = transformComponent;
    }

    @Override
    public void init() {
        width = (int) (Math.random() * 200 + 100);
        height = width;
        transform.setPosition(new Rect((int) (Math.random() * GameEngine.SCREEN_WIDTH), -height, width, height));
        transform.setVelY(1);
        transform.setVelX((int)(Math.random() * 2) == 1 ? 0.5f : -0.5f);
    }

    @Override
    public void update() {
        if(transform.getPosition().x + width > GameEngine.SCREEN_WIDTH) transform.setVelX(-0.5f);
        if(transform.getPosition().x < 0) transform.setVelX(0.5f);
    }

    @Override
    public void draw() {

    }
}
