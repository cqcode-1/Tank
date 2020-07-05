package com.john.tank;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet {
    private int x,y;
    private Dir dir;
    private static  final int SPEED = 6;
    public static int WIDTH = ResourceManager.bulletL.getWidth(), HEIGHT = ResourceManager.bulletL.getHeight();
    private boolean living = true;
    private TankFrame tf;
    private Group group = Group.BAD;
    private Rectangle rectangle = new Rectangle();

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;

        rectangle.x = x;
        rectangle.y = y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
    }

    public boolean isLiving() {
        return living;
    }

    public void paint(Graphics g){
        if(!living){
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
            living = false;
        }

        rectangle.x = x;
        rectangle.y = y;
    }

    public void die(){
        living = false;
    }

    public void collideWith(Tank tank) {
        if(this.group == tank.getGroup()) return;
        if(rectangle.intersects(tank.rectangle)){
            tank.die();
            this.die();
            tf.explodes.add(new Explode(tank.getX() + Tank.TANK_WIDTH/2 - Explode.WIDTH/2 , tank.getY()+ Tank.TANK_HEIGHT/2 - Explode.HEIGHT/2, tf));
        }
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
