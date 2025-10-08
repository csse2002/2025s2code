package v2.courses;

import draft.Course;

import java.util.Arrays;
import java.util.List;

class UnionCourses implements CourseSet {
    private final List<CourseSet> sets;

    UnionCourses(CourseSet... courses) {
        this.sets = Arrays.asList(courses);
    }

    @Override
    public boolean satisfiedBy(List<Course> courses) {
        return sets.stream().allMatch(set -> set.satisfiedBy(courses));
    }

    @Override
    public boolean contains(Course course) {
        return sets.stream().anyMatch(set -> set.contains(course));
    }
}
