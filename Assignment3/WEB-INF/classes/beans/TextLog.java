package beans;

import java.util.Scanner;

public class TextLog extends Log {

	private String content;
	private static Scanner input = new Scanner(System.in);

	public TextLog(String title, String content) {
		super(title);
		this.content = content;
	}

	// gets user input for title and content
	public static TextLog createTextLog() {
		System.out.println("Enter TextLog Title: ");
		String title = input.nextLine();
		System.out.println("Enter TextLog Content: ");
		String content = input.nextLine();
		return new TextLog(title, content);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void display() {
		System.out.println("Log type: TextLog");
		System.out.println("ID: " + super.getId());
		System.out.println("Timestamp: " + super.getCreateTimestamp());
		System.out.println("Title: " + super.getTitle());
		System.out.println("Content: " + content);
	}

	// toString() with HTML formatting
	public String toHTMLString() {
		String result = "<p>Log Type: TextLog</p><p>ID: " + super.getId() + "</p><p> Timestamp: "
				+ super.getCreateTimestamp() + "</p><p>Title: " + super.getTitle() + "</p><p>Content: " + content
				+ "</p>";
		return result;
	}

} // end class TextLog
