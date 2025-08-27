import org.junit.Test;

import static org.junit.Assert.*;

public class ContainsTest {

    @Test
    public void doesContain() {
        int[] input = new int[]{1, 2, 3};
        assertTrue(Contains.contains(input, 2));
    }

    @Test
    public void doesNotContain() {
        int[] input = new int[]{1, 2, 3};
        assertFalse(Contains.contains(input, 4));
    }

    @Test
    public void emptyContains() {
        assertFalse(Contains.contains(new int[]{}, 4));
    }

    @Test
    public void oneElementContains() {
        assertTrue(Contains.contains(new int[]{2}, 2));
    }

    @Test
    public void oneElementNotContains() {
        assertFalse(Contains.contains(new int[]{2}, 3));
    }
}
