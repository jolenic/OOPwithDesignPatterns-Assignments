
public class AudioLog extends Log implements Validation{

    private String attachment; //will not be a string in final...
    
    public AudioLog (String name, String description, String attachment) {
        super(name, description);
        this.attachment = attachment;
    }

    @Override
    public void validate() {
        System.out.println("Yep, that's audio alright!");
    }
    
    public void caption() {
        System.out.println("Audio is captioned");
    }
    
    public void transcode() {
        System.out.println("Audio is transcoded");
    }
    
    public void setContent(String attachment) {
        this.attachment = attachment;
    }
    
    public String getContent() {
        return attachment;
    }
    
}
