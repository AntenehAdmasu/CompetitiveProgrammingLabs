import java.util.Arrays;

public class MergeWithArray {

    public static void main(String[] args) {
        int[] test = new int[]{2,5,3,5,67,2};
        int[] ans = sort(test);
        for (int a: ans) System.out.println(a);
    }
    public static int[] sort(int[] nums) {

        int length = nums.length;
        int[] left = new int[length / 2];
        int[] right = new int[length - length / 2];


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
            if (left[l] < right[r]) {
                mergedList[inserted] = left[l];
                l++;
            } else {
                mergedList[inserted] = right[r];
                r++;
            }
            inserted++;
        }

        // Filling the remaining slots
        if (l == left.length) {
            for (int i = r; i < right.length; i++) {
                mergedList[inserted] = right[i];
                inserted++;
            }
        } else {
            for (int i = l; i < left.length; i++) {
                mergedList[inserted] = left[i];
                inserted++;
            }
        }

        return mergedList;

    }

}
