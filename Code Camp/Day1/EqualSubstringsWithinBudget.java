// Question link : https://leetcode.com/problems/get-equal-substrings-within-budget/

public class EqualSubstringsWithinBudget {

    public static void main(String[] args) {
        int a = 'a' - 'z';

        new EqualSubstringsWithinBudget().equalSubstring("abcd", "acde",0);
    }
    public int equalSubstring(String s, String t, int maxCost) {
        long[] costArray = new long[s.length()+1];
        costArray[0] = 0;
        for (int i = 1; i <= s.length() ; i++) {
            int cost = Math.abs(s.charAt(i-1) - t.charAt(i-1));
            costArray[i] = costArray[i-1] + cost;
        }
        int start = 0;
        int end = 0;
        int maxLen = 0;

        while(end < costArray.length){
            long tempCost = costArray[end] - costArray[start];
            if(tempCost <= maxCost){
                maxLen = Math.max(end-start, maxLen);
                end++;
            }else{
                start++;
            }
        }
        return maxLen;
    }
}
