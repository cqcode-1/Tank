package com.john.tank;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Tank {
    //表示tank出来的位置坐标
    private int x,y;
    private final int SPEED = 2;

    public static final int TANK_WIDTH = ResourceManager.tankL.getWidth();
    public static final int TANK_HEIGHT = ResourceManager.tankL.getHeight();

    private Dir dir = Dir.DOWN;
    private TankFrame tf;
    private boolean moving = true;
    private boolean living = true;
    private Group group = Group.BAD;

    private Random random = new Random();


    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
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
        if(!living) tf.tanks.remove(this);
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

        //敌方坦克随机开火
        if(group == Group.BAD && random.nextInt(100) > 94) this.fire();
        //敌方坦克随机移动
        if(group == Group.BAD && random.nextInt(100) > 95 ) randomDir();
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire(){
        int xp = this.x+ TANK_WIDTH/2 - Bullet.WIDTH/2;
        int yp = this.y+ TANK_HEIGHT/2 - Bullet.HEIGHT/2;
        tf.bullets.add(new Bullet(xp, yp, dir, group,  tf));
    }

    public void die(){
        living = false;
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


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setY(int y) {
        this.y = y;
    }
}
