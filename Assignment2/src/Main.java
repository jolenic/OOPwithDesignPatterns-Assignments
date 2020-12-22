import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        // creating test Recordings
        Recording test1 = new Recording("Test1", 123, "audio", "1:23", "I'm test1!");
        Recording test2 = new Recording("Test2-Photo", 456, "photo", "N/A", "A picture of a cat");
        Recording test3 = new Recording("Test3", 789, "audio", "1:23", "I'm test3!");
        Recording test4 = new Recording("Test4", 111, "video", "1:23", "I'm test4!");
        Recording test5 = new Recording("Test5", 222, "audio", "1:23", "I'm test5!");
        Recording test6 = new Recording("Test6", 333, "video", "1:23", "I'm test6!");
        Recording test7 = new Recording("Test7", 444, "audio", "1:23", "I'm test7!");
        Recording test8 = new Recording("Test8", 555, "video", "1:23", "I'm test8!");
        Recording test9 = new Recording("Test9", 666, "audio", "1:23", "I'm test9!");
        Recording test10 = new Recording("Test10", 777, "video", "1:23", "I'm test10!");

        // creating captioner objects using the Recordings
        Captioner c1 = new Captioner(test1);
        Captioner c2 = new Captioner(test2);
        Captioner c3 = new Captioner(test3);
        Captioner c4 = new Captioner(test4);
        Captioner c5 = new Captioner(test5);
        Captioner c6 = new Captioner(test6);
        Captioner c7 = new Captioner(test7);
        Captioner c8 = new Captioner(test8);
        Captioner c9 = new Captioner(test9);
        Captioner c10 = new Captioner(test10);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.execute(c1);
        executor.execute(c2);
        executor.execute(c3);
        executor.execute(c4);
        executor.execute(c5);
        executor.execute(c6);
        executor.execute(c7);
        executor.execute(c8);
        executor.execute(c9);
        executor.execute(c10);

        executor.shutdown();

    }

}
