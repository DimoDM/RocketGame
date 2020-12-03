package com.example.rocketgame.App.ECS.Components;


import android.view.Display;

import com.example.rocketgame.App.ECS.Component;
import com.example.rocketgame.App.GameEngine;
import com.example.rocketgame.App.UI.TextureManager;
import com.example.rocketgame.R;
import com.example.rocketgame.RocketGameApplication;

import java.util.Calendar;

public class ScoreComponent extends Component {

    private int score = 0;
    private long time = System.currentTimeMillis();
    TextureManager[] texture = new TextureManager[4];
    //TextureManager texture;

    public ScoreComponent() {
    }

    @Override
    public void init() {
        for (int i = 0; i < 4; i++) {
            texture[i] = new TextureManager();
            //texture = new TextureManager();

        }
    }

    @Override
    public void update() {
        if (System.currentTimeMillis() - time >= 1000) {
            score++;
            int graph = score;
            int index = 0;
            int size = GameEngine.SCREEN_WIDTH / 15;
            while (graph != 0) {
                texture[index].setX(GameEngine.SCREEN_WIDTH - size - size * index - 20);
                texture[index].setY(20);
                texture[index].setWidth(size);
                texture[index].setHeight(size);
                texture[index].setPath(getPath(graph % 10));
               /* texture.setX(GameEngine.SCREEN_WIDTH - size - size * index - 20);
                texture.setY(20);
                texture.setWidth(size);
                texture.setHeight(size);
                texture.setPath(getPath(graph % 10));*/
                graph /= 10;
                index++;
            }

            for (int i = index; i < 4; i++) {
                texture[i].setX(GameEngine.SCREEN_WIDTH - size - size * index - 20);
                texture[i].setY(20);
                texture[i].setWidth(size);
                texture[i].setHeight(size);
                texture[i].setPath(getPath(10));
            }

            time = System.currentTimeMillis();
        }
    }

    @Override
    public void draw() {
        for (int i = 0; i < 4; i++) {
            texture[i].draw();
            //texture.draw();
        }
    }

    public int getScore() {
        return score;
    }

    private int getPath(int num) {
        switch (num) {
            case 0:
                return R.drawable.n0;
            case 1:
                return R.drawable.n1;
            case 2:
                return R.drawable.n2;
            case 3:
                return R.drawable.n3;
            case 4:
                return R.drawable.n4;
            case 5:
                return R.drawable.n5;
            case 6:
                return R.drawable.n6;
            case 7:
                return R.drawable.n7;
            case 8:
                return R.drawable.n8;
            case 9:
                return R.drawable.n9;
            default:
                return R.drawable.empty;
        }
    }
}
