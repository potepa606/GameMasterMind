package music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


public class Music {

    public static void FirsSound() {
        System.out.println("Metoda muzyczna");
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\main\\java\\music\\gameSong.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            System.out.println("Start");
            clip.start();
        } catch(Exception ex){
            System.out.println("Error with playing sound.");
        }
    }

}
