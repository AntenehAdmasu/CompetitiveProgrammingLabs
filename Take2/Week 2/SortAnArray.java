import java.util.Arrays;

public class SortAnArray {

    public static void main(String[] args) {
        int[] nums = new SortAnArray().sortArray(new int[]{5, 1, 1, 2, 0, 0});
        System.out.println(Arrays.toString(nums));
    }

    public int[] sortArray(int[] nums) {
        return sort(nums);
    }

    public static int[] sort(int[] nums) {

        int length = nums.length;
        int[] left;
        int[] right;

        if (length == 1) {
            return nums;
        } else {
            left = sort(Arrays.copyOfRange(nums, 0, length / 2));
            right = sort(Arrays.copyOfRange(nums, length / 2, length));
        }
        return merge(left, right);
    }


    public static int[] merge(int[] left, int[] right) {

        int l = 0;
        int r = 0;
        int[] mergedList = new int[left.length + right.length];
        int inserted = 0;


        while ((l < left.length) && (r < right.length)) {
            mergedList[inserted++] = (left[l] < right[r]) ? left[l++] : right[r++];
        }

        // Filling the remaining slots
        for (int i = r; i < right.length; i++) {
            mergedList[inserted++] = right[i];
        }
        for (int i = l; i < left.length; i++) {
            mergedList[inserted++] = left[i];
        }

        return mergedList;
    }
}
