package com.john.tank;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Explode {
    private int x, y;
    public static final int WIDTH = ResourceManager.explodes[0].getWidth();
    public static final int HEIGHT = ResourceManager.explodes[0].getHeight();

    private TankFrame tf;
    private int step = 0;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }


    public void paint(Graphics g) {
        g.drawImage(ResourceManager.explodes[step++], x, y, null);
        if(step>= ResourceManager.explodes.length)
            tf.explodes.remove(this);

    }
}
