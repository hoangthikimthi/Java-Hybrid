package javaBasic;

public class Topic_05_Reference {
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
		Topic_05_Reference firstStudent = new Topic_05_Reference();
		Topic_05_Reference secondStudent = new Topic_05_Reference();
		
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
