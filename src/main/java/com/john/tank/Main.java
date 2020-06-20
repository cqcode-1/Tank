package com.john.tank;

public class Main {
    public static void main(String[] args) {
        TankFrame tankFrame = new TankFrame();

        //初始化tank
        for (int i=0; i<5; i++){
            tankFrame.add(new Tank(50+ i*80, 200, Dir.UP, Group.BAD, tankFrame));
        }

        while (true){
            try {
                Thread.sleep(50);
                //死循环不断重绘。
                tankFrame.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
