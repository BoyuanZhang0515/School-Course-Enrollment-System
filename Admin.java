import java.io.IOException;
import java.util.ArrayList;

public class Admin extends User implements Admin_interface {
	private CourseDirectory admin_course = new CourseDirectory();
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
	// Default
	public Admin() {
		super();
	}
	
	// Constructor
	public Admin(String u, String p, String f, String l) {
		super(u, p, f, l);
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

	public CourseDirectory getAdmin_course() {
		return admin_course;
	}

	public void setAdmin_course(CourseDirectory admin_course) {
		this.admin_course = admin_course;
	}

	// Courses Management
	public void createCourse_admin() throws IOException {
		admin_course.createCourse();
	}

	public void deleteCourse_admin() throws IOException {
		admin_course.deleteCourse();
	}

	public void editCourse_admin() throws IOException {
		admin_course.editCourse();
	}
	

	public void printCourseInfo_admin() throws IOException {
		admin_course.printCourseInfo();
	}

	public void createStudent_admin() throws IOException {
		admin_course.createStudent();
	}

	// Reports
	public void viewAll_admin() {
		admin_course.viewAll();
	}

	public void viewAllFull_admin() {
		admin_course.viewAllFull();
	}

	public void writeFullToFile_admin() throws IOException {
		admin_course.writeFullToFile();
	}

	public void studentNameCourse_admin() throws IOException {
		admin_course.studentNameCourse();
	}
	public void viewCourseStudent()throws IOException{
		admin_course.viewCourseStudent();
	}
	public void viewAllRegisterCourse_admin() throws IOException {
		admin_course.viewAllRegisterCourse();
	}

	public void sortCourse_admin() {
		admin_course.sortCourse();
	}
	public Student findStudent(String u, String p) {
		return admin_course.findStudent(u, p);
	}
	public void printUserInfo() {
		System.out.print("Admin: "+"FIRSTNAME: "+this.firstName+"\nLASTNAME: "+this.lastName+"\n");
	}
	public void printPassword() {
		System.out.print("Student: "+"Password: "+this.passWord);
	}
}
