package com.john.tank;

public class Main {
    public static void main(String[] args) {
        TankFrame tankFrame = new TankFrame();

        while (true){
            try {
                Thread.sleep(50);
                tankFrame.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
