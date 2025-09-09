package studies;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudiesReport {
    private Map<Course, Grade> results;
    private List<Semester> semesters;

    private static final int unitsMultiplier = 2;

    public StudiesReport(Map<Course, Grade> results, List<Semester> semesters) {
        this.results = results;
        this.semesters = semesters;
    }

    public Grade getGrade(Course course) {
        return results.get(course);
    }

    public Set<Course> getCourses() {
        return results.keySet();
    }

    public double calculateOverall() {
        int total = 0;
        for (Course course : results.keySet()) {
            total += results.get(course).getValue();
        }
        int numberOfCourses = results.size();
        return total / (double) numberOfCourses * unitsMultiplier;
    }
}
