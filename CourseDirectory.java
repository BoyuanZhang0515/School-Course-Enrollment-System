
import java.io.*;
import java.util.*;

public class CourseDirectory implements Serializable {
	private School mySchool = new School();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public School getMySchool() {
		return mySchool;
	}

	public void setMySchool(School mySchool) {
		this.mySchool = mySchool;
	}

	public void createCourse() throws IOException {
		ArrayList<Student> lon = new ArrayList<Student>();
		System.out.print("Please enter the course name: ");
		String cn = br.readLine();
		System.out.print("Please enter the course id: ");
		String cid = br.readLine();
		System.out.print("Please enter the maximum number of student: ");
		int ms = Integer.parseInt(br.readLine());
		System.out.print("Please enter the course instructor: ");
		String ci = br.readLine();
		System.out.print("Please enter the course section number: ");
		int csn = Integer.parseInt(br.readLine());
		System.out.print("Please enter the course location: ");
		String cl = br.readLine();
		// Construct a new Course
		Course new_course = new Course(cn, cid, ms, lon, ci, csn, cl);
		// Get the course list from school
		ArrayList<Course> course_list = mySchool.getCourse_list();
		course_list.add(new_course);
		// Add the new course to the course list
		mySchool.setCourse_list(course_list);
		System.out.print("\nYou have successfully created a new course!");
	}

	public int searchCourse(String courseName, String courseId, int section) {
		ArrayList<Course> course_list = mySchool.getCourse_list();
		for (int i = 0; i < course_list.size(); i++) {
			if (course_list.get(i).getCourse_Name().equals(courseName)
					&& course_list.get(i).getCourse_Id().equals(courseId)
					&& course_list.get(i).getCourse_Section_Number() == section) {
				return i;
			}
		}
		return -1;
	}

	public void deleteCourse() throws IOException {
		System.out.print("Please enter the course name: ");
		String courseName = br.readLine();
		System.out.print("Please enter the course id: ");
		String courseId = br.readLine();
		System.out.print("Please enter the course section number: ");
		int section= Integer.parseInt(br.readLine());
		ArrayList<Course> course_list = mySchool.getCourse_list();
		int index = searchCourse(courseName,courseId,section);
		if (index>=0) {
			course_list.remove(index);
		}else {
			System.out.println("Course not found!");
		}
	}

	public void editCourse() throws IOException {
		System.out.print("Please enter the course name: ");
		String courseName = br.readLine();
		System.out.print("Please enter the course id: ");
		String courseId = br.readLine();
		System.out.print("Please enter the course section number: ");
		int section= Integer.parseInt(br.readLine());
		ArrayList<Course> course_list = mySchool.getCourse_list();
		int index = searchCourse(courseName, courseId, section);
		
		if (index >= 0) {
			while (true) {
				System.out.println("Please Enter which part of the course to Edit: ");
				System.out.println("1)Course Instructor");
				System.out.println("2)Maximum number of Students");
				System.out.println("3)Course Location");
				System.out.println("4)Edit list of students");
				System.out.println("5)Exit");
				int command = Integer.parseInt(br.readLine());
				if (command == 1) {
					System.out.print("Please enter the new course instructor: ");
					String ci = br.readLine();
					course_list.get(index).setCourse_Instructor(ci);
				} else if (command == 2) {
					System.out.print("Please enter the new maximum number of student: ");
					int ms = Integer.parseInt(br.readLine());
					course_list.get(index).setMaximum_Students(ms);
				} else if (command == 3) {
					System.out.print("Please enter the course location: ");
					String cl = br.readLine();
					course_list.get(index).setCourse_Location(cl);
				} else if(command == 4) {
					System.out.print("Please enter "
							+ "\n1)Add student to the course"
							+ "\n2)Withdraw student from the course");
					int order = Integer.parseInt(br.readLine());
					switch(order) {
					case 1:
						System.out.print("Please enter the student first name: ");
						String firstName = br.readLine();
						System.out.print("Please enter the student last name: ");
						String lastName = br.readLine();
						Student new_student = findStudent_name(firstName, lastName);
						Course course_r = course_list.get(index);
						ArrayList<Student> course_lon = course_r.getList_Of_Names();

						course_lon.add(new_student);
						course_r.setList_Of_Names(course_lon);
						course_r.setCurrent_Students(course_r.getCurrent_Students()+1);
						course_list.set(index, course_r);
						mySchool.setCourse_list(course_list);
						break;
					case 2:
						System.out.print("Please enter the student first name: ");
						String firstName_2 = br.readLine();
						System.out.print("Please enter the student last name: ");
						String lastName_2 = br.readLine();
						int index_2 = searchCourse(courseName, courseId, section);
						Student new_student_2 = findStudent_name(firstName_2, lastName_2);
						Course course_w = course_list.get(index_2);
						ArrayList<Student> course_lon_2 = course_w.getList_Of_Names();
						for (int i = 0; i < course_lon_2.size(); i++) {
							if (course_lon_2.get(i)==new_student_2){
								course_lon_2.remove(i);
								course_w.setList_Of_Names(course_lon_2);
								course_w.setCurrent_Students(course_w.getCurrent_Students()-1);
								course_list.set(index_2, course_w);
								mySchool.setCourse_list(course_list);
							}
						}
						break;
					}
				} else if (command == 5) {
					break;
				} else {
					System.out.println("Sorry, I don't understand!");
				}
			}
			System.out.println("Finished Editing!");

		}
	}
	public void printCourseInfo() throws IOException {
		System.out.print("Please enter the course name: ");
		String courseName = br.readLine();
		System.out.print("Please enter the course id: ");
		String courseId = br.readLine();
		System.out.print("Please enter the course section number: ");
		int section= Integer.parseInt(br.readLine());
		ArrayList<Course> course_list = mySchool.getCourse_list();
		int index = searchCourse(courseName, courseId, section);
		course_list.get(index).printInfo();
		ArrayList<Student> lon = course_list.get(index).getList_Of_Names();
		for(int i = 0; i<lon.size();i++) {
			System.out.println(lon.get(i).getFirstName()+" "+lon.get(i).getLastName());
		}
	}
	public void createStudent()throws IOException{
		System.out.print("Please enter the student first name: ");
		String firstName = br.readLine();
		System.out.print("Please enter the student last name: ");
		String lastName = br.readLine();
		System.out.print("Please enter the student account username: ");
		String userName = br.readLine();
		System.out.print("Please enter the student account password: ");
		String passWord = br.readLine();
		Student student_new = new Student(userName,passWord,firstName,lastName);
		student_new.getStudent_course().setMySchool(mySchool);
		ArrayList<Student> student_list = mySchool.getStudent_list();
		student_list.add(student_new);
		mySchool.setStudent_list(student_list);
		
	}

