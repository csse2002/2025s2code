public class TriangleTest {
    public static void main(String[] args) {
        // Test the Triangle 3x4x5 (area of 6)
        Triangle first = new Triangle(3, 4, 5);
        System.out.println(first.area());
        System.out.println(first.perimeter());

        Triangle second = new Triangle();

        Triangle bigger = second.scale(2);
    }
}