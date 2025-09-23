public class ASCII {
    public static char toUpperCase(char lower) {
        return (char) (lower & 0b11011111);
    }

    public static void main(String[] args) {
        System.out.println(toUpperCase('e'));
    }
}
