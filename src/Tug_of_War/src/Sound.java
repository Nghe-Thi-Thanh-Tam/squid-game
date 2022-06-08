import javax.sound.sampled.*;
import java.io.File;
import java.net.URL;

public class Sound {
    public Clip clip;
    URL[] soundURL = new URL[10];
    public Sound() {
        soundURL[0] = getClass().getResource("res/sound/countDown.wav");
    }

    public void setFile(int i) {
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e){

        }
    }

    public void play() {

        clip.start();
    }

    public void loop() {

    }

    public void stop() {
        clip.stop();
    }

}
