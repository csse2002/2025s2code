import org.junit.Test;

import static org.junit.Assert.*;

public class IntSetTest {
    @Test
    public void emptySet() {
        IntSet set = new IntSet();
        assertFalse(set.contains(2));
    }

    @Test
    public void oneElementSet() {
        IntSet set = new IntSet();
        set.add(2);
        assertTrue(set.contains(2));
    }

    @Test
    public void twoElementSet() {
        IntSet set = new IntSet();
        set.add(2);
        set.add(4);
        assertTrue(set.contains(2));
    }
}
