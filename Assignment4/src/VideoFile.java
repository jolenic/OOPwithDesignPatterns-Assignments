import java.util.Arrays;
import java.util.List;

public class VideoFile extends File {

	public static final List<String> contentTypes = Arrays.asList("MP4", "MPG", "MPEG", "M4V");

	public VideoFile(String name, String type, String content, Long size) {
		super(name, type, content, size);
	}

	@Override
	public void postProcess() {
		System.out.println("This video file is going to be closed captioned");
	}

}
