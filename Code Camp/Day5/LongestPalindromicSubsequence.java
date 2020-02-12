// Question link : https://leetcode.com/problems/longest-palindromic-subsequence/

import java.util.HashMap;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        int max = new LongestPalindromicSubsequence().longestPalindromeSubseq("bbbab");
        System.out.println("=> " + max);
    }

    public int longestPalindromeSubseq(String s) {
        HashMap<String, Integer> calculated = new HashMap<>();
        int i = 0;
        int j = s.length()-1;
        int maxPalindrome = getLongestSubstring(s,i,j,calculated);
        return maxPalindrome;
    }


    private int getLongestSubstring(String s, int i, int j, HashMap<String, Integer> calculated) {
        String key = i + " " + j;
        if(calculated.containsKey(key)) return calculated.get(key);

        int count = 0;
        while(i < j && s.charAt(i) == s.charAt(j)){
            count += 2;
            i++; j--;
        }

        if(i < j){
            count += Math.max(getLongestSubstring(s, i+1, j, calculated), getLongestSubstring(s, i, j-1, calculated));
        }else if(i == j){
            count += 1;
        }

        calculated.put(key, count);
        return calculated.get(key);
        
    }

}
