
public class TextLog extends Log implements Validation{
    private String attachment; //will not be a string in final...
    
    public TextLog (String name, String description, String attachment) {
        super(name, description);
        this.attachment = attachment;
    }

    @Override
    public void validate() {
        System.out.println("Yep, that's text alright!");
    }
    
    public void translate() {
        System.out.println("Text is translated");
    }
    
    public void setContent(String attachment) {
        this.attachment = attachment;
    }
    
    public String getContent() {
        return attachment;
    }
}
