package v2.courses;

import draft.Course;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class EitherCourses implements CourseSet {
    private final List<Course> eitherCourses;

    EitherCourses(Course... courses) {
        this.eitherCourses = Arrays.asList(courses);
    }

    @Override
    public boolean satisfiedBy(List<Course> courses) {
        Set<Course> courseSet = new HashSet<>(courses);
        int foundCount = 0;
        for (Course course : eitherCourses) {
            if (courseSet.contains(course)) {
                foundCount++;
            }
        }
        return foundCount == 1;
    }

    @Override
    public boolean contains(Course course) {
        return eitherCourses.contains(course);
    }
}
