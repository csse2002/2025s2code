public class IntSet {
    int[] nums = new int[100];
    int index = 0;

    public boolean contains(int value) {
        for (int num : nums) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    public void add(int value) {
        nums[index++] = value;
    }
}
