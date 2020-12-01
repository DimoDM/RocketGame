package com.example.rocketgame.App.ECS.Components;


import com.example.rocketgame.App.ECS.Component;
import com.example.rocketgame.App.UI.TextureManager;

public class SpriteComponent extends Component {

    private TransformComponent transform;
    private String path;
    private TextureManager texture;


    public SpriteComponent() {}

    public SpriteComponent(TransformComponent transformComponent, final String path, int size) {/*
        transform = transformComponent;
        this.path = path;
        texture = new TextureManager(transform.getPosition().x, transform.getPosition().y, transform.getPosition().width, transform.getPosition().height, path, false, true, size);
        Display.getInstance().addGraphic(texture);*/
    }

    @Override
    public void init() {}

    @Override
    public void update() {/*
        texture.setX(transform.getPosition().x);
        texture.setY(transform.getPosition().y);*/
    }

    @Override
    public void draw() {
        //texture.render();
    }

    public void changeAnimationFrame(int x, int y, boolean flip) {
        /*texture.setAnimationXPosition(x);
        texture.setAnimationYPosition(y);
        texture.setFlip(flip);*/
    }

}