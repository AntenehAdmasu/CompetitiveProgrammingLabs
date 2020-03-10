// Question link : https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> elements = new HashSet<>();
        int start = 0;
        int end = 0;
        int maxLen = 0;
        while(end < s.length()){
            if(!elements.contains(s.charAt(end))){
                elements.add(s.charAt(end));
                end++;
            }else{
                elements.remove(s.charAt(start));
                start++;
            }
            maxLen = Math.max(maxLen, end-start);

        }
        return maxLen;
    }
}
