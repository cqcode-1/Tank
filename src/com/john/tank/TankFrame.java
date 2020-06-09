package com.john.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    int x = 200, y = 200;

    public TankFrame(){
        setSize(800, 600);
        setResizable(false);
        setTitle("TankFrame");
        setVisible(true);
        //键盘监听事件
        addKeyListener(new MyKeyListener());
        //窗口关闭事件监听
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        //位置和大小
        g.fillRect(x, y, 50,50);
//        x += 20;
//        y += 20;
    }

    class MyKeyListener extends KeyAdapter{


        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {

            int keyCode = e.getKeyCode();
            System.out.println("key pressed "+ keyCode);
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    x -= 10;
                    TankFrame.this.repaint();
                    break;
                case KeyEvent.VK_RIGHT:
                    x +=10;
                    TankFrame.this.repaint();
                    break;
                case KeyEvent.VK_UP:
                    y -=10;
                    TankFrame.this.repaint();
                    break;
                case KeyEvent.VK_DOWN:
                    y +=10;
                    TankFrame.this.repaint();
                    break;

            }

//            TankFrame.this.x += 20;
//            TankFrame.this.y += 20;
//            TankFrame.this.repaint();
            super.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
        }
    }
}
