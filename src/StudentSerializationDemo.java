import java.io.*;

public class StudentSerializationDemo {
    public static void main(String[] args) {
        Student student = new Student(101, "John Doe", 3.8);
        String filename = "student.ser";

        // Serialize
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(student);
            System.out.println("Student details saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize
        System.out.println("\nReading from file...");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Student s = (Student) in.readObject();
            System.out.println("Student ID: " + s.getId());
            System.out.println("Student Name: " + s.getName());
            System.out.println("Student GPA: " + s.getGpa());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
