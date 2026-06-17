import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public void saveReport(Student student, double gpa) {

        try {

            FileWriter writer = new FileWriter("student_report.txt", true);

            writer.write("\n========================\n");
            writer.write("STUDENT ACADEMIC REPORT\n");
            writer.write("----------------------------\n");
            writer.write("Name: " + student.getStudentName() + "\n");
            writer.write("Register No: " + student.getRegNo() + "\n");
            writer.write("Department: " + student.getDepartment() + "\n");
            writer.write("Semester: " + student.getSemester() + "\n");
            writer.write("GPA: " + String.format("%.2f", gpa) + "\n");
            writer.close();

            System.out.println(
                    "\nReport saved successfully!");

        } catch (IOException e) {

            System.out.println(
                    "Error while saving report.");
        }
    }
}