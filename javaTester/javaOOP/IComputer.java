package javaOOP;

public interface IComputer {
	// trong interface bắt buộc là abtract method
	// nếu không gán từ khóa là abstract cho hàm thì tự hiểu đây vẫn là 1 hàm abstract
	public void showComputerPerfomance();

	public abstract void showComputerRam();

}
