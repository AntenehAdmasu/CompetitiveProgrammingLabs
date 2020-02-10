// Question link : https://leetcode.com/problems/maximum-length-of-repeated-subarray/

public class MaximumLengthofRepeatedSubarray {

    public static void main(String[] args) {
        int[] A = new int[]{0,1,2,3};
        int[] B = new int[]{1,2,3,4};
        System.out.println("==========>>>>>>>>>>>>  "  +  new MaximumLengthofRepeatedSubarray().findLength(A, B));
    }

    public int findLength(int[] A, int[] B) {

        int[][] arr = new int[A.length][B.length];
        int maxLengthOfSubarray = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {

            int[] newArr = new int[B.length];
            for (int j = 0; j < B.length ; j++) {

                int upper = 0;
                if(i - 1 >= 0 && j - 1 >= 0){
                    upper = arr[i-1][j-1];
                }
                if (A[i] == B[j]){
                    upper += 1;
                }else{
                    newArr[j] = 0;
                    continue;
                }
                maxLengthOfSubarray = Math.max(maxLengthOfSubarray, upper);
                newArr[j] = upper;
            }
            arr[i] = newArr;
        }

        return maxLengthOfSubarray == Integer.MIN_VALUE ? 0 : maxLengthOfSubarray;
    }

}
