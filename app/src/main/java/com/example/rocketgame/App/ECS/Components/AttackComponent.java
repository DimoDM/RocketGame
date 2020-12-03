package com.example.rocketgame.App.ECS.Components;

import android.os.SystemClock;
import android.widget.Toast;

import com.example.rocketgame.App.ECS.Component;
import com.example.rocketgame.App.ECS.Entity;
import com.example.rocketgame.App.GameEngine;
import com.example.rocketgame.R;

import java.util.ArrayList;
import java.util.List;

public class AttackComponent extends Component {

    TransformComponent transform;
    int attackSpeed;
    int bulletSpeed;
    private boolean flag;
    private long startTime = System.currentTimeMillis();
    List<Entity> bullets = new ArrayList<>();


    public AttackComponent() {
    }

    public AttackComponent(TransformComponent transformComponent, int bulletSpeed, int attackSpeed) {
        transform = transformComponent;
        this.attackSpeed = attackSpeed;
        this.bulletSpeed = bulletSpeed;
    }

    @Override
    public void init() {
        flag = true;
        for (int i = 0; i < 20; i++) {
            bullets.add(GameEngine.manager.addEntity());
            bullets.get(i).addComponent(new TransformComponent(transform.getPosition().x, transform.getPosition().y, 30, 30));
            bullets.get(i).addComponent(new SpriteComponent(bullets.get(i).getComponent(new TransformComponent()), R.drawable.sprite1, 100));
            bullets.get(i).addComponent(new BulletComponent(bullets.get(i).getComponent(new TransformComponent()), bulletSpeed, attackSpeed));
            bullets.get(i).addGroup(GameEngine.groupLabels.groupBullets.ordinal());
            bullets.get(i).getComponent(new BulletComponent()).destroy();
        }
    }

    @Override
    public void update() {
        long curTime = System.currentTimeMillis();
        System.out.println(bullets.size());
        if (curTime - startTime > (1000 - attackSpeed * 10)) {
            for (int i = 0; i < bullets.size(); i++) {
                if (bullets.get(i).getComponent(new BulletComponent()).isStopped()) {
                    bullets.get(i).getComponent(new BulletComponent()).start();
                    i = bullets.size();
                }
            }
            startTime = System.currentTimeMillis();
        }
    }


    @Override
    public void draw() {
    }
}
