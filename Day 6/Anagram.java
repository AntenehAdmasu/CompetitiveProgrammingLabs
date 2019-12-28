// Questions : https://leetcode.com/problems/valid-anagram/

import java.util.HashMap;

public class Anagram {

    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(smap.get(c) == null){
                smap.put(c,1);
            }else{
                smap.put(c, smap.get(c)+1);
            }
        }

        for (int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);
            if(tmap.get(c) == null){
                tmap.put(c,1);
            }else{
                tmap.put(c, tmap.get(c)+1);
            }
        }

        if(smap.values().size() != tmap.values().size()) return false;

        int count = 0;
        for (Character c: smap.keySet() ) {
            count++;
            if(!(smap.get(c).equals((tmap.get(c))))) return false;
        }
        return true;
    }
}
