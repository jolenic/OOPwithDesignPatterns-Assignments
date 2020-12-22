import com.google.api.GoogleSpeech2Text;
import com.google.api.GoogleSpeech2TextProxy;

public class CCGoogleAdapter implements CCAdapter {
	GoogleSpeech2Text api;

	public String getCC(String rawFile, Long fileSize) throws InterruptedException {
		api = new GoogleSpeech2TextProxy();
		// Simulate the delay.
		System.out.println("Closed captioning " + rawFile + " will take " + fileSize + " milliseconds...");
		// Simulate the delay.
		Thread.sleep(fileSize);
		// MockUp transcript process.
		String speechClient = api.instantiateClient();
		String audioBytes = api.fileToMemory(rawFile);
		String config = api.buildSyncRecognizeRequestConfig();
		String audio = api.buildSyncRecognizeRequestAudio();
		api.performSpeechRecognition(config, audio);
		String transcript = api.getFirstTranscriptAlternative();
		return transcript;
	}

}
