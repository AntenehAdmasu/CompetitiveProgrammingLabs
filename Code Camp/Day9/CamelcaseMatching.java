// Question link : https://leetcode.com/problems/camelcase-matching/

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {

    
    public List<Boolean> camelMatch(String[] queries, String pattern) {

        List<Boolean> result = new ArrayList<>();
        for (String q: queries) {
            result.add(patterMatches(pattern,q));
        }

        return result;
    }

    public boolean patterMatches(String s, String t) {
        int len = s.length();
        if (len == 0) return true;
        int sptr = 0;
        boolean toReturn = false;

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            if (sptr < len && c == s.charAt(sptr)){
                sptr++;
            }else if ((int)c <= 90){
                return false;
            }
            if (sptr == len){
                toReturn = true;
            }

        }

        return toReturn;
    }

}

