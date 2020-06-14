package test;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ImageTest {
    @Test
    public void test(){
        try {
//            BufferedImage bufferedImage = ImageIO.read(new File(""));
            BufferedImage bufferedImage = ImageIO.read(Objects.requireNonNull(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif")));
            System.out.println(bufferedImage == null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
