import java.util.Arrays;

public class Collatz {
    public static int[] collatzSteps(int n) {
        int[] steps = new int[100];
        int step = 0;
        while (n != 1) {
            steps[step] = n;
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            step++;
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(collatzSteps(30)));
        System.out.println(Arrays.toString(collatzSteps(63)));
    }
}
