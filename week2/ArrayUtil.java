import java.util.Arrays;

public class ArrayUtil {
    public static int sum(int[] numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }

    // precondition: numbers is not empty
    public static int max(int[] numbers) {
        int biggest = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > biggest) {
                biggest = number;
            }
        }
        return biggest;
    }

    public static int[] concat(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        for (int i = 0; i < result.length; i++) {
            if (i < a.length) {
                result[i] = a[i];
            } else {
                result[i] = b[i - a.length];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ex1 = {-12, -24, -2};
        int[] ex2 = {12, 24, 2};
        int total = sum(ex1);
        System.out.println(total);

        System.out.println(max(new int[0]));

        System.out.println(Arrays.toString(concat(ex1, ex2)));
    }
}
