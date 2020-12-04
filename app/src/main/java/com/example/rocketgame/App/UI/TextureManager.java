package com.example.rocketgame.App.UI;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rocketgame.R;
import com.example.rocketgame.RocketGameApplication;
import com.example.rocketgame.ui.texture.MainThread;

public class TextureManager  {

    private Bitmap image;
    private int x;
    private int y;
    private int width;
    private int height;
    private int path;

    public TextureManager() {}

    public TextureManager(int path, int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        image = BitmapFactory.decodeResource(RocketGameApplication.APP.getResources(), path);
        image = getResizedBitmap(image, w, h);
    }

    public void draw() {
        MainThread.canvas.drawBitmap(image, x, y, null);
    }

    private Bitmap getResizedBitmap(Bitmap bm, int newWidth, int newHeight) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);

        // "RECREATE" THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createBitmap(
                bm, 0, 0, width, height, matrix, false);
        bm.recycle();
        return resizedBitmap;
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

    public int getPath() {
        return path;
    }

    public void setPath(int path) {
        image = BitmapFactory.decodeResource(RocketGameApplication.APP.getResources(), path);
        image = getResizedBitmap(image, width, height);
        this.path = path;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /*
    private int x;
    private int y;
    private Bitmap image;
    private int width;
    private int height;
    private String path;
    private boolean flip = false;
    private boolean animated;
    private int spriteSize;
    private int animationXPosition = 0;
    private int animationYPosition = 0;

    public TextureManager() {
    }

    public TextureManager(int x, int y, int width, int height, String path, boolean flip) {
        BitmapFactory.decodeResource(, R.drawable.sprite1);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.path = path;
        this.flip = flip;
        this.animated = false;
        //Display.getInstance().addGraphic(this);
    }

    public TextureManager(int x, int y, int width, int height, String path, boolean flip, boolean isAnimated, int size) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.path = path;
        this.flip = flip;
        this.animated = isAnimated;
        spriteSize = size;
        //Display.getInstance().addGraphic(this);
    }

    public TextureManager(int x, int y, int size, String path, int srcX, int srcY) {
        this.x = x;
        this.y = y;
        this.width = size;
        this.height = size;
        this.path = path;
        this.animated = true;
        spriteSize = size;
        animationXPosition = srcX;
        animationYPosition = srcY;
        //Display.getInstance().addGraphic(this);
    }*/
/*
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graph = (Graphics2D) g;

        ImageIcon imageIcon = new ImageIcon(this.path);
        Image image = imageIcon.getImage();

        int animationX = animationXPosition * spriteSize;
        int animationY = animationYPosition * spriteSize;

        if (animated) {
            if (!flip)
                graph.drawImage(image, this.x, this.y, width + this.x, this.height + this.y, animationX, animationY, animationX + spriteSize, animationY + spriteSize, null);
            else
                graph.drawImage(image, this.x + this.width, this.y, this.x, this.height + this.y, animationX, animationY, animationX + spriteSize, animationY + spriteSize, null);
        } else {
            if (!flip) graph.drawImage(image, this.x, this.y, this.width, this.height, null);
            else graph.drawImage(image, this.x + width, this.y, -this.width, this.height, null);
        }

    }*/
/*
    public void render() {
        Thread animationThread = new Thread(new Runnable() {
            public void run() {
                //repaint();
            }
        });

        animationThread.start();
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setFlip(boolean flip) {
        this.flip = flip;
    }

    public void setAnimationXPosition(int animationXPosition) {
        this.animationXPosition = animationXPosition;
    }

    public void setAnimationYPosition(int animationYPosition) {
        this.animationYPosition = animationYPosition;
    }*/
}