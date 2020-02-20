package logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadComponents {

    public static BufferedImage earth50,jupiter50,mars50,europa50, kalisto50,io50,saturn50, betelgeza50,syriusz50,uran50;
    public static BufferedImage earth100,jupiter100,mars100,europa100, kalisto100,io100,saturn100, betelgeza100,syriusz100,uran100;

    public static BufferedImage red_Lamp, green_Lamp, empty_Lamp;
    public static BufferedImage up,down;
    public static BufferedImage randomIcon, questMark;


    public static BufferedImage headerImage, backgound;

    public static BufferedImage deleteIcon,mIcon;



    static {
        try {


            headerImage = ImageIO.read(new File("src\\main\\java\\GUI\\images\\background\\header.png"));
            backgound = ImageIO.read(new File("src\\main\\java\\GUI\\images\\background\\space_background.jpg"));


            // 50 x 50 px
            earth50 = ImageIO.read(new File("src\\main\\java\\GUI\\images\\planetsImage\\50\\earth50x50.png"));
            jupiter50 = ImageIO.read(new File("src\\main\\java\\GUI\\images\\planetsImage\\50\\Jupiter50x50.png"));
            mars50 = ImageIO.read(new File("src\\main\\java\\GUI\\images\\planetsImage\\50\\Mars50x50.png"));
            europa50 = ImageIO.read(new File("src\\main\\java\\GUI\\images\\planetsImage\\50\\monn50x50.png"));
            kalisto50 = ImageIO.read(new File("src\\main\\java\\GUI\\images\\planetsImage\\50\\Moon50x50.png"));
            io50 = ImageIO.read(new File("src\\main\\java\\GUI\\images\\planetsImage\\50\\RedMoon50x50.png"));
            saturn50 = ImageIO.read(new File("src\\main\\java\\GUI\\images\\planetsImage\\50\\Saturn50x50.png"));
            betelgeza50 = ImageIO.read(new File("src\\main\\java\\GUI\\images\\planetsImage\\50\\Sun50x50.png"));
            syriusz50 = ImageIO.read(new File("src\\main\\java\\GUI\\images\\planetsImage\\50\\Sun250x50.png"));
            uran50 = ImageIO.read(new File("src\\main\\java\\GUI\\images\\planetsImage\\50\\Uran50x50.png"));

            // 100 x 100 px
            earth100 = ImageIO.read(new File("src\\main\\java\\GUI\\images\\planetsImage\\100\\earth100x100.png"));
            jupiter100 = ImageIO.read(new File("src\\main\\java\\GUI\\images\\planetsImage\\100\\Jupiter100x100.png"));
            mars100 = ImageIO.read(new File("src\\main\\java\\GUI\\images\\planetsImage\\100\\Mars100x100.png"));
            europa100 = ImageIO.read(new File("src\\main\\java\\GUI\\images\\planetsImage\\100\\monn100x100.png"));
            kalisto100 = ImageIO.read(new File("src\\main\\java\\GUI\\images\\planetsImage\\100\\Moon100x100.png"));
            io100 = ImageIO.read(new File("src\\main\\java\\GUI\\images\\planetsImage\\100\\RedMoon100x100.png"));
            saturn100 = ImageIO.read(new File("src\\main\\java\\GUI\\images\\planetsImage\\100\\Saturn100x100.png"));
            betelgeza100 = ImageIO.read(new File("src\\main\\java\\GUI\\images\\planetsImage\\100\\Sun100x100.png"));
            syriusz100 = ImageIO.read(new File("src\\main\\java\\GUI\\images\\planetsImage\\100\\Sun2100x100.png"));
            uran100 = ImageIO.read(new File("src\\main\\java\\GUI\\images\\planetsImage\\100\\Uran100x100.png"));



            red_Lamp = ImageIO.read(new File("src\\main\\java\\GUI\\images\\lamps\\redLamp.png"));
            green_Lamp = ImageIO.read(new File("src\\main\\java\\GUI\\images\\lamps\\greenLamp.png"));
            empty_Lamp = ImageIO.read(new File("src\\main\\java\\GUI\\images\\lamps\\emptyLamp.png"));


            up = ImageIO.read(new File("src\\main\\java\\GUI\\images\\up.png"));
            down = ImageIO.read(new File("src\\main\\java\\GUI\\images\\down.png"));


            randomIcon = ImageIO.read(new File("src\\main\\java\\GUI\\images\\randomIcon.png"));
            questMark = ImageIO.read(new File("src\\main\\java\\GUI\\images\\questMark.png"));






            deleteIcon = ImageIO.read(new File("src\\main\\java\\GUI\\images\\deleteIcon.png"));
            mIcon = ImageIO.read(new File("src\\main\\java\\GUI\\images\\mIcon.png"));





        } catch (IOException e) {
            System.out.println("Cant get photos " + LoadComponents.class);
        }
    }


}
