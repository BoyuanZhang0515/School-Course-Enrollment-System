
import java.io.*;
import java.util.*;

public class Course implements Serializable {
	private String Course_Name = null;
	private String Course_Id = null;
	private int Maximum_Students = 0;
	private int Current_Students = 0;
	private ArrayList<Student> List_Of_Names = new ArrayList<Student>();
	private String Course_Instructor = null;
	private int Course_Section_Number = 0;
	private String Course_Location = null;
	
	// Constructor
	public Course(String cn, String cid, int ms,
			ArrayList<Student> lon, String ci, int csn, String cl) {
		this.Course_Name = cn;
		this.Course_Id = cid;
		this.Maximum_Students = ms;
		this.Current_Students = lon.size();
		this.List_Of_Names = lon;
		this.Course_Instructor = ci;
		this.Course_Section_Number = csn;
		this.Course_Location = cl;
	}

	public String getCourse_Name() {
		return Course_Name;
	}

	public void setCourse_Name(String course_Name) {
		Course_Name = course_Name;
	}

	public String getCourse_Id() {
		return Course_Id;
	}

	public void setCourse_Id(String course_Id) {
		Course_Id = course_Id;
	}

	public int getMaximum_Students() {
		return Maximum_Students;
	}

	public void setMaximum_Students(int maximum_Students) {
		Maximum_Students = maximum_Students;
	}

	public int getCurrent_Students() {
		return Current_Students;
	}

	public void setCurrent_Students(int current_Students) {
		Current_Students = current_Students;
	}

	public ArrayList<Student> getList_Of_Names() {
		return List_Of_Names;
	}

	public void setList_Of_Names(ArrayList<Student> list_Of_Names) {
		List_Of_Names = list_Of_Names;
	}

	public String getCourse_Instructor() {
		return Course_Instructor;
	}

	public void setCourse_Instructor(String course_Instructor) {
		Course_Instructor = course_Instructor;
	}

	public int getCourse_Section_Number() {
		return Course_Section_Number;
	}

	public void setCourse_Section_Number(int course_Section_Number) {
		Course_Section_Number = course_Section_Number;
	}

	public String getCourse_Location() {
		return Course_Location;
	}

	public void setCourse_Location(String course_Location) {
		Course_Location = course_Location;
	}
	public void printInfo() {
		System.out.println("\nCourse Name: "+this.Course_Name
				+"\nCourse Id: "+this.Course_Id
				+"\nMaximum Student: "+this.Maximum_Students
				+"\nCurrent Students: "+this.Current_Students 
				+"\nCourse Instructor: "+this.Course_Instructor
				+"\nCourse Section Number: "+this.Course_Section_Number
				+"\nCourse Location: "+this.Course_Location);
		
	}
}
