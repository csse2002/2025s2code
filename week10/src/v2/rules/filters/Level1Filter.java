package v2.rules.filters;

import draft.Course;

import java.util.function.Predicate;

public class Level1Filter implements Predicate<Course> {

    @Override
    public boolean test(Course course) {
        return course.getName().charAt(4) == '1';
    }
}
