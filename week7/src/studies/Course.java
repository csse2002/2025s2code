package studies;

public class Course {
    private String code;
    private Semester semester;

    public Course(String code, Semester semester) {
        this.code = code;
        this.semester = semester;
    }

    public String getCode() {
        return this.code;
    }

    public Semester getSemester() {
        return semester;
    }
}
