import java.util.Comparator;

public class SortStudentsByLastName implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return a.getLastName().compareTo(b.getLastName());
    }
}