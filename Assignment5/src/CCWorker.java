
/**
 * 
 */

import com.aws.api.AWSTranscribe;
import com.aws.api.AWSTranscribeProxy;
import com.google.api.GoogleSpeech2Text;
import com.google.api.GoogleSpeech2TextProxy;

/**
 * @author jesus
 *
 */
public class CCWorker implements Runnable {
	private final Recording recording;

	// Constructor to assign a message when creating a new thread
	public CCWorker(Recording recording) {
		this.recording = recording;
	}

	@Override
	/**
	 *
	 */
	public void run() {
		System.out.println(
				Thread.currentThread().getName() + " (Start closed captioning) recording = " + recording.getFileName());
		// Trigger CC using the local methods.
		triggerGoogleClosedCaptioning();
		triggerAWSClosedCaptioning();
		// tell recording to notify observers that CC is finished
		recording.notifyObservers();
		System.out.println(Thread.currentThread().getName() + " (End closed captioning)");
	}

	private void triggerGoogleClosedCaptioning() {
		String rawFile = recording.getMediaFileMock();
		Long fileSize = recording.getFileSize();
		CCAdapter adapter = new CCGoogleAdapter();
		String ccFile = "";
		try {
			ccFile = adapter.getCC(rawFile, fileSize);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		recording.setCcFileMock(ccFile);
		System.out.println(ccFile + " processed using GoogleSpeech2TextAPI");
	}

	private void triggerAWSClosedCaptioning() {
		String rawFile = recording.getMediaFileMock();
		Long fileSize = recording.getFileSize();
		CCAdapter adapter = new CCAWSAdapter();
		String ccFile = "";
		System.out.println("Closed captioning " + rawFile + " will take " + fileSize + " milliseconds...");
		try {
			ccFile = adapter.getCC(rawFile, fileSize);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		recording.setCcFileMock(ccFile);
		System.out.println(ccFile + " processed using AWSTranscribeAPI");
	}

}
