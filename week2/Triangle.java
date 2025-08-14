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

//    public void scale(double multiplier) {
//        this.a *= multiplier;
//        this.b *= multiplier;
//        this.c *= multiplier;
//    }

    public Triangle scale(double multiplier) {
        return new Triangle(this.a * multiplier, this.b * multiplier, this.c * multiplier);
    }
}