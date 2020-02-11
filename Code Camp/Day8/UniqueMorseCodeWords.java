// Question link : https://leetcode.com/contest/weekly-contest-77/problems/unique-morse-code-words

import java.util.HashSet;

public class UniqueMorseCodeWords {

    public static void main(String[] args) {
        String[] words = new String[]{"gin","zen", "gig","msg"};
        System.out.println("====>>>>>" + new UniqueMorseCodeWords().uniqueMorseRepresentations(words));
    }


    public int uniqueMorseRepresentations(String[] words) {
        String [] codes = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> distinct = new HashSet<>();

        for (String word: words) {
            String code = "";
            for (int i = 0; i < word.length() ; i++) {
                String morseEquivalent = codes[(int)word.charAt(i) - 97];
                code += morseEquivalent;
            }
            distinct.add(code);
        }
        return distinct.size();
    }
}