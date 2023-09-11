package javaOOP;

public class Topic_01_QuanLySinhVien {
	private int msv;
	private String hoTen;
	private float diemLT;
	private float diemTH;

	private int getMsv() {
		return msv;
	}

	private void setMsv(int msv) {
		this.msv = msv;
	}

	private String getHoTen() {
		return hoTen;
	}

	private void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	private float getDiemLT() {
		return diemLT;
	}

	private void setDiemLT(float diemLT) {
		this.diemLT = diemLT;
	}

	private float getDiemTH() {
		return diemTH;
	}

	private void setDiemTH(float diemTH) {
		this.diemTH = diemTH;
	}

	private Float getDTB() {
		return (this.diemLT + this.diemTH * 2) / 3;
	}

	private void showStudentInfo() {
		System.out.println("************************");
		System.out.println("Student ID " + getMsv());
		System.out.println("Student name " + getHoTen());
		System.out.println("Student DLT " + getDiemLT());
		System.out.println("Student DTH " + getDiemTH());
		System.out.println("Student DTH " + getDTB());
	}

	protected Topic_01_QuanLySinhVien(int msv, String hoTen, float diemLT, float diemTH) {
		this.msv = msv;
		this.hoTen = hoTen;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}

	public static void main(String[] args) {
		Topic_01_QuanLySinhVien sv1 = new Topic_01_QuanLySinhVien(1, "thi", 2.14f, 4.56f);
		sv1.showStudentInfo();
	}
}
