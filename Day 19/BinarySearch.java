// Question : https://leetcode.com/problems/binary-search/

public class BinarySearch {
    public static void main(String[] args) {
        int[] A = new int[]{-1,0,3,5,9,12};
        System.out.println(new BinarySearch().binarySearch(A,0,A.length -1,2));
    }

    public int search(int[] nums,int middle,int target,int numofCalls){
        numofCalls++;
        if(nums[middle] == target) return middle;
        double d = Math.ceil(((double)nums.length/(double)(2*numofCalls)));
        if((int)d == 1) return -1;

        if(nums[middle] < target){
            middle = middle + (int)(d);
            return search(nums, middle,target,numofCalls+1);

        }else{
            middle = middle - (int)(d);
            return search(nums,middle,target,numofCalls+1);
        }
    }

    public int binarySearch(int[] nums, int left, int right, int target){
        if(right>= left){
            int middle = (left + right - 1) / 2 ;
            if(left == right) middle = left;
            if(nums[middle] == target) return middle;

            if(nums[middle] > target) return binarySearch(nums, left, middle-1, target);
            return binarySearch(nums, middle + 1, right,target);
        }
        return -1;

    }
}
