package draft;

public class Course {
    private String name;
    private int units;
    private boolean isCompulsory;
    private Course[] prerequisites;
    public Course(String name, int units, boolean isCompulsory) {
        this.name = name;
        this.units = units;
        this.isCompulsory = isCompulsory;
    }

    public int getUnits() {
        return units;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Course course) {
            return course.name.equals(this.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Course: " + name + " units: " + units;
    }
}
