package v2.rules;

import draft.Course;
import v2.courses.CourseSet;

import java.util.List;
import java.util.Random;

public class RangeFrom implements ConsumingRule {
    private int lower;
    private int upper;
    private CourseSet courses;
    private String label;

    public RangeFrom(int lower, int upper, CourseSet courses, String label) {
        this.lower = lower;
        this.upper = upper;
        this.courses = courses;
        this.label = label;
    }

    @Override
    public boolean canCountToward(Course course) {
        return courses.contains(course);
    }

    @Override
    public String identifier() {
        return this.label;
    }

    @Override
    public boolean satisfies(List<Course> taken) {
        int matching = 0;
        for (Course course : taken) {
            if (courses.contains(course)) {
                matching += course.getUnits();
            }
        }
        return lower <= matching && matching <= upper;
    }
}
