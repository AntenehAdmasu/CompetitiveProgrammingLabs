// Question link : https://leetcode.com/problems/replace-words/

import java.util.HashSet;
import java.util.List;

public class ReplaceWords {

    public String replaceWords(List<String> dict, String sentence) {
        HashSet<String> roots = new HashSet<>();
        String[] sentenceWords = sentence.split(" ");

        StringBuilder ans = new StringBuilder();

        for(String word: dict){
            roots.add(word);
        }

        for(String word: sentenceWords){
            int i = 0;
            boolean found = false;
            while(i != word.length()+1){
                String subs = word.substring(0,i);
                if(roots.contains(subs)){
                    ans.append(subs + " ");
                    found = true;
                    break;
                }
                i++;
            }
            if(found) continue;
            ans.append(word + " ");

        }

        return ans.toString().substring(0,ans.length()-1);

    }
    public String replaceWordsUsingTries(List<String> dict, String sentence){

        TNode root = new TNode();
        String[] wordsFromSentence = sentence.split(" ");
        constructTrie(dict, root);
        StringBuilder answer = new StringBuilder();

        for (String word: wordsFromSentence) {
            answer.append(getWordFromTrie(word,root) + " ");
            System.out.println();
        }

        return answer.toString().substring(0,answer.length()-1);
    }


    private String getWordFromTrie(String word, TNode root) {
        TNode current = root;
        int i = 0;
        String trieWord = "";

        while (i < word.length()){
            int letter = (int) word.charAt(i);
            if(current.isEndOfWord){
                return trieWord;
            }

            if(current.children[letter-97] != null){
                current = current.children[letter-97];
                trieWord += (char) letter;
                i++;
            }else{
                break;
            }
        }

        return word;
    }


    private void constructTrie(List<String> dict, TNode root) {

        for (String word :  dict) {
            TNode current = root;

            for (int i = 0; i < word.length(); i++) {
                int letter = (int) word.charAt(i);
                if (current.children[letter - 97] != null) {
                    current = current.children[letter - 97];
                } else {
                    current.children[letter - 97] = new TNode();
                    current = current.children[letter - 97];
                }

                if (i == word.length() - 1) {
                    current.isEndOfWord = true;
                }
            }
        }
    }
}
