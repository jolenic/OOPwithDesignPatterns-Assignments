
public class Main {

	public static void main(String[] args) {
		Log log1;
		Log log2;
		Log log3;
		Log log4;
		Log log5;
		Log log6;

		try {
			// Mock-up logs with non-supported content type
			log1 = new LogBuilder().withName("first log").withDescription("Monday May 3, I had to wake up early")
					.withAttachment("image.tif", "TIF", "******", Long.valueOf(1024)).build();
			System.out.println(">>> New log (" + log1.toString() + ")");
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage() + "\n\n");
		}

		// No longer relevant since there is only 1 Log class!
//        try {
//            // Mock-up logs with incorrect attachment
//            mockLog(new TextLog("fourth log", "And even later, I need to have lunch"), new TextFile("eating.png", "PNG", "******", Long.valueOf(1024)));
//        } catch (Exception e) {
//            System.out.println("Exception: " + e.getMessage() + "\n\n");
//            e.printStackTrace();
//        }

		try {
			// Mock-up logs with correct attachment
			log2 = new LogBuilder().withName("first log").withDescription("Monday May 4, I had to wake up early")
					.withAttachment("image.png", "PNG", "******", Long.valueOf(1024)).build();
			System.out.println(">>> New log (" + log2.toString() + ")\n\n");

			log3 = new LogBuilder().withName("second log")
					.withDescription("Few minutes later, I had my first cup of coffee")
					.withAttachment("coffee.png", "PNG", "******", Long.valueOf(1024)).build();
			System.out.println(">>> New log (" + log3.toString() + ")\n\n");

			log4 = new LogBuilder().withName("third log").withDescription("Few minutes later, I am going for a ride")
					.withAttachment("biking1.mp4", "MP4", "******", Long.valueOf(1024)).build();
			System.out.println(">>> New log (" + log4.toString() + ")\n\n");

			log5 = new LogBuilder().withName("fourth log").withDescription("And even later, I need to have lunch")
					.withAttachment("recipie.txt", "TXT", "******", Long.valueOf(1024)).build();
			System.out.println(">>> New log (" + log5.toString() + ")\n\n");

			log6 = new LogBuilder().withName("final log")
					.withDescription("Here's a quick audio recording of me saying goodbye!")
					.withAttachment("goodbye.mp3", "MP3", "******", Long.valueOf(1024)).build();
			System.out.println(">>> New log (" + log6.toString() + ")\n\n");

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage() + "\n\n");
			e.printStackTrace();
		}

	}

}
