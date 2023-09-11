package javaOOP;

public abstract class Computer {
	// nomal method
	public void showComputerPerfomance() {
		System.out.println("show computer perfomance");
	}

	// abstract Method nằm trong abstract class
	// khung để cho các class con kế thừa nó phải override
	public abstract void showComputerRam();
}
