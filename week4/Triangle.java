public class Triangle {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle() {
        this.a = 1;
        this.b = 1;
        this.c = 1;
    }

    public boolean isValid() {
        return (a + b) > c && (a + c) > b && (b + c) > a;
    }

    public double area() {
        assert isValid();
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public double perimeter() {
        return a + b + c;
    }

    /**
     * @requires multiplier > 0
     */
    public int scale(double multiplier) {
        if (multiplier == 0) {
            return 1;
        }
        if (multiplier < 0) {
            return 2;
        }
        this.a *= multiplier;
        this.b *= multiplier;
        this.c *= multiplier;
        return 0;
    }

    // Options:
    // 1. Silent failure --- detect, and avoid doing something silly
    // 2. Print to console
    // 3. Return boolean
    // 4. Return error code

    public static void main(String[] args) {
        Triangle triangleA = new Triangle(2, 3, 4);
        Triangle triangleB = new Triangle(4, 3, 2);
        Triangle triangleC = new Triangle(2, 3, 4);

        System.out.println(triangleA);
        System.out.println(triangleB.toString());

        System.out.println(triangleA.equals(triangleC));
    }
}