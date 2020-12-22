
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Log implements Attachable {

	private String name;
	private String description;
	private Date date;
	private UUID uuid;
	private String code;
	private File attachment;

	public File getAttachment() {
		return attachment;
	}

	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}

	public void create() {
		System.out.println("Log record for " + uuid + " has been created");
	}

	public void read() {
		System.out.println("Log " + uuid + " name:" + name + ", description: " + description + " created on " + date);
	}

	public void update(String name, String description) {
		System.out.println("Log record for " + uuid + " has been updated");
		this.name = name;
		this.description = description;
	}

	public void delete() {
		System.out.println("Log record for " + uuid + " has been deleted");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public Log() {
		this.name = null;
		this.description = null;
		this.date = null;
		this.uuid = null;
		this.code = null;
	}

	public Log(String name) {
		this(name, "");
	}

	public Log(String name, String description) {
		this(name, description, new Date());
	}

	public Log(String name, String description, Date date) {
		this.name = name;
		this.description = description;
		this.date = date;
		this.uuid = UUID.randomUUID();
		this.code = CodeGenerator.getInstance().shortCode();
	}

	public String toString() {
		String out = code + ":" + name + ":" + description + ":" + date;
		if (this.attachment != null) {
			out += " with attachment " + this.attachment.getName();
		}
		return out;
	}

	@Override
	public void attachFile(String name, String type, String content, Long size) throws Exception {
		this.attachment = File.fileFactory(name, type, content, size);
	}

	@Override
	public void attachFile(File file) throws Exception {
		String type = file.getType();
		if (AudioFile.contentTypes.contains(type)) {
			file = (AudioFile) file;
		} else if (ImageFile.contentTypes.contains(type)) {
			file = (ImageFile) file;
		} else if (TextFile.contentTypes.contains(type)) {
			file = (TextFile) file;
		} else if (VideoFile.contentTypes.contains(type)) {
			file = (AudioFile) file;
		} else {
			System.out.println("Invalid file type, cannot process attachment");
			throw new Exception("ContentType " + type + " can not be attached");
		}
		this.setAttachment(file);
		file.postProcess();
	}

}
