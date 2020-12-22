
public class Captioner implements Runnable {
    private Recording media;

    public Captioner(Recording media) {
        this.media = media;
    }

    @Override
    public void run() {
        ExternalCaptioner captions = new ExternalCaptioner();
        System.out.println(Thread.currentThread().getName() + " is processing: " + media.getName());
        if ((media.getMediaType() != "audio") && (media.getMediaType() != "video")) {
            System.out.println("Only audio and video files can be close captioned.");
        } else {
            media.setCaptions(captions.captioning(media.getContent()));
            System.out.println(media.getName() + "'s captions are now: " + media.getCaptions());
        }

    }
}
