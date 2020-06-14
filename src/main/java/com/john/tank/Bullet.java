package com.john.tank;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet {
    private int x,y;
    private Dir dir;
    private static  final int SPEED = 6;
    public static int WIDTH = ResourceManager.bulletL.getWidth(), HEIGHT = ResourceManager.bulletL.getHeight();
    private boolean live = true;
    private TankFrame tf;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public boolean isLive() {
        return live;
    }

    public void paint(Graphics g){
        if(!live){
            tf.bullets.remove(this);
        }
        BufferedImage image = ResourceManager.bulletL;
        switch (dir){
            case LEFT:
                image = ResourceManager.bulletL;
                break;
            case RIGHT:
                image = ResourceManager.bulletR;
                break;
            case UP:
                image = ResourceManager.bulletU;
                break;
            case DOWN:
                image = ResourceManager.bulletD;
                break;
        }
        g.drawImage(image, x, y, null);
        move();
    }

    private void move() {
        switch (dir){
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }

        if(x<0 || y<0 || x> TankFrame.GAME_WIDTH || y> TankFrame.GAME_HEIGHT){
            live = false;
        }
    }

}