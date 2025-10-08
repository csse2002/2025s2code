package v2.rules.range;

import draft.Course;
import v2.rules.ProgramRules;

import java.util.List;
import java.util.function.Predicate;

public class AtLeast implements ProgramRules {
    private int lowerBound;
    private Predicate<Course> filter;

    public AtLeast(int lowerBound, Predicate<Course> filter) {
        this.lowerBound = lowerBound;
        this.filter = filter;
    }

    @Override
    public boolean satisfies(List<Course> courses) {
        return courses.stream().filter(filter).toList().size() >= lowerBound;
    }
}
