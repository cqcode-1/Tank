package com.john.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    Tank tank = new Tank(200, 200, Dir.DOWN);
    public TankFrame(){
        setSize(800, 600);
        setResizable(false);
        setTitle("Tank War");
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

        tank.paint(g);

    }


    /**
     * 键盘事件接收
     */
    class MyKeyListener extends KeyAdapter{
        boolean BL = false;
        boolean BR = false;
        boolean BU = false;
        boolean BD = false;

        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    BL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    BR = true;
                    break;
                case KeyEvent.VK_UP:
                    BU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    BD =true;
                    break;
                default:break;

            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {

            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    BL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    BR = false;
                    break;
                case KeyEvent.VK_UP:
                    BU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    BD = false;
                    break;
                default:break;

            }
            setMainTankDir();
        }

        private void setMainTankDir(){
            if(!BL&&!BR&&!BU&&!BD){
                tank.setMoving(false);
            }else
                tank.setMoving(true);
            if(BL) tank.setDir(Dir.LEFT);
            if(BR) tank.setDir(Dir.RIGHT);
            if(BU) tank.setDir(Dir.UP);
            if(BD) tank.setDir(Dir.DOWN);
        }
    }
}
