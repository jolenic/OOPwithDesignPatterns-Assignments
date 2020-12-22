
public class Recording {
    private String name;
    final private int id;
    private String mediaType;
    private String length;
    private String content;
    private String captions;

    public Recording(String name, int id, String mediaType, String length, String content) {
        this.name = name;
        this.id = id;
        this.mediaType = mediaType;
        this.length = length;
        this.content = content;
        this.captions = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCaptions() {
        return captions;
    }

    public void setCaptions(String captions) {
        this.captions = captions;
    }

}
