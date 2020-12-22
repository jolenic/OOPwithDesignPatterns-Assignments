package beans;

import java.sql.Timestamp;
import java.util.UUID;

public abstract class Log {

	private UUID id;
	private String title;
	private Object content;
	private Timestamp createTimestamp;
	
	public Log (String title) {
		this.id = UUID.randomUUID();
		this.title = title;
        this.createTimestamp = new Timestamp(System.currentTimeMillis());
	} //end constructor
	
	//getters and setters
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public Timestamp getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(Timestamp createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	
} //end class Log
