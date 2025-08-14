interface Exhaustible {
    void rest();
    boolean isTired();
}

class Student implements Exhaustible {
    @Override
    public void rest() {}

    @Override
    public boolean isTired() {
        return true;
    }

    public void study() {}
}

class Lecturer implements Exhaustible {

    @Override
    public void rest() {}

    @Override
    public boolean isTired() {
        return true;
    }
}

public class Classroom {
    static void fixThem(Exhaustible exhaustible) {
        while (exhaustible.isTired()) {
            exhaustible.rest();
        }
    }

    public static void main(String[] args) {
        Student student = new Student();
        Lecturer lecturer = new Lecturer();

        fixThem(student);
    }
}
