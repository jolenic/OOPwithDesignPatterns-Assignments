
public interface Attachable {

	public void attachFile(String name, String type, String content, Long size) throws Exception;

	public void attachFile(File file) throws Exception;

}
