package com.example.rocketgame.App.ECS.Components;


import android.graphics.Canvas;

import com.example.rocketgame.App.ECS.Component;
import com.example.rocketgame.App.UI.TextureManager;
import com.example.rocketgame.RocketGameApplication;

public class SpriteComponent extends Component {

    private TransformComponent transform;
    private int path;
    private TextureManager texture;


    public SpriteComponent() {}

    public SpriteComponent(TransformComponent transformComponent, final int path, int size) {
        transform = transformComponent;
        this.path = path;
        texture = new TextureManager(path, (int)transform.getPosition().x, (int)transform.getPosition().y, transform.getPosition().width, transform.getPosition().height);
    }

    @Override
    public void init() {}

    @Override
    public void update() {
        texture.setX((int)transform.getPosition().x);
        texture.setY((int)transform.getPosition().y);
    }

    @Override
    public void draw() {
        texture.draw();
    }

    public TransformComponent getTransform() {
        return transform;
    }

    public void setTransform(TransformComponent transform) {
        this.transform = transform;
    }

    public int getPath() {
        return path;
    }

    public void setPath(int path) {
        this.path = path;
    }

    public TextureManager getTexture() {
        return texture;
    }

    public void reloadTexture() {
        this.texture =  new TextureManager(path, (int)transform.getPosition().x, (int)transform.getPosition().y, transform.getPosition().width, transform.getPosition().height);
    }

    public void changeAnimationFrame(int x, int y, boolean flip) {
        /*texture.setAnimationXPosition(x);
        texture.setAnimationYPosition(y);
        texture.setFlip(flip);*/
    }

}