package com.john.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class T {
    public static void main(String[] args) {
        //窗口
        Frame frame = new Frame();
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setTitle("Tank War");
        //设置显示
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
}
