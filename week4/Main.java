public class Main {
    /**
     * @requires n >= 0
     */
    public static int fib(int n) {
        if (n <= 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * @requires numbers.length > 0
     */
    public static int maximum(int[] numbers) {
        int maxSeen = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > maxSeen) {
                maxSeen = number;
            }
        }
        return maxSeen;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}