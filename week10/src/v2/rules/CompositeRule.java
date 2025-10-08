package v2.rules;

import draft.Course;

import java.util.List;

public class CompositeRule implements ProgramRules {
    private List<ProgramRules> rules;

    public CompositeRule(List<ProgramRules> rules) {
        this.rules = rules;
    }

    @Override
    public boolean satisfies(List<Course> courses) {
        for (ProgramRules rule : rules) {
            if (!rule.satisfies(courses)) {
                return false;
            }
        }
        return true;
    }
}
