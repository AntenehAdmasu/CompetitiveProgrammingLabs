// Question link : https://leetcode.com/problems/longest-word-in-dictionary/

import java.util.Arrays;

public class LongestWordInADictionary {

    public static void main(String[] args) {
        String[] words = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println("=======>>>>>>>  " + new LongestWordInADictionary().longestWord(words));
    }


    public String longestWord(String[] words) {

        Arrays.sort(words);
        TNode root = new TNode();
        int maxLen = 0;
        String longestWord = "";

        for (String word : words) {

            int wordSize = word.length();
            TNode current = root;

            for (int i = 0; i < word.length(); i++) {
                int c = (int) word.charAt(i);

                // The previous characters are not constructed
                if(current.children[c - 97] == null && i != wordSize-1){
                    break;
                }

                if (current.children[c - 97] != null) {
                    current = current.children[c - 97];
                } else if (current.children[c - 97] == null && i == wordSize - 1) {
                    current.children[c - 97] = new TNode();
                }

                if (i == wordSize - 1 && wordSize > maxLen) {
                    maxLen = wordSize;
                    longestWord = word;
                }
            }
        }

        return longestWord;

    }
}

class TNode {
    TNode[] children = new TNode[26];
    boolean isEndOfWord = false;

    public TNode(TNode[] children, boolean isEndOfWord) {
        this.children = children;
        this.isEndOfWord = isEndOfWord;
    }

    public TNode() {
    }
}
