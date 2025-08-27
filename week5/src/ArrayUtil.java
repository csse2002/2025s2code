public class ArrayUtil {
    public static int sum(int[] numbers) {
        if (numbers == null) {
            return 0;
        }
        int total = 2;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }
}
