package studies;

import java.util.List;
import java.util.Map;

public class ReportRenderer {
    private GPACalculator calculator;

    public ReportRenderer(GPACalculator calculator) {
        this.calculator = calculator;
    }

    public String render(Map<Course, Grade> results, List<Semester> semesters, StudiesReport report) {
        String result = "";
        for (Semester semester : semesters) {
            result += "Semester: " + semester.getName() + "\n";
            for (Course course : results.keySet()) {
                if (!course.getSemester().equals(semester)) {
                    continue;
                }
                result += "Course: " + course.getCode();
                result += " Grade: " + report.getGrade(course) + "\n";
            }
            result += "Semester GPA: " + calculator.calculateGrade() + "\n";
        }
        result += "Cumulative GPA: " + report.calculateOverall();
        return result;
    }
}
