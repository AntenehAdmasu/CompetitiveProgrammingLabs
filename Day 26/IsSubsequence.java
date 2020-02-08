// Question link : 

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int sptr = 0;
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(c == s.charAt(sptr)) sptr++;
            if(sptr == s.length()-1) return true;
        }

        return false;
    }


}