	public void Register(Student new_student) throws IOException {
		System.out.print("Please enter the course name: ");
		String courseName = br.readLine();
		System.out.print("Please enter the course id: ");
		String courseId = br.readLine();
		System.out.print("Please enter the course section number: ");
		int section = Integer.parseInt(br.readLine());
		ArrayList<Course> course_list = mySchool.getCourse_list();
		int index = searchCourse(courseName, courseId, section);
		Course course_r = course_list.get(index);
		ArrayList<Student> course_lon = course_r.getList_Of_Names();
		course_lon.add(new_student);
		course_r.setList_Of_Names(course_lon);
		course_r.setCurrent_Students(course_r.getCurrent_Students()+1);
		course_list.set(index, course_r);
		mySchool.setCourse_list(course_list);

	}

	public void Withdraw(Student withdraw_student) throws IOException {
		System.out.print("Please enter the course name: ");
		String courseName = br.readLine();
		System.out.print("Please enter the course id: ");
		String courseId = br.readLine();
		System.out.print("Please enter the course section number: ");
		int section= Integer.parseInt(br.readLine());
		ArrayList<Course> course_list = mySchool.getCourse_list();
		int index = searchCourse(courseName, courseId, section);
		Course course_w = course_list.get(index);
		ArrayList<Student> course_lon = course_w.getList_Of_Names();
		for (int i = 0; i < course_lon.size(); i++) {
			if (course_lon.get(i)==withdraw_student) {
				course_lon.remove(i);
				course_w.setList_Of_Names(course_lon);
				course_w.setCurrent_Students(course_w.getCurrent_Students()-1);
				course_list.set(index, course_w);
				mySchool.setCourse_list(course_list);
			}
		}
		
	}
	public void viewAll() {
		ArrayList<Course> course_list = mySchool.getCourse_list();
		for(int i = 0;i<course_list.size();i++) {
			course_list.get(i).printInfo();
		}
	}
	public void viewAllNotFull() {
		ArrayList<Course> course_list = mySchool.getCourse_list();
		for(int i =0;i<course_list.size();i++) {
			if(course_list.get(i).getMaximum_Students()>course_list.get(i).getCurrent_Students()) {
				course_list.get(i).printInfo();
			}
		}
	}

