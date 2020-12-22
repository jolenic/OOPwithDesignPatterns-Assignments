
public class PhotoLog extends Log implements Validation{
    private String attachment; //will not be a string in final...
    
    public PhotoLog (String name, String description, String attachment) {
        super(name, description);
        this.attachment = attachment;
    }

    @Override
    public void validate() {
        System.out.println("Yep, that's a photo alright!");
    }
    
    public void annotate() {
        System.out.println("Photo is annotated");
    }

    
    
    public void setContent(String attachment) {
        this.attachment = attachment;
    }
    
    public String getContent() {
        return attachment;
    }

}
