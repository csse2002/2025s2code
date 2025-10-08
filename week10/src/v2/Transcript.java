package v2;

import draft.Course;

import java.util.ArrayList;
import java.util.List;

public class Transcript {
    private List<Course> taken = new ArrayList<>();

    public void take(Course course) {
        this.taken.add(course);
    }

    public List<Course> getCourses() {
        return new ArrayList<>(taken);
    }
}
