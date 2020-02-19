// Question link : https://leetcode.com/contest/weekly-contest-80/problems/most-common-word

import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {

    public static void main(String[] args) {
        String tc1 = "a, a, a, a, b,b,b,c, c";
        String[] b = new String[]{"a"};
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[]{"hit"};
        new MostCommonWord().mostCommonWord(paragraph,banned);


    }
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedWords = new HashSet<>();
        HashMap<String, Integer> wordOccurence = new HashMap<>();

        for (String word:banned) {
            bannedWords.add(word.toLowerCase());
        }

        String[] wordsInParagraph = paragraph.split(" ");
        for (String word: wordsInParagraph) {
            String[] innerWords = word.split(",");
            for (String word2: innerWords) {
                int word2CharCode = (int)word2.charAt(word2.length()-1);

                if( word2CharCode < 65 || word2CharCode > 122 || (word2CharCode < 97 & word2CharCode > 90)){
                    word2 = word2.substring(0,word2.length()-1);
                }
                word2 = word2.toLowerCase();
                if(!bannedWords.contains(word2)){
                    wordOccurence.put(word2, wordOccurence.containsKey(word2) ? wordOccurence.get(word2)+1 : 1);
                }
            }

        }
        int maxOcccurence = Integer.MIN_VALUE;
        String maxWord = "";
        for (String word: wordOccurence.keySet()) {
            if(wordOccurence.get(word) > maxOcccurence){
                maxOcccurence = wordOccurence.get(word);
                maxWord = word;
            }
        }
        return maxWord;
    }
}
