package com.example.rocketgame.App.ECS;

public abstract class Component {

    protected Entity entity;

    public abstract void init();
    public abstract void update();
    public abstract void draw();
}
