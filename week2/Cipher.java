public class Cipher {

    public static String cipher(String message) {
        String result = "";
        for (char letter : message.toCharArray()) {
            letter += 3;
            result += letter;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(cipher("XYZ"));
    }
}
