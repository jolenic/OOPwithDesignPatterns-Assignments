import java.util.Date;
import java.util.UUID;

public class LogBuilder {

	private String name;
	private String description;
	private Date date;
	private UUID uuid;
	private String code;
	private File attachment;

	public LogBuilder() {
		this.date = new Date();
		this.uuid = UUID.randomUUID();
		this.code = CodeGenerator.getInstance().shortCode();
	}

	public LogBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public LogBuilder withDescription(String description) {
		this.description = description;
		return this;
	}

	public LogBuilder withAttachment(String name, String type, String content, Long size) throws Exception {
		this.attachment = File.fileFactory(name, type, content, size);
		return this;
	}

	public Log build() {
		Log log = new Log();
		log.setName(this.name);
		log.setDescription(this.description);
		log.setDate(this.date);
		log.setUuid(this.uuid);
		log.setAttachment(this.attachment);
		log.setCode(this.code);
		log.create();
		return log;
	}

}
