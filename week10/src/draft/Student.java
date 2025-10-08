package draft;

import java.util.*;

public class Student {
    private static int CORE_UNITS = 8;
    private static int TOTAL_UNITS = 12;

    private Credit[] credits;
    private List<Course> taken = new ArrayList<>();

    void take(Course course) {
        this.taken.add(course);
    }

    public boolean canGraduate(Degree degree) {
        // Check if all compulsory courses are taken
        for (Course core : degree.getCompulsoryCourses()) {
            if (!taken.contains(core)) {
                return false;
            }
        }

        // Remove core courses from taken set
        Set<Course> remaining = new HashSet<>(taken);
        remaining.removeAll(Arrays.asList(degree.getCompulsoryCourses()));

        boolean result = backtrack(
                new ArrayList<>(remaining),
                degree,
                0,
                0,
                0,
                0,
                new HashSet<>()
        );
        System.out.println(courseMap);
        return result;
    }

    private Map<Course, String> courseMap = new HashMap<>();
    private boolean backtrack(
            List<Course> remainingCourses,
            Degree degree,
            int planCount,
            int breadthCount,
            int programCount,
            int generalCount,
            Set<Course> usedCourses
    ) {
        int total = CORE_UNITS + planCount + breadthCount + programCount + generalCount;

        if (total == TOTAL_UNITS && planCount >= 2) {
            return true;
        }

        if (total > TOTAL_UNITS || remainingCourses.isEmpty()) {
            return false;
        }

        Course current = remainingCourses.get(0);
        List<Course> rest = remainingCourses.subList(1, remainingCourses.size());

        boolean canGraduate = false;

        // Try assigning to Plan
        if (planCount < 4 && belongsTo(current, degree.getPlanCourses())) {
            usedCourses.add(current);
            courseMap.put(current, "PLAN");
            canGraduate = backtrack(rest, degree, planCount + current.getUnits(), breadthCount, programCount, generalCount, usedCourses);
            if (canGraduate) {
                return true;
            }
            courseMap.remove(current);
            usedCourses.remove(current);
        }

        // Try assigning to Breadth
        if (breadthCount < 4 && belongsTo(current, degree.getBreadthElectives())) {
            usedCourses.add(current);
            courseMap.put(current, "BREADTH");
            canGraduate = backtrack(rest, degree, planCount, breadthCount + current.getUnits(), programCount, generalCount, usedCourses);
            if (canGraduate) {
                return true;
            }
            courseMap.remove(current);
            usedCourses.remove(current);
        }

        // Try assigning to Program Elective
        if (programCount < 4 && belongsTo(current, degree.getProgramElectives())) {
            usedCourses.add(current);
            courseMap.put(current, "PROGRAM");
            canGraduate = backtrack(rest, degree, planCount, breadthCount, programCount + current.getUnits(), generalCount, usedCourses);
            if (canGraduate) {
                return true;
            }
            courseMap.remove(current);
            usedCourses.remove(current);
        }

        // Try assigning to General Elective
        if (generalCount < 2 && belongsTo(current, degree.getGeneralElectives())) {
            usedCourses.add(current);
            courseMap.put(current, "GENERAL");
            canGraduate = backtrack(rest, degree, planCount, breadthCount, programCount, generalCount + current.getUnits(), usedCourses);
            if (canGraduate) {
                return true;
            }
            courseMap.remove(current);
            usedCourses.remove(current);
        }

        // Optionally skip the course (i.e., don't use it in any category)
        canGraduate = backtrack(rest, degree, planCount, breadthCount, programCount, generalCount, usedCourses);

        return canGraduate;
    }

    private static boolean belongsTo(Course course, Course[] categoryCourses) {
        for (Course catCourse : categoryCourses) {
            if (course.equals(catCourse)) {
                return true;
            }
        }
        return false;
    }
}
