public class Student {

    private String studentName;
    private String regNo;
    private String department;
    private int semester;
    private double gpa;

    public Student(String studentName, String regNo,
            String department, int semester) {

        this.studentName = studentName;
        this.regNo = regNo;
        this.department = department;
        this.semester = semester;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getDepartment() {
        return department;
    }

    public int getSemester() {
        return semester;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void displayStudentInfo() {
        System.out.println("\n===== STUDENT DETAILS =====");
        System.out.println("Name       : " + studentName);
        System.out.println("Register No: " + regNo);
        System.out.println("Department : " + department);
        System.out.println("Semester   : " + semester);
    }
}