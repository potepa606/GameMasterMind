package GUI.levelModuleListeners;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LevelGame {

    public static BufferedImage easyIMG, easyOnIMG, mediumIMG,mediumOnIMG, hardIMG,hardOnIMG;
    public static BufferedImage stateEasy, stateMedium, stateHard;
    public static boolean[] levelList = {false,false,false};

    static {
        try {
            // Load hard, medium , easy Images
            easyIMG = ImageIO.read(new File("src\\main\\java\\GUI\\images\\levelsImage\\easy.png"));
            easyOnIMG = ImageIO.read(new File("src\\main\\java\\GUI\\images\\levelsImage\\easyON.png"));

            mediumIMG = ImageIO.read(new File("src\\main\\java\\GUI\\images\\levelsImage\\medium.png"));
            mediumOnIMG = ImageIO.read(new File("src\\main\\java\\GUI\\images\\levelsImage\\mediumON.png"));

            hardIMG = ImageIO.read(new File("src\\main\\java\\GUI\\images\\levelsImage\\hard.png"));
            hardOnIMG = ImageIO.read(new File("src\\main\\java\\GUI\\images\\levelsImage\\hardON.png"));


        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    public static String pokazstany(){
        String stanOstateczny = "Nic nie wybrano";
        for(int i = 0 ; i<levelList.length;i++){
            if(levelList[i]){
                switch (i) {
                    case 0:
                        stanOstateczny ="Easy";
                        break;
                    case 1:
                        stanOstateczny ="Medium";
                        break;
                    case 2:
                        stanOstateczny ="Hard";
                        break;
                }
            }
        }
        return stanOstateczny;
    }
}



