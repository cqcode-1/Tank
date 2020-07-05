package com.john.tank;

public class Main {
    public static void main(String[] args) {
        TankFrame tankFrame = new TankFrame();

        int initCountTank = Integer.parseInt((String) PropertyManager.get("tankCountInit"));
        //初始化tank
        for (int i=0; i<initCountTank; i++){
            tankFrame.add(new Tank(50+ i*80, 200, Dir.UP, Group.BAD, tankFrame));
        }

        while (true){
            try {
                Thread.sleep(30);
                //死循环不断重绘。
                tankFrame.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
