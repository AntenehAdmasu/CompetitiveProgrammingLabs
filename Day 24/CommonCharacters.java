// Question link : https://leetcode.com/problems/find-common-characters/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommonCharacters {

    public static void main(String[] args) {
        String[] words = new String[]{"all", "abell", "alleb"};
        List<String> dup = commonChars(words);
        for (String s: dup) {
            System.out.println("=> " + s);
        }

    }

    public static List<String> commonChars(String[] A) {
        HashMap<Character, Integer> possibleDuplicates = new HashMap<>();
        List<String> duplicates = new ArrayList<>();

        String firstWord = A[0];
        for (int i = 0; i < firstWord.length(); i++) {
            Character c = firstWord.charAt(i);
            if(possibleDuplicates.containsKey(c)){
                possibleDuplicates.put(c, possibleDuplicates.get(c) + 1);
            }else{
                possibleDuplicates.put(c,1);
            }
        }


        for (String word: A) {
            HashMap<Character, Integer> resultHashMap = new HashMap<>();

            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                if(possibleDuplicates.containsKey(c) && possibleDuplicates.get(c) > 0){
                    possibleDuplicates.put(c, possibleDuplicates.get(c) - 1);
                    if(resultHashMap.containsKey(c)){
                        resultHashMap.put(c, resultHashMap.get(c) + 1);
                    }else{
                        resultHashMap.put(c,1);
                    }
                }
            }
            possibleDuplicates = resultHashMap;
        }

        for (Character c: possibleDuplicates.keySet()) {
            while (possibleDuplicates.get(c) > 0){
                duplicates.add(c.toString());
                possibleDuplicates.put(c, possibleDuplicates.get(c) - 1);
            }
        }

        return duplicates;
    }
}

