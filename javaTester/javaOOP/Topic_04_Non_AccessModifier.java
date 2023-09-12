package javaOOP;

public class Topic_04_Non_AccessModifier {
	// Static: variale/method
	// Dùng cho tất cả các instance/object
	// phạm vi cho toàn bộ system sử dụng nó
	// có thể override được
	static String browserName = "chrome";

	// non Static

	String serverName = "testing";

	public void clickToElement(String element) {
		System.out.println(element);
	}

	public static void sendkeyToElement(String element) {
		System.out.println(element);
	}

	public static void main(String[] args) {
		System.out.println(browserName);
		browserName = "firefox";
		sendkeyToElement("a");

		Topic_04_Non_AccessModifier topic = new Topic_04_Non_AccessModifier();
		topic.serverName = "xyz";
		sendkeyToElement("b");
		topic.clickToElement("c");
	}
}
