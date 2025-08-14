import java.util.Stack;

public class Stacks {


    public static Stack<String> reverse(Stack<String> stack) {
        Stack<String> result = new Stack<>();
        while (!stack.empty()) {
            String element = stack.pop();
            result.push(element);
        }
        return result;
    }

    public static int sum(Stack<Integer> stack) {
        int total = 0;
        for (Integer element : stack) {
            total += element;
        }
        return total;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        System.out.println(stack);

        Stack<String> reversed = reverse(stack);

        Stack<Integer> numbers = new Stack<>();
        numbers.push(23);
        numbers.push(54);
        System.out.println(sum(numbers));

        System.out.println(reversed);
    }
}
