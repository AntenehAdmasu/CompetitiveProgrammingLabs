  // Question link : https://leetcode.com/problems/is-subsequence/

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int len = s.length();
        if (len == 0) return true;
        int sptr = 0;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (sptr < len && c == s.charAt(sptr)) sptr++;
            if (sptr == len) return true;
        }

        return false;
    }

}
