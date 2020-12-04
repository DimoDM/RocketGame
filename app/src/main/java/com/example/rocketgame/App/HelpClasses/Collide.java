package com.example.rocketgame.App.HelpClasses;


import com.example.rocketgame.App.ECS.Components.ColliderComponent;

public class Collide {

    public static boolean AABB(Rect rOne, Rect rTwo) {
        return (rOne.x < rTwo.x + rTwo.width &&
                rOne.x + rOne.width > rTwo.x &&
                rOne.y < rTwo.y + rTwo.height &&
                rOne.y + rOne.height > rTwo.y);
    }

    public static boolean AABB(ColliderComponent cOne, ColliderComponent cTwo) {
        Rect rOne = cOne.getCollider();
        Rect rTwo = cTwo.getCollider();
        return AABB(rOne, rTwo);
    }
}
