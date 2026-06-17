public class SubjectData {

    private String subject;
    private String credit;
    private String grade;

    public SubjectData(
            String subject,
            String credit,
            String grade) {

        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public String getCredit() {
        return credit;
    }

    public String getGrade() {
        return grade;
    }
}