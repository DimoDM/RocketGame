package com.example.rocketgame.App.ECS.Components;

import com.example.rocketgame.App.ECS.Component;

public class HealthComponent extends Component {

    private int health;
    private int maxHealth;

    public HealthComponent() {}

    public HealthComponent(int health) {
        this.health = health;
        maxHealth = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        maxHealth = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public boolean isAlive() {
        return health > 0;
    }


    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw() {

    }
}
