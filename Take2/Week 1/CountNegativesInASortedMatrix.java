public class CountNegativesInASortedMatrix {

    public int countNegatives(int[][] grid) {
        int negativeCounter = 0;
        for (int[] row: grid) {
            negativeCounter += row.length - getIndex(row);
        }
        return negativeCounter;
    }

    public int getIndex(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start<=end) {
            int mid = (start + end) / 2;
            if(nums[mid] < 0 && mid != 0 && nums[mid-1] >= 0){
                return mid;
            }else if(nums[mid] >= 0){
                start = mid + 1;
            }
            else{
                end = mid -1;
            }
        }
        return start >= nums.length ? nums.length : 0;
    }
}
