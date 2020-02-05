// Question link : https://leetcode.com/problems/range-sum-query-immutable/

public class RangeSumQuery {
    public static void main(String[] args) {
        int[] test2 = new int[]{2,7,9,3,1};
        System.out.println(new RangeSumQuery(test2).sumRange(0,1));

    }
    int[] numbers;
    int[] sumarray;
    public RangeSumQuery(int[] nums){
        numbers = nums;
        sumarray = new int[nums.length+1];
        constructSumArray(nums, sumarray);
    }

    public int sumRange(int i, int j) {
        return sumarray[j+1] - sumarray[i];
    }

    private void constructSumArray(int[] nums, int[] sumarray) {
        sumarray[0] = 0;
        for (int i = 0; i < nums.length ; i++) {
            sumarray[i+1] = nums[i] + sumarray[i];
        }
    }
}
