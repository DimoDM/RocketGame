package com.example.rocketgame.App.ECS.Components;

import android.os.SystemClock;
import android.widget.Toast;

import com.example.rocketgame.App.ECS.Component;
import com.example.rocketgame.App.ECS.Entity;
import com.example.rocketgame.App.GameEngine;
import com.example.rocketgame.R;

public class AttackComponent extends Component {

    TransformComponent transform;
    int attackSpeed;
    int bulletSpeed;
    private boolean flag;
    private long delTime = System.currentTimeMillis();


    public AttackComponent() {}

    public AttackComponent(TransformComponent transformComponent, int bulletSpeed, int attackSpeed) {
        transform = transformComponent;
        this.attackSpeed = attackSpeed;
        this.bulletSpeed = bulletSpeed;
    }

    @Override
    public void init() {
        flag = true;
    }

    @Override
    public void update() {
            long curTime = System.currentTimeMillis();;

            if(curTime - delTime > (1000 - attackSpeed * 10)) {
                if(flag) {
                    Entity bullet;
                    bullet = GameEngine.manager.addEntity();
                    bullet.addComponent(new TransformComponent(transform.getPosition().x, transform.getPosition().y, 30, 30));
                    bullet.addComponent(new SpriteComponent(bullet.getComponent(new TransformComponent()), R.drawable.sprite1, 100));
                    bullet.addComponent(new BulletComponent(bullet.getComponent(new TransformComponent()), bulletSpeed, attackSpeed));
                    bullet.addGroup(GameEngine.groupLabels.groupBullets.ordinal());
                }
                else {
                    for (Entity e: GameEngine.manager.getGroup(GameEngine.groupLabels.groupBullets.ordinal())) {
                        if(e.getComponent(new BulletComponent()).isStopped()) e.getComponent(new BulletComponent()).start();
                    }
                }
                delTime = System.currentTimeMillis();
            }
            if(!GameEngine.manager.getGroup(GameEngine.groupLabels.groupBullets.ordinal()).isEmpty()) {
                if(GameEngine.manager.getGroup(GameEngine.groupLabels.groupBullets.ordinal()).get(0)
                .getComponent(new TransformComponent()).getPosition().y < 1) {
                    flag = false;
                }
            }
        }


    @Override
    public void draw() { }
}
