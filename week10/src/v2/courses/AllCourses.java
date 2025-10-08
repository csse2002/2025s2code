package v2.courses;

import draft.Course;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class AllCourses implements CourseSet {
    private final List<Course> allCourses;

    AllCourses(Course... courses) {
        this.allCourses = Arrays.asList(courses);

    }

    @Override
    public boolean satisfiedBy(List<Course> courses) {
        Set<Course> courseSet = new HashSet<>(courses);
        for (Course course : allCourses) {
            if (!courseSet.contains(course)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contains(Course course) {
        return allCourses.contains(course);
    }
}
