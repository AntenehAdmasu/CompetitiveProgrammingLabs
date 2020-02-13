// Question link : https://leetcode.com/problems/longest-common-subsequence/


public class LongestCommonSubsequence {

    public static void main(String[] args) {
        int max = new LongestCommonSubsequence().longestCommonSubsequence("abc", "abcd");
        System.out.println("=> " + max);
    }

    public int longestCommonSubsequence(String text1, String text2) {

        // Making the array to have one more preceding row and column
        int[][] arr = new int[text1.length()+1][text2.length()+1];

        for (int i = 0; i < text1.length(); i++) {
            int I = i + 1; // ith row for the larger array
            char t1 = text1.charAt(i);

            for (int j = 0; j < text2.length(); j++) {
                char t2 = text2.charAt(j);
                int J = j + 1;

                if(t1 == t2){
                    arr[I][J] = arr[I-1][J-1] + 1;
                }else{
                    arr[I][J] = Math.max(arr[I-1][J], arr[I][J-1]);
                }
            }
        }

        return arr[text1.length()][text2.length()];
    }
    
}
