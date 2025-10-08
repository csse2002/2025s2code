package v2.rules.range;

import draft.Course;
import v2.rules.ProgramRules;

import java.util.List;

public class MinUnits implements ProgramRules {
    private int unitsRequired;

    public MinUnits(int units) {
        this.unitsRequired = units;
    }

    @Override
    public boolean satisfies(List<Course> courses) {
        int units = 0;
        for (Course course : courses) {
            units += course.getUnits();
        }
        return units >= unitsRequired;
    }
}
