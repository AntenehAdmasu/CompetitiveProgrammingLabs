import java.util.Arrays;
import java.util.Comparator;

public class RearrangeWordsInSentence {

    public static void main(String[] args) {
        new RearrangeWordsInSentence().arrangeWords("Keep calm and code on");
    }
    public String arrangeWords(String text){

        String[] words = text.split(" ");
        Arrays.sort(words, new WordComparator());

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if(i == 0){
                String capitalized = word.substring(0, 1).toUpperCase() + word.substring(1);
                answer.append(capitalized + " ");
                continue;
            }
            answer.append(word.toLowerCase() + " ");
        }
        String ans = answer.toString();
        return ans.substring(0, ans.length() - 1);

    }
}

class WordComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}