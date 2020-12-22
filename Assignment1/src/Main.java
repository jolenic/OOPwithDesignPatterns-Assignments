
public class Main {

    public static void main(String[] args) {
        System.out.println("Create TextLog, read, validate:");
        TextLog text = new TextLog("TextLog", "A Log with Text", "a text attachment");
        text.read();
        text.validate();
        System.out.println();
        System.out.println("Create AudioLog, read, validate, then update:");
        AudioLog audio = new AudioLog("AudioLog", "A Log with Audio", "an audio attachment");
        audio.read();
        audio.validate();
        audio.update();
        System.out.println();
        System.out.println("Create VideoLog, read, and caption:");
        VideoLog video = new VideoLog("VideoLog", "A Log with Video", "a video attachment");
        video.read();
        video.caption();
    }

}
