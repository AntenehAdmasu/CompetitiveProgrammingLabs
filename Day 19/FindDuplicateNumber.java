// Question : https://leetcode.com/problems/find-the-duplicate-number/

public class FindDuplicateNumber {
    
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2, 2};
        System.out.println("Duplicate is " + findDuplicate(nums));
    }


    public static int findDuplicate(int left, int right, int[] nums) {
        if (right >= left) {
            int middle = (left == right) ? left : (left + right - 1) / 2;

            if (getBelowCount(nums, middle) <= middle) {
                return findDuplicate(middle+1, right, nums);
            }
            return findDuplicate(left, middle-1 , nums);
        }
        return left;
    }


    public static int getBelowCount(int[] nums, int n) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= n) count++;
        }
        return count;
    }
}
