import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializationCoder {
	public static ArrayList<Course> deserializeCourse() {
		ArrayList<Course> course_list_ser = null;
		try {
			// FileInputSystem recieves bytes from a file
			FileInputStream fis = new FileInputStream("School_course.ser");

			// ObjectInputStream does the deserialization-- it reconstructs the data into an
			// object
			ObjectInputStream ois = new ObjectInputStream(fis);

			// Cast as Employee. readObject will take the object from ObjectInputStream
			course_list_ser = (ArrayList<Course>) ois.readObject();
			ois.close();
			fis.close();
			return course_list_ser;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			return null;
		}
	}

	public static ArrayList<Student> deserializeStudent() {
		ArrayList<Student> student_list_ser = null;
		try {
			// FileInputSystem recieves bytes from a file
			FileInputStream fis = new FileInputStream("School_student.ser");

			// ObjectInputStream does the deserialization-- it reconstructs the data into an
			// object
			ObjectInputStream ois = new ObjectInputStream(fis);

			// Cast as Employee. readObject will take the object from ObjectInputStream
			student_list_ser = (ArrayList<Student>) ois.readObject();
			ois.close();
			fis.close();
			return student_list_ser;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			return null;
		}
	}

	public static void serializeStudent(ArrayList<Student> student_list) {

		try {
			// FileOutput Stream writes data to a file
			FileOutputStream fos = new FileOutputStream("School_student.ser");

			// ObjectOutputStream writes objects to a stream (A sequence of data)
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// Writes the specific object to the OOS
			oos.writeObject(student_list);

			// Close both streams
			oos.close();
			fos.close();
			System.out.println("Serialization complete");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void serializeCourse(ArrayList<Course> course_list) {
		try {
			// FileOutput Stream writes data to a file
			FileOutputStream fos = new FileOutputStream("School_course.ser");

			// ObjectOutputStream writes objects to a stream (A sequence of data)
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// Writes the specific object to the OOS
			oos.writeObject(course_list);

			// Close both streams
			oos.close();
			fos.close();
			System.out.println("Serialization complete");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
