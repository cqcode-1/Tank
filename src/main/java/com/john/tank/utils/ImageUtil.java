package com.john.tank.utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageUtil {
    public static BufferedImage rotateImage(final BufferedImage bufferedImage, final int degree){
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        int transferType = bufferedImage.getColorModel().getTransferType();
        BufferedImage img;
        Graphics2D graphics2D;
        img = new BufferedImage(width, height, transferType);
        graphics2D = img.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.rotate(Math.toRadians(degree), width/2, height/2);
        graphics2D.drawImage(bufferedImage, 0, 0, null);
        graphics2D.dispose();
        return img;
    }
}
