
import java.io.*;
import java.util.*;

public class School implements Serializable {
	private ArrayList<Course> course_list = null;
	private ArrayList<Student> student_list = null;
	private static Admin admin = new Admin("Admin", "Admin001","Tom", "Zhang");

	// Default
	public School() {

	}

	// Constructor
	public School(ArrayList<Course> course_list, ArrayList<Student> student_list) {
		this.course_list = course_list;
		this.student_list = student_list;
	}

	public ArrayList<Course> getCourse_list() {
		return course_list;
	}

	public void setCourse_list(ArrayList<Course> course_list) {
		this.course_list = course_list;
	}

	public ArrayList<Student> getStudent_list() {
		return student_list;
	}

	public void setStudent_list(ArrayList<Student> student_list) {
		this.student_list = student_list;
	}

	// Main
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Course> course_list_school = new ArrayList<Course>();
		ArrayList<Student> student_list_school = new ArrayList<Student>();
		
		System.out.println("Is this the first time the program starts(Enter 1 or 2)?"
				+ "\n1)YES: This initialized the Program from csv."
				+ "\n2)No: This reads from ser.");
		
		int firstTime = Integer.parseInt(br.readLine());
		// Serialization
		if (firstTime!=1) {
			course_list_school = SerializationCoder.deserializeCourse();
			student_list_school = SerializationCoder.deserializeStudent();

		} else {
			// Read data from csv file
			String fileName = "src/MyUniversityCoursesFile.csv";

			String line = null;
			int n = 0;
			try {

				FileReader fr = new FileReader(fileName);
				BufferedReader buffer = new BufferedReader(fr);
				while ((line = buffer.readLine()) != null) {
					String[] mysplit = line.split(",");
					if (n > 0) {
						Course course = new Course(mysplit[0], mysplit[1], Integer.parseInt(mysplit[2]),
								new ArrayList<Student>(), mysplit[5], Integer.parseInt(mysplit[6]), mysplit[7]);
						course_list_school.add(course);
					}
					n++;

				}
				buffer.close();
			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
			} catch (IOException ioe) {
				ioe.printStackTrace();
				return;
			}
		}

		// Create School
		School mySchool = new School(course_list_school,student_list_school);
		admin.getAdmin_course().setMySchool(mySchool);
		
		System.out.println("Welcome to Albert!");
		boolean flag_albert = true;
		while (flag_albert) {
			System.out.println("\nPlease Login with your Username and Password"
					+ "(Type 'Exit'or'exit' in either username or password to exit)" 
					+ "\nUsername: ");
			String u = br.readLine();
			System.out.println("Password: ");
			String p = br.readLine();
			// Admin
			if (u.equals("Admin") && p.equals("Admin001")) {
				System.out.println("Login as an Admin!");
				boolean flag_admin = true;
				while(flag_admin) {
				System.out.println("\nPlease enter to choose" 
						+ "\n1)Courses Management" 
						+ "\n2)Report"
						+ "\n3)Exit");
				int order_admin = Integer.parseInt(br.readLine());
				switch (order_admin) {
				case 1:
					boolean flag_admin_course = true;
					while (flag_admin_course) {
						System.out.println("\nWelcome to the Admin Courses Management Panel!");
						System.out.println("\nPlease enter to choose" 
								+ "\n1)Create a new course"
								+ "\n2)Delete a course" 
								+ "\n3)Edit a course"
								+ "\n4)Display information of a given course" 
								+ "\n5)Register a student" 
								+ "\n6)Exit");
						int command_admin_course = Integer.parseInt(br.readLine());
						switch (command_admin_course) {
						case 1:
							admin.createCourse_admin();
							break;
						case 2:
							admin.deleteCourse_admin();
							break;							
						case 3:
							admin.editCourse_admin();
							break;
						case 4:
							admin.printCourseInfo_admin();
							break;
						case 5:
							admin.createStudent_admin();
							break;
						case 6:
							System.out.println("Exit sucessfully!");
							flag_admin_course = false;
							break;
						}
					}
					break;
				case 2:
					boolean flag_admin_report = true;
					while(flag_admin_report) {
						System.out.println("\nWelcome to the Admin Report Panel!");
						System.out.println("\nPlease enter to choose" 
								+ "\n1)View all courses"
								+ "\n2)View all courses that are full" 
								+ "\n3)Write to a file the list of course that are full"
								+ "\n4)View the names of the students being registered in a specific course" 
								+ "\n5)View the list of courses that a given student is being registered on" 
								+ "\n6)Sort courses based on the current number of student registers"
								+ "\n7)Exit");
						int command_admin_report = Integer.parseInt(br.readLine());
						switch(command_admin_report) {
						case 1:
							admin.viewAll_admin();
							break;
						case 2:
							admin.viewAllFull_admin();
							break;
						case 3:
							admin.writeFullToFile_admin();
							break;
						case 4:
							admin.viewCourseStudent();
							break;
						case 5:
							admin.viewAllRegisterCourse_admin();
							break;
						case 6:
							admin.sortCourse_admin();
							break;
						case 7:
							System.out.println("Exit sucessfully!");
							flag_admin_report = false;
							break;
						}
					}
					break;
				case 3:
					System.out.println("Exit successully!");
					flag_admin = false;
					break;
				
				}
				
				}
			} else if(u.equals("Exit")||p.equals("Exit")||u.equals("exit")||p.equals("exit")){
				System.out.println("Thanks for using!\nBYE BYE!");
				
				course_list_school = admin.getAdmin_course().getMySchool().getCourse_list();
				student_list_school = admin.getAdmin_course().getMySchool().getStudent_list();
				//System.out.println(course_list_school.size());
				//System.out.println(student_list_school.size());
				//System.out.println(student_list_school.get(0).getFirstName());
				SerializationCoder.serializeCourse(course_list_school);
				SerializationCoder.serializeStudent(student_list_school);
				break;				
			} else {
				// Student
				Student student_login = admin.findStudent(u, p);
				if(student_login!=null) {
					student_login.getStudent_course().setMySchool(mySchool);
					boolean flag_student_course = true;
					while(flag_student_course) {
						System.out.println("\nWelcome to the Student Courses Management Panel!");
						System.out.println("\nPlease enter to choose" 
								+ "\n1)View all courses"
								+ "\n2)View all courses that are not full" 
								+ "\n3)Register on a course"
								+ "\n4)Withdraw from a course" 
								+ "\n5)View all the courses being registered in" 
								+ "\n6)Exit");
						int command_student_course = Integer.parseInt(br.readLine());
						switch(command_student_course) {
						case 1:
							student_login.viewAll_student();
							break;
						case 2:
							student_login.viewAllNotFull_student();
							break;
						case 3:
							student_login.Register_student(student_login);
							break;
						case 4:
							student_login.Withdraw_student(student_login);
							break;
						case 5:
							student_login.viewAllRegisterCourse_student(student_login);
							break;
						case 6:
							System.out.println("Exit sucessfully!");
							flag_student_course = false;
							break;
							
						}
					}
				
						
				
				}else {
					System.out.println("User does not exist!");
				}
			
				
				
			}
		}

	}

}

