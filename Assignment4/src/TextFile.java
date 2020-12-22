import java.util.Arrays;
import java.util.List;

public class TextFile extends File {

	public static final List<String> contentTypes = Arrays.asList("DOC", "TXT", "PDF");

	public TextFile() {
	}

	public TextFile(String name, String type, String content, Long size) {
		super(name, type, content, size);
	}

	@Override
	public void postProcess() {
		// trigger translation
		System.out.println("This text file is going to be translated");
	}

}
