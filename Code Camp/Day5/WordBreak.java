// Question link : https://leetcode.com/problems/word-break/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {

        HashSet<Integer> invalids = new HashSet<>();

        String word = "leetcode";
        List<String> wordsList = new ArrayList<>();
        wordsList.add("leet");
        wordsList.add("code");
        wordsList.add("point");

        new WordBreak().reachableRecurrsion(0, word ,wordsList, invalids);
    }


    public boolean reachableDp(String s, List<String> words){

        HashSet<String> allWords = new HashSet<>();
        ArrayList<Integer> trueValues = new ArrayList<>();

        for(String word: words){
            allWords.add(word);
        }
        allWords.add("");
        trueValues.add(-1);

        boolean[] reach = new boolean[s.length()+1];
        reach[0] = true;

        if(s.length() == 1){
            return allWords.contains(s);
        }

        for(int i = 0; i < s.length(); i++){

            boolean found = false;
            for (int index: trueValues) {
                String substr = s.substring(index+1, i+1);
                found |= allWords.contains(substr);
                if(found) break;
            }

            reach[i+1] = found;
            if(found){
                trueValues.add(i);
            }
        }

        return reach[s.length()];

    }



    public boolean reachableRecurrsion(int index, String givenString, List<String> words, HashSet<Integer> invalid){
        if(index == givenString.length()){
            return true;
        }
        if(invalid.contains(index)){
            return false;
        }

        boolean reachable = false;
        for (String word: words ) {
            if( index + word.length() > givenString.length()){
                continue;
            }

            boolean isSubstring = true;
            for (int i = 0; i < word.length(); i++) {
                if(word.charAt(i) != givenString.charAt(index + i)){
                    isSubstring = false;
                    break;
                }
            }

            if(isSubstring){
                reachable |= reachableRecurrsion(index + word.length(), givenString, words, invalid);
            }
        }

        if(reachable == false){
            invalid.add(index);
        }

        return reachable;
    }

}
