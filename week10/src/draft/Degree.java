package draft;

import java.util.List;

public class Degree {

    private int totalUnits;
    private List<Course> compulsoryCourses;
    private List<Course> planCourses;
    private List<Course> breadthElectives;
    private List<Course> programElectives;
    private List<Course> generalElectives;

    public Degree(List<Course> compulsoryCourses, List<Course> planCourses, List<Course> breadthElectives, List<Course> programElectives, List<Course> generalElectives) {
        this.compulsoryCourses = compulsoryCourses;
        this.planCourses = planCourses;
        this.breadthElectives = breadthElectives;
        this.programElectives = programElectives;
        this.generalElectives = generalElectives;
        this.totalUnits = 48;
    }

    public Course[] getCompulsoryCourses() {
        return compulsoryCourses.toArray(new Course[0]);
    }

    public Course[] getPlanCourses() {
        return planCourses.toArray(new Course[0]);
    }

    public Course[] getBreadthElectives() {
        return breadthElectives.toArray(new Course[0]);
    }

    public Course[] getProgramElectives() {
        return programElectives.toArray(new Course[0]);
    }

    public Course[] getGeneralElectives() {
        return generalElectives.toArray(new Course[0]);
    }

    public int getTotalUnits() {
        return totalUnits;
    }
}
