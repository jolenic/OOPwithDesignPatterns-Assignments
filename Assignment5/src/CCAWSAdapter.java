import com.aws.api.AWSTranscribe;
import com.aws.api.AWSTranscribeProxy;

public class CCAWSAdapter implements CCAdapter {

	AWSTranscribe api;

	public String getCC(String rawFile, Long fileSize) throws InterruptedException {

		api = new AWSTranscribeProxy();
		// Simulate the delay.
		System.out.println("Closed captioning " + rawFile + " will take " + fileSize + " milliseconds...");
		// Simulate the delay.
		Thread.sleep(fileSize);
		// MockUp transcript process.
		String client = api.clientCreate();
		String stream = api.getStreamFromFile(rawFile);
		api.startStreamTranscription(client, stream);
		String transcript = api.getResult();
		api.clientClose(client);
		return transcript;
	}

}
