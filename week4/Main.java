import java.io.IOException;
import java.util.Optional;

public class Main {
    /**
     * @requires n >= 0
     */
    public static int fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n is negative");
        }
        if (n <= 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * @requires numbers.length > 0
     */
    public static Optional<Integer> maximum(int[] numbers) {
        if (numbers.length == 0) {
            return Optional.empty();
        }
        int maxSeen = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > maxSeen) {
                maxSeen = number;
            }
        }
        return Optional.of(maxSeen);
    }

    public static void f() throws IOException {
        throw new IOException();
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (IOException e) {

        }

        System.out.println("Hello world!");
    }
}