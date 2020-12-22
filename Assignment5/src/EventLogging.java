
public class EventLogging extends Observer {
	private Recording subject;

	// creates object with designated observable subject, adds itself to the
	// subject's list of observers
	public EventLogging(Recording subject) {
		this.subject = subject;
		subject.addObserver(this);
	}

	public void update() {
		System.out.println("EVENT LOGGING - CC finished for recording: " + subject.getFileName());
	}

}
