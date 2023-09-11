package javaOOP;

public class Topic_02_Variable_Property_Method {
	static String c;
	static int b;
	// biến global
	// Biến static có thể dùng trong hàm static mà không cần khởi tạo đối tượng. Gọi trực tiếp từ class.
	public static String studentAddress = "Ho Chi Minh";
	private static String studentPhone = " 0987654321";

	// Biến final không cho phép gán lại
	final String country = "VietNam";

	// static final: hằng số không thể ghi đè và có thể truy cập
	static final float pi_number = 3.25222f;
	private String a = "a";

	public void TC01(String a) {
		System.out.println(a);
	}

	public static void main(String[] args) {
		studentAddress = "hanoi";
		studentPhone = "123456789";
		// Biến global luôn có giá trị mặc định, biến local không có giá trị mặc định
		System.out.println(c);
		System.out.println(b);

	}

}
