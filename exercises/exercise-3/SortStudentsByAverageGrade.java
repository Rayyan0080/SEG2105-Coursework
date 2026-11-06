import java.util.Comparator;

public class SortStudentsByAverageGrade implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        // Descending order: higher average first
        return Double.compare(b.getAverageGrade(), a.getAverageGrade());
    }
}