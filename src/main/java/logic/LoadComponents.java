package logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadComponents {

    public static BufferedImage red_image, green_Image, blue_Image,pink_Image, orange_Image, emptyBALL_Image;


    static {
        try {
            red_image = ImageIO.read(new File("src\\main\\java\\GUI\\images\\ballsImage\\red.png"));
            green_Image = ImageIO.read(new File("src\\main\\java\\GUI\\images\\ballsImage\\green.png"));
            blue_Image = ImageIO.read(new File("src\\main\\java\\GUI\\images\\ballsImage\\blue.png"));
            orange_Image = ImageIO.read(new File("src\\main\\java\\GUI\\images\\ballsImage\\orange.png"));
            pink_Image = ImageIO.read(new File("src\\main\\java\\GUI\\images\\ballsImage\\pink.png"));

            emptyBALL_Image = ImageIO.read(new File("src\\main\\java\\GUI\\images\\ballsImage\\emptyBALL.png"));


        } catch (IOException e) {
            System.out.println(e);
        }
    }


}
