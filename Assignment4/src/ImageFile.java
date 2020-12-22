import java.util.Arrays;
import java.util.List;

public class ImageFile extends File {

	public static final List<String> contentTypes = Arrays.asList("PNG", "JPG", "GIF", "SVG");

	public ImageFile(String name, String type, String content, Long size) {
		super(name, type, content, size);

	}

	@Override
	public void postProcess() {

		System.out.println("This image file is going to be described");
	}

}
