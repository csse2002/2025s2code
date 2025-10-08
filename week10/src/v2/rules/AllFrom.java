package v2.rules;

import draft.Course;
import v2.courses.CourseSet;

import java.util.List;

public class AllFrom implements ProgramRules {
    private final CourseSet required;

    public AllFrom(CourseSet required) {
        this.required = required;
    }

    @Override
    public boolean satisfies(List<Course> courses) {
        return required.satisfiedBy(courses);
    }
}
