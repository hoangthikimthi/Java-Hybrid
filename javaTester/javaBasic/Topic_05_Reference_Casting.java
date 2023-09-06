package javaBasic;

public class Topic_05_Reference_Casting {
public String studentName;
	public String getStudentName() 
	 {
		return studentName;
	 }

	public void SetStudentName(String studentName) {
	this.studentName = studentName;
    }
	
	public void showStudentName() {
		System.out.println("Student name = " + studentName);
	}
	
	public static void main(String[] args) {
		Topic_05_Reference_Casting firstStudent = new Topic_05_Reference_Casting();
		Topic_05_Reference_Casting secondStudent = new Topic_05_Reference_Casting();
		
		firstStudent.SetStudentName("HaNoi");
		secondStudent.SetStudentName("HCM");
		
		firstStudent.showStudentName();
		secondStudent.showStudentName();
		
		//ep kieu
		
		secondStudent = firstStudent;
		
		firstStudent.showStudentName();
		secondStudent.showStudentName();
	
		secondStudent.SetStudentName("Danang");
		
		firstStudent.showStudentName();
		secondStudent.showStudentName();
	}

}
