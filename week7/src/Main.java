import studies.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {

    private static Random random = new Random();

    public static void main(String[] args) {
        Semester sem1 = new Semester("Semester 1, 2025");
        Semester sem2 = new Semester("Semester 2, 2025");
        Course intro = new Course("CSSE1001", sem1);
        Course math = new Course("MATH1061", sem1);
        Course circuit = new Course("CSSE2010", sem1);
        Course comp = new Course("COMP1100", sem1);
        Course best = new Course("CSSE2002", sem2);
        Course infs = new Course("INFS1200", sem2);
        Course deco = new Course("DECO1400", sem2);

        List<Course> courses = List.of(intro, math, circuit, comp, best, infs, deco);

        List<Semester> semesters = List.of(sem1, sem2);

        Map<Course, Grade> grades = new HashMap<>();
        for (Course course : courses) {
            grades.put(course, new Grade(random.nextInt(1, 7)));
        }

        StudiesReport report = new StudiesReport(grades, semesters);

        GPACalculator calculator = new GPACalculator(report, sem1);
        ReportRenderer renderer = new ReportRenderer(calculator);

        System.out.println(renderer.render(grades, semesters, report));
    }
}
