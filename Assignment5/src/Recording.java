
/**
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Recording implements Observable {
	@SuppressWarnings("unused")
	private UUID uuid;
	private String fileName;
	private Long fileSize;
	private String mediaFileMock;
	private String ccFileMock;
	public List<Observer> observers;

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the fileSize
	 */
	public Long getFileSize() {
		return fileSize;
	}

	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getMediaFileMock() {
		return mediaFileMock;
	}

	public void setMediaFileMock(String mediaFileMock) {
		this.mediaFileMock = mediaFileMock;
	}

	public String getCcFileMock() {
		return ccFileMock;
	}

	public void setCcFileMock(String ccFileMock) {
		this.ccFileMock = ccFileMock;
	}

	/**
	 * @param uuid
	 * @param fileName
	 * @param fileSize
	 */
	public Recording(UUID uuid, String fileName, Long fileSize) {
		super();
		this.uuid = uuid;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.mediaFileMock = fileName;
		this.observers = new ArrayList<Observer>();
	}

	// adds an observer object to the list of observers
	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	// removes an observer object from the list of observers
	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	// notifies all observers of the changes by calling update method
	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

}
