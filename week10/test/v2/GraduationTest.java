package v2;

import draft.Course;
import org.junit.Before;
import v2.courses.CourseSet;
import org.junit.Test;
import v2.rules.*;
import v2.rules.range.MinUnits;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GraduationTest {
    private Transcript transcript;
    private ProgramRules rules;

    @Before
    public void setup() {
        transcript = new Transcript();

        CourseSet core = CourseSet
                .all("CSSE1001", "CSSE2002", "CSSE2310", "CSSE6400", "COMP3506");
        CourseSet planOptions = CourseSet.all("CSSE3100", "COMP3400");
        CourseSet breadthElectives = CourseSet.all("MATH2302", "MATH3306");
        CourseSet programElectives = planOptions.union(breadthElectives);
        CourseSet generalElectives = CourseSet.all("PHIL2110");

        ConsumingRule plan = new RangeFrom(2, 4, planOptions, "Plan");
        ConsumingRule breadth = new RangeFrom(0, 4, breadthElectives, "Breadth");
        ConsumingRule program = new RangeFrom(0, 4, programElectives, "Program");
        ConsumingRule general = new RangeFrom(0, 2, generalElectives, "General");

        this.rules = new RuleSet()
                .addRule(new MinUnits(12))
                .addRule(new AllFrom(core))
                .addRule(new DistinctRule(plan, breadth, program, general))
                .build();
    }

    enum Direction {
        STRAIGHT, LEFT, RIGHT, BACKWARDS
    }

    // direction = 0 go straight
    // direction = 1 go left
    // direction = 2 go right
    // direction = 3 go backwards
    private static void turn(Direction direction) {

    }

    public static void main(String[] args) {
        turn(Direction.LEFT);
    }

    private void takeCompulsoryCourses(Transcript transcript) {
        transcript.take(new Course("CSSE1001", 2, true));
        transcript.take(new Course("CSSE2002", 2, false));
        transcript.take(new Course("CSSE2310",2, true));
        transcript.take(new Course("CSSE6400", 2, false));
    }

    @Test
    public void onlyTakesCompulsory() {
        takeCompulsoryCourses(transcript);
        assertFalse(rules.satisfies(transcript.getCourses()));
    }


    @Test
    public void takesCompulsoryPlusTooManyGeneral() {
        takeCompulsoryCourses(transcript);

        transcript.take(new Course("PHIL2110", 2, false));
        transcript.take(new Course("PHIL1110", 2, false));

        assertFalse(rules.satisfies(transcript.getCourses()));
    }

    @Test
    public void missesOneCompulsory() {
        transcript.take(new Course("CSSE1001", 2, true));
        transcript.take(new Course("CSSE2310",2, true));
        transcript.take(new Course("CSSE6400", 2, false));

        transcript.take(new Course("CSSE3100", 2, false));
        transcript.take(new Course("CSSE3400", 2, false));
        transcript.take(new Course("MATH3306", 2, false));

        assertFalse(rules.satisfies(transcript.getCourses()));
    }

    @Test
    public void takesFullPlan() {
        takeCompulsoryCourses(transcript);

        transcript.take(new Course("CSSE3100", 2, false));
        transcript.take(new Course("COMP3400", 2, false));

        assertTrue(rules.satisfies(transcript.getCourses()));
    }

    @Test
    public void takesHalfPlan() {
        takeCompulsoryCourses(transcript);

        transcript.take(new Course("CSSE3100", 2, false));
        transcript.take(new Course("MATH3306", 2, false));

        assertTrue(rules.satisfies(transcript.getCourses()));
    }

    @Test
    public void cannotGraduateTest() {
        transcript.take(new Course("CSSE1001", 2, true));
        transcript.take(new Course("CSSE2310",2, true));
        transcript.take(new Course("CSSE6400", 2, false));

        assertFalse(rules.satisfies(transcript.getCourses()));
    }

}
