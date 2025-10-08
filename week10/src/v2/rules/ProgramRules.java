package v2.rules;

import draft.Course;

import java.util.List;

public interface ProgramRules {
    boolean satisfies(List<Course> courses);
}
