package v2;

import draft.Course;
import v2.courses.CourseSet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CourseSetTest {

    private List<Course> buildCourses(String... courseNames) {
        List<Course> result = new ArrayList<>();
        for (String name : courseNames) {
            result.add(new Course(name, 2, false));
        }
        return result;
    }

    @Test
    public void allTestEmpty() {
        List<Course> courses = buildCourses("CSSE1001", "CSSE2002", "CSSE2310");

        CourseSet courseSet = CourseSet.all();
        assertTrue(courseSet.satisfiedBy(buildCourses()));
        assertTrue(courseSet.satisfiedBy(courses));
    }

    @Test
    public void allTestNotEmpty() {
        CourseSet courseSet = CourseSet.all("CSSE2002");
        assertTrue(courseSet.satisfiedBy(buildCourses("CSSE1001", "CSSE2002", "CSSE2310")));
        assertFalse(courseSet.satisfiedBy(buildCourses("CSSE1001", "CSSE2310")));
    }

    @Test
    public void allTestMultiple() {
        CourseSet courseSet = CourseSet.all("CSSE2002", "CSSE2310");
        assertFalse(courseSet.satisfiedBy(buildCourses()));
        assertFalse(courseSet.satisfiedBy(buildCourses("CSSE2002")));
        assertFalse(courseSet.satisfiedBy(buildCourses("CSSE2310")));
        assertTrue(courseSet.satisfiedBy(buildCourses("CSSE2002", "CSSE2310")));
        assertTrue(courseSet.satisfiedBy(buildCourses("CSSE1001", "CSSE2002", "CSSE2310")));
    }

    @Test
    public void eitherTestEmpty() {
        List<Course> courses = buildCourses("CSSE1001", "CSSE2002", "CSSE2310");

        CourseSet courseSet = CourseSet.either();
        assertFalse(courseSet.satisfiedBy(buildCourses()));
        assertFalse(courseSet.satisfiedBy(courses));
    }

    @Test
    public void eitherTestNotEmpty() {
        List<Course> courses = buildCourses("CSSE1001", "CSSE2002", "CSSE2310");

        CourseSet courseSet = CourseSet.either("CSSE1001", "CSSE2310");

        assertFalse(courseSet.satisfiedBy(buildCourses()));
        assertFalse(courseSet.satisfiedBy(courses));
        assertTrue(courseSet.satisfiedBy(buildCourses("CSSE1001", "CSSE2002")));
    }

    @Test
    public void unionTestEmpty() {
        List<Course> courses = buildCourses("CSSE1001", "CSSE2002", "CSSE2310");

        CourseSet courseSet = CourseSet.all();
        CourseSet union = courseSet.union(courseSet);

        assertTrue(union.satisfiedBy(buildCourses()));
        assertTrue(union.satisfiedBy(courses));
    }

    @Test
    public void unionTestNotEmpty() {
        List<Course> courses = buildCourses("CSSE1001", "CSSE2002", "CSSE2310");

        CourseSet first = CourseSet.all("CSSE1001");
        CourseSet second = CourseSet.all("CSSE2002", "CSSE2310");
        CourseSet union = first.union(second);

        assertFalse(union.satisfiedBy(buildCourses()));
        assertFalse(union.satisfiedBy(buildCourses("CSSE2002",  "CSSE2310")));
        assertTrue(union.satisfiedBy(courses));
    }
}
