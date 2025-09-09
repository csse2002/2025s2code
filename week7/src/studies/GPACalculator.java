package studies;

public class GPACalculator implements GradeCalculator {
    private static int unitsMultiplier = 3;

    private StudiesReport report;
    private Semester semester;

    public GPACalculator(StudiesReport report, Semester semester) {
        this.report = report;
        this.semester = semester;
    }

    public double calculateGrade() {
        int total = 0;
        int units = 0;
        for (Course course : report.getCourses()) {
            if (semester.equals(course.getSemester())) {
                total += report.getGrade(course).getValue();
                units += unitsMultiplier;
            }
        }
        return total / (double) units;
    }
}
