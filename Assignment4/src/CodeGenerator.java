import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CodeGenerator {

	private List<String> generatedCodes;
	private static CodeGenerator instance;

	private CodeGenerator() {
		this.generatedCodes = new ArrayList<String>();
	}

	synchronized public static CodeGenerator getInstance() {
		if (instance == null) {
			instance = new CodeGenerator();
		}
		return instance;
	}

	public String shortCode() {
		String code;
		do {
			code = randomChars(3) + "-" + randomChars(3) + "-" + randomChars(3);
		} while (generatedCodes.contains(code));
		generatedCodes.add(code);
		return code;
	}

	private String randomChars(int n) {
		String randomchars = "";
		String chars = "abcdefghijklmnopqrstuvwxyz1234567890";
		Random rnd = new Random();
		for (int i = 0; i < n; i++) {
			randomchars += chars.charAt(rnd.nextInt(chars.length()));
		}
		return randomchars;
	}

}
