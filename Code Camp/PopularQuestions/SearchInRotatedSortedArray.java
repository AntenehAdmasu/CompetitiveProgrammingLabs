// Question link : https://leetcode.com/problems/search-in-rotated-sorted-array/

public class SearchInRotatedSortedArray {


    public int search(int[] nums, int target) {

        if(nums.length==0) return -1;

        int partition = getPivot(nums,0,nums.length -1);

        if(target > nums[nums.length-1]){
            return binarySearch(nums,target,0,partition-1);
        }
        else{
            return binarySearch(nums,target,partition, nums.length -1 );
        }

    }

    public int getPivot(int[] nums,int start,int end){

        while(start<end){

            int mid = (start+end)/2;

            if(nums[mid]>nums[end]){
                start = mid + 1;
            }else{
                end = mid;
            }
        }

        return start;
    }

    public int binarySearch(int[] nums, int target,int start, int end ) {

        while(start<=end) {

            int mid = (start+end)/2;

            if(target == nums[mid]){
                return mid;
            }else if(target > nums[mid]){
                start = mid + 1;
            }
            else{
                end = mid -1;
            }
        }

        return -1;
    }
}
