package v2.rules.range;

import draft.Course;
import v2.rules.ProgramRules;

import java.util.List;
import java.util.function.Predicate;

public class AtMost implements ProgramRules {
    private int upperBound;
    private Predicate<Course> filter;

    public AtMost(int upperBound, Predicate<Course> filter) {
        this.upperBound = upperBound;
        this.filter = filter;
    }

    @Override
    public boolean satisfies(List<Course> courses) {
        return courses.stream().filter(filter).toList().size() <= upperBound;
    }
}
