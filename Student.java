
import java.io.*;
import java.util.*;
public class Student extends User implements Student_interface,Serializable {
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
	private ArrayList<Course> student_course_list = new ArrayList<Course>();
	private CourseDirectory student_course = new CourseDirectory();
	// Default
	public Student() {
		
	}

	// Constructor
	public Student(String u, String p,String f, String l) {
		super(u,p,f,l);
		this.userName = u;
		this.passWord = p;
		this.firstName = f;
		this.lastName = l;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ArrayList<Course> getStudent_course_list() {
		return student_course_list;
	}

	public void setStudent_course_list(ArrayList<Course> student_course_list) {
		this.student_course_list = student_course_list;
	}
	
	public CourseDirectory getStudent_course() {
		return student_course;
	}

	public void setStudent_course(CourseDirectory student_course) {
		this.student_course = student_course;
	}

	// Courses Management
	public void viewAll_student() {
		student_course.viewAll();
	}

	public void viewAllNotFull_student() {
		student_course.viewAllNotFull();
	}

	public void Register_student(Student new_student) throws IOException {
		student_course.Register(new_student);
	}

	public void Withdraw_student(Student withdraw_student) throws IOException {
		student_course.Withdraw(withdraw_student);
	}

	public void viewAllRegisterCourse_student() throws IOException {
		student_course.viewAllRegisterCourse();
	}
	public void viewAllRegisterCourse_student(Student student_login) throws IOException{
		student_course.viewAllRegisterCourse(student_login);
	}
	public void printUserInfo() {
		System.out.print("Student: "+"FIRSTNAME: "+this.firstName+"\nLASTNAME: "+this.lastName+"\n");
	}
	public void printPassword() {
		System.out.print("Student: "+"Password: "+this.passWord);
	}
	
}
