// Question link : https://leetcode.com/contest/weekly-contest-120/problems/longest-turbulent-subarray

public class LongestTurbulentSubarray {

    public int maxTurbulenceSize(int[] A) {

        boolean increasing = true;

        int maxCount = 1;
        int count = 1;
        for (int i = 0; i < A.length-1 ; i++) {

            if(A[i] == A[i+1]){
                count = 1;
                maxCount = Math.max(count,maxCount);
                continue;
            }

            if(increasing){

                if(A[i+1] < A[i]){
                    count++;
                    maxCount = Math.max(maxCount,count);
                    increasing = !increasing;

                }else if(A[i+1] > A[i]){
                    count = 2;
                    maxCount = Math.max(maxCount, count);
                }
            }else{
                if(A[i+1] > A[i]){
                    count++;
                    maxCount = Math.max(maxCount,count);
                    increasing = !increasing;
                }else if(A[i+1] < A[i]){
                    count = 2;
                    maxCount = Math.max(maxCount, count);
                }
            }
        }

        return maxCount;

    }
}
..............
