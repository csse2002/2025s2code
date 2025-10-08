package v2.courses;

import draft.Course;

import java.util.*;

public interface CourseSet {
    static CourseSet all(String... courses) {
        return new AllCourses(fromNames(courses));
    }

    static CourseSet either(String... courses) {
        return new EitherCourses(fromNames(courses));
    }

    private static Course[] fromNames(String... names) {
        List<Course> asCourses = new ArrayList<>();
        for (String courseName : names) {
            asCourses.add(new Course(courseName, 2, false));
        }
        return asCourses.toArray(new Course[0]);
    }

    default CourseSet union(CourseSet other) {
        return new UnionCourses(this, other);
    }

    boolean satisfiedBy(List<Course> course);

    boolean contains(Course course);

}

