package v2.rules;

import draft.Course;

import java.util.List;

public interface ConsumingRule {
    boolean canCountToward(Course course);
    String identifier();
    boolean satisfies(List<Course> taken);
}
