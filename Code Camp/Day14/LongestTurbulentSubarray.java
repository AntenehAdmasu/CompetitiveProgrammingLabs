// Question link : https://leetcode.com/contest/weekly-contest-120/problems/longest-turbulent-subarray

public class LongestTurbulentSubarray {

    public static void main(String[] args) {
        int A[] = {9, 9, 9, 9, 9, 9};
        int B[] = {9,4,2,10,7,8,8,1,9};
        int C[] = {2,2,3};
        System.out.println("==>> " + new LongestTurbulentSubarray().maxTurbulenceSize(B));
    }

    public int maxTurbulenceSize(int[] A) {
        if(A.length < 2){
            return A.length;
        }
        if(A[1] > A[0]){
            return getTurbulentSub(A, 0, 0, 1);
        }else{
            return getTurbulentSub(A, 0, 1, 1);
        }
    }

    public int getTurbulentSub(int[] A, int index, int option, int valSofar) {    // Option 1  - find increasing Option 2 - find decreasing Option3 - whatever works for you
        int val = 0;

        if (index + 1 >= A.length) {
            return valSofar;
        }

        if (option == 0) {
            if (A[index + 1] > A[index]) { // find increasing
                val = getTurbulentSub(A, index + 1, 1, valSofar + 1);
            } else {
                if (A[index + 1] < A[index]) {
                    val = Math.max(valSofar,getTurbulentSub(A, index + 1, 0,  2));
                } else if (A[index + 1] > A[index]) {
                    val = Math.max(valSofar,getTurbulentSub(A, index + 1, 1,  2));
                }else{
                    val = Math.max(valSofar,getTurbulentSub(A, index + 1, 1,  1));
                }

            }
        } else if (option == 1) {     // find decreasing
            if (A[index + 1] < A[index]) {
                val = getTurbulentSub(A, index + 1, 0, valSofar + 1);
            } else {
                if (A[index + 1] < A[index]) {
                    val = Math.max(valSofar, getTurbulentSub(A, index + 1, 0,  2));
                } else if (A[index + 1] > A[index]) {
                    val = Math.max(valSofar,getTurbulentSub(A, index + 1, 1,  2));
                }else{
                    val = Math.max(valSofar,getTurbulentSub(A, index + 1, 1,  1));
                }

            }
        }

        return val;
    }
}
