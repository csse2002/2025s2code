public class Vowels {

    public static char nextVowel(char c) {
        char result = switch (c) {
            case 'A' -> 'E';
            case 'E' -> 'I';
            default -> ' ';
        };
        return result;
    }

    public static void main(String[] args) {
        System.out.println(nextVowel('A'));
    }
}
