import java.io.*;
import java.util.Scanner;

public class Streams {

    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(new StringReader("24 10"));
//
//        System.out.println(scanner.nextInt());

//        for (int i = 0; i < 200000; i++) {
//            System.out.print(i);
//            System.out.flush();
//            if (i == 2000) {
//                System.exit(1);
//            }
//        }

        System.out.println("Something is wrong");
        System.err.println("Something is wrong");

//        OutputStream out = System.out;
//        printFooBarBaz(out);

//        testMe(new ByteArrayInputStream(new byte[]{}));
//        String result = reverse(new StringReader("Words, words, and more words"));

//        try (Reader r = new BufferedReader(new FileReader("Streams.java"))) {
//            String result = reverse(r);
//            System.out.println(result);
//        }
//        System.out.println(result);
    }

    private static void testMe(BufferedInputStream fio) throws IOException {
        int ch = 0;
        while (ch != -1) {
            ch = fio.read();
        }
    }

    private static String reverse(Reader reader) throws IOException {
        char[] output = new char[10];
        for (int i = 0; i < 10; i++) {
            output[9 - i] = (char) reader.read();
        }
        return new String(output);
    }

    private static void printFooBarBaz(OutputStream out) throws IOException {
        String toPrint = "foo bar baz";

        byte[] output = new byte[toPrint.length()];
        for (int i = 0; i < output.length; i++) {
            output[i] = (byte) toPrint.charAt(i);
        }
        out.write(output);
    }
}
