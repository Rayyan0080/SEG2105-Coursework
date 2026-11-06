public class Student implements Comparable<Student> {
    private final String studentId;
    private final String firstName;
    private final String lastName;
    private final double averageGrade;

    public Student(String studentId, String firstName, String lastName, double averageGrade) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.averageGrade = averageGrade;
    }

    public String getStudentId() { return studentId; }
    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName; }
    public double getAverageGrade() { return averageGrade; }

    // Natural order: by studentId (alphabetical/lexicographic)
    @Override
    public int compareTo(Student other) {
        return this.studentId.compareTo(other.studentId);
    }

    @Override
    public String toString() {
        return "Student{studentId='" + studentId + "', firstName='" + firstName +
               "', lastName='" + lastName + "', averageGrade=" +
               String.format("%.2f", averageGrade) + "}";
    }
}