	// NEED TO TEST!!!!
	public void viewAllRegisterCourse() throws IOException {
		System.out.print("Please enter the student first name: ");
		String firstName = br.readLine();
		System.out.print("Please enter the student last name: ");
		String lastName = br.readLine();		
		Student student_f = findStudent_name(firstName,lastName);
		//System.out.println(student_f.getFirstName());
		viewAllRegisterCourse(student_f);
		/**
		ArrayList<Course> course_list = mySchool.getCourse_list();
		ArrayList<Student> student_list = mySchool.getStudent_list();
		for(int i = 0;i<course_list.size();i++) {
			Course course_v = course_list.get(i);
			ArrayList<Student> lon_v = course_v.getList_Of_Names();
			if(lon_v.contains(student_f)) {
				course_v.printInfo();
				
			}
			
		}
		**/
	}
	public void viewAllRegisterCourse(Student student_login) throws IOException {
		ArrayList<Course> course_list = mySchool.getCourse_list();
		for (int i = 0; i < course_list.size(); i++) {
			Course course_v = course_list.get(i);
			ArrayList<Student> lon_v = course_v.getList_Of_Names();
			if(lon_v.contains(student_login)) {
				course_v.printInfo();
				
			}

		}
	}
	public void viewCourseStudent()throws IOException{
		System.out.print("Please enter the course name: ");
		String courseName = br.readLine();
		System.out.print("Please enter the course id: ");
		String courseId = br.readLine();
		System.out.print("Please enter the course section number: ");
		int section= Integer.parseInt(br.readLine());
		ArrayList<Course> course_list = mySchool.getCourse_list();
		int index = searchCourse(courseName, courseId, section);
		Course course_v = course_list.get(index);
		ArrayList<Student> lon_v = course_v.getList_Of_Names();
		for(int i = 0; i<lon_v.size();i++) {
			System.out.println(lon_v.get(i).getFirstName()+" "+lon_v.get(i).getLastName());
		}
		
	}
	
	public void writeFullToFile() throws IOException {
		String fileName = "FullCourses.txt";
		ArrayList<Course> course_list = mySchool.getCourse_list();
		
		Writer mw = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("src/FullCourses.txt"), "utf-8"));
			try {
			
			for (int i = 0; i < course_list.size(); i++) {
				
				if (course_list.get(i).getMaximum_Students() == course_list.get(i).getCurrent_Students()) {

					mw.write(course_list.get(i).getCourse_Name()+"\n");
					mw.flush();
				}
				
			}
		} catch (IOException ex) {
			System.out.println("Error writing file '" + fileName + "'");
			ex.printStackTrace();
		}
			
	}
	
	public void viewAllFull() {
		ArrayList<Course> course_list = mySchool.getCourse_list();
		for(int i = 0; i<course_list.size();i++) {
			if (course_list.get(i).getMaximum_Students()
					==course_list.get(i).getCurrent_Students()) {
				course_list.get(i).printInfo();
			}
		}
		
	}
	public void studentNameCourse() throws IOException {
		System.out.print("Please enter the course name: ");
		String courseName = br.readLine();
		System.out.print("Please enter the course id: ");
		String courseId = br.readLine();
		System.out.print("Please enter the course section number: ");
		int section= Integer.parseInt(br.readLine());
		ArrayList<Course> course_list = mySchool.getCourse_list();
		int index = searchCourse(courseName, courseId, section);
		Course course = course_list.get(index);
		ArrayList<Student> lon = course.getList_Of_Names();
		for(int i = 0; i<lon.size(); i++) {
			String firstName = lon.get(i).getFirstName();
			String lastName = lon.get(i).getLastName();
			System.out.println("\nStudent: "+firstName+" "+lastName);
		}
	}
	public void sortCourse() {
		ArrayList<Course> course_list = mySchool.getCourse_list();
		for(int i = 0; i<course_list.size();i++) {
			for (int j = 0;j<course_list.size();j++) {
				if(course_list.get(j).getCurrent_Students()<course_list.get(i).getCurrent_Students()) {
					Course temp = course_list.get(i);
					course_list.set(i,course_list.get(j));
					course_list.set(j,temp);					
				}
			}
			
			
		}
		mySchool.setCourse_list(course_list);
		System.out.println("Sorted sucessfully!");
	}
	public Student findStudent(String u, String p) {
		ArrayList<Student> student_list = mySchool.getStudent_list();
		for(int i = 0; i<student_list.size();i++) {
			//System.out.println(student_list.get(i).getFirstName());
			if(student_list.get(i).getUserName().equals(u)
					&& student_list.get(i).getPassWord().equals(p)) {
				System.out.println("\nLogin as a Student!");
				return student_list.get(i);
			}
		}
		return null;
		
	}
	public Student findStudent_name(String firstName, String lastName) {
		ArrayList<Student> student_list = mySchool.getStudent_list();
		for(int i = 0; i<student_list.size();i++) {
			if(student_list.get(i).getFirstName().equals(firstName)
					&& student_list.get(i).getLastName().equals(lastName)) {
				return student_list.get(i);
			}
		}
		return null;
		
	}
}
