package beans;

public class DisplayLogs {

	private String id;
	private String title;
	private String content;
	private String createTimestamp;

	public DisplayLogs(String id, String title, String content, String createTimestamp) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.createTimestamp = createTimestamp;
	}

	public String getId() {
		return id;
	}

	public String displayHTML() {
		return "<p>Log Type: TextLog</p><p>ID: " + id + "</p><p> Timestamp: " + createTimestamp + "</p><p>Title: "
				+ title + "</p><p>Content: " + content + "</p>";
	}

}
