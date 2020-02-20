package music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.applet.*;



public class Music {

    private Clip clip;

    public Music() {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("src\\main\\java\\music\\gameSong.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audio);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch(Exception ex){
            System.out.println("Error playing sound.");
        }

    }

    public Clip getClip() {
        return clip;
    }
}
