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
}
