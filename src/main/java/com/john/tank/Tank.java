package com.john.tank;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tank {
    //表示tank出来的位置坐标
    private int x,y;
    private final int SPEED = 10;

    private final int TANK_WIDTH = ResourceManager.tankL.getWidth();
    private final int TANK_HEIGHT = ResourceManager.tankL.getHeight();

    private Dir dir = Dir.DOWN;
    private TankFrame tf;
    private boolean moving = false;



    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g) {
        BufferedImage image = ResourceManager.tankL;
        switch (dir){
            case LEFT:
                image = ResourceManager.tankL;
                break;
            case RIGHT:
                image = ResourceManager.tankR;
                break;
            case UP:
                image = ResourceManager.tankU;
                break;
            case DOWN:
                image = ResourceManager.tankD;
                break;
        }
        g.drawImage(image, x, y, null);
        move();
    }

    private void move() {
        if(!moving) return;
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
    }

    public void fire(){
        int xp = this.x+ TANK_WIDTH/2 - Bullet.WIDTH/2;
        int yp = this.y+ TANK_HEIGHT/2 - Bullet.HEIGHT/2;
        tf.bullets.add(new Bullet(xp, yp, dir, tf));
    }
}
