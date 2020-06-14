package com.john.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ResourceManager {

    public static BufferedImage tankL, tankR, tankU, tankD;
    public static BufferedImage bulletL, bulletR, bulletU, bulletD;
    static {
        try {
            tankL =ImageIO.read(Objects.requireNonNull(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankL.gif")));
            tankR =ImageIO.read(Objects.requireNonNull(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankR.gif")));
            tankU =ImageIO.read(Objects.requireNonNull(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankU.gif")));
            tankD =ImageIO.read(Objects.requireNonNull(ResourceManager.class.getClassLoader().getResourceAsStream("images/tankD.gif")));

            bulletL =ImageIO.read(Objects.requireNonNull(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletL.gif")));
            bulletR =ImageIO.read(Objects.requireNonNull(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletR.gif")));
            bulletU =ImageIO.read(Objects.requireNonNull(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletU.gif")));
            bulletD =ImageIO.read(Objects.requireNonNull(ResourceManager.class.getClassLoader().getResourceAsStream("images/bulletD.gif")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
