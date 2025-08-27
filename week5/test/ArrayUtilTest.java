import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayUtilTest {

    @Test
    public void sumOf3() {
        int total = ArrayUtil.sum(new int[]{3, 3, 3});
        assertEquals(9, total);
    }

    @Test
    public void sumOfBig() {
        int total = ArrayUtil.sum(new int[]{Integer.MAX_VALUE - 30, 50});
        System.out.println(total);
    }

}
