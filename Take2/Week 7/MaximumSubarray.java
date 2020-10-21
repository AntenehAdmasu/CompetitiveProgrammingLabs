public class MaximumSubarray {
    public static void main(String[] args) {
        int[] arr = {2, -1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArrayAlternative(arr));
    }

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum+nums[i], nums[i]);
            max = Math.max(max, sum);
        }
        return max;

    }

    public static int maxSubArrayAlternative(int[] nums) {

        int[] sumarray = new int[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            sumarray[i] = nums[i] + (i == 0 ? 0 : sumarray[i-1]);
        }
        int mostMin = 0;
        int answer = Integer.MIN_VALUE;
        for (int j = 0; j < sumarray.length ; j++) {
            answer = Math.max(answer, sumarray[j] - mostMin);
            mostMin = Math.min(mostMin, sumarray[j]);
        }
        return answer;
    }

}
