package draft;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GraduationTest {
    private Student student;
    private Degree degree;

    @Before
    public void setUp() {
        // Assume that a student only has to take 12 units (6 courses) in their degree
        // 8 units of core courses
        // 2 to 4 units of plan options
        // 0 to 4 units of breadth electives
        // 0 to 4 units of program electives
        // 0 to 2 units of general electives
        List<Course> compulsoryCourses = List.of(
                new Course("CSSE1001", 2, true),
                new Course("CSSE2002", 2, true),
                new Course("CSSE2310", 2, true),
                new Course("CSSE6400", 2, true)
        );
        List<Course> planOptions = List.of(
                new Course("CSSE3100", 2, false),
                new Course("COMP3400", 2, false)
        );
        List<Course> breadthElectives = List.of(
                new Course("MATH2302", 2, false),
                new Course("MATH3306", 2, false)
        );
        List<Course> programElectives = new ArrayList<>(planOptions);
        programElectives.addAll(breadthElectives);
        List<Course> generalElectives = List.of(
                new Course("PHIL2110", 2, false)
        );
        student = new Student();
        degree = new Degree(compulsoryCourses, planOptions, breadthElectives, programElectives, generalElectives);
    }

    private void takeCompulsoryCourses(Student student) {
        student.take(new Course("CSSE1001", 2, true));
        student.take(new Course("CSSE2002", 2, false));
        student.take(new Course("CSSE2310",2, true));
        student.take(new Course("CSSE6400", 2, false));
    }

    @Test
    public void onlyTakesCompulsory() {
        takeCompulsoryCourses(student);
        assertFalse(student.canGraduate(degree));
    }


    @Test
    public void takesCompulsoryPlusTooManyGeneral() {
        takeCompulsoryCourses(student);

        student.take(new Course("PHIL2110", 2, false));
        student.take(new Course("PHIL1110", 2, false));

        assertFalse(student.canGraduate(degree));
    }

    @Test
    public void missesOneCompulsory() {
        student.take(new Course("CSSE1001", 2, true));
        student.take(new Course("CSSE2310",2, true));
        student.take(new Course("CSSE6400", 2, false));

        student.take(new Course("CSSE3100", 2, false));
        student.take(new Course("CSSE3400", 2, false));
        student.take(new Course("MATH3306", 2, false));

        assertFalse(student.canGraduate(degree));
    }

    @Test
    public void takesFullPlan() {
        takeCompulsoryCourses(student);

        student.take(new Course("CSSE3100", 2, false));
        student.take(new Course("COMP3400", 2, false));

        assertTrue(student.canGraduate(degree));
    }

    @Test
    public void takesHalfPlan() {
        takeCompulsoryCourses(student);

        student.take(new Course("CSSE3100", 2, false));
        student.take(new Course("MATH3306", 2, false));

        assertTrue(student.canGraduate(degree));
    }

    @Test
    public void cannotGraduateTest() {
        student.take(new Course("CSSE1001", 2, true));
        student.take(new Course("CSSE2310",2, true));
        student.take(new Course("CSSE6400", 2, false));

        assertFalse(student.canGraduate(degree));
    }

}
