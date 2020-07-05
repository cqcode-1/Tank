package com.john.tank;

import com.john.tank.utils.ImageUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ResourceManager {

    public static BufferedImage tankL, tankR, tankU, tankD;
    public static BufferedImage bulletL, bulletR, bulletU, bulletD;
    public static BufferedImage[] explodes = new BufferedImage[16];
    static {
        try {
//            tankU =ImageIO.read(Objects.requireNonNull(ResourceManager.class.getClassLoader().getResourceAsStream("images/BadTank1.png")));
//
//            tankR = ImageUtil.rotateImage(tankU, 90);
//            tankD = ImageUtil.rotateImage(tankU, 180);
//            tankL = ImageUtil.rotateImage(tankU, 270);
            tankL =ImageIO.read(Objects.requireNonNull(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankL.gif")));
            tankR =ImageIO.read(Objects.requireNonNull(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankR.gif")));
            tankU =ImageIO.read(Objects.requireNonNull(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankU.gif")));
            tankD =ImageIO.read(Objects.requireNonNull(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankD.gif")));

            bulletL =ImageIO.read(Objects.requireNonNull(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletL.gif")));
            bulletR =ImageIO.read(Objects.requireNonNull(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletR.gif")));
            bulletU =ImageIO.read(Objects.requireNonNull(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletU.gif")));
            bulletD =ImageIO.read(Objects.requireNonNull(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletD.gif")));

            for (int i = 0; i <16 ; i++) {
                explodes[i] = ImageIO.read(Objects.requireNonNull(ResourceManager.class.getClassLoader().getResourceAsStream("images/e" + (i+1) + ".gif")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
