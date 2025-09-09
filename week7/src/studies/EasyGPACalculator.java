package studies;

public class EasyGPACalculator extends GPACalculator {
    @Override
    public double calculateGPA(StudiesReport report, Semester semester) {
        int total = 0;
        int units = 0;
        for (Course course : report.getCourses()) {
            if (semester.equals(course.getSemester())) {
                int grade = report.getGrade(course).getValue();;
                if (grade < 4) {
                    continue;
                }
                total += grade;
                units += 2;
            }
        }
        return total / (double) units;
    }
}
