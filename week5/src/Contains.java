public class Contains {

    public static boolean contains(int[] array, int value) {
        if (array.length == 0) {
            return true;
        }
        boolean hasIt = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                hasIt = true;
            }
        }
        return hasIt;
    }

}
