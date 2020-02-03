// Question link : https://leetcode.com/problems/orderly-queue/

import java.util.Arrays;

public class OrderlyQueue {
    public static void main(String[] args) {
        System.out.println("gfdr".compareTo("aaaa"));
    }

    public String orderlyQueue(String S, int K) {
        String minimumWord = "";
        if(K >= 2){
            char[] word = S.toCharArray();
            Arrays.sort(word);
            StringBuilder sorted = new StringBuilder();
            sorted.append(word);
            System.out.println(sorted.toString());
            return sorted.toString();
        }
        else{
            for (int i = 0; i < S.length(); i++) {
                String newWord = S.substring(i) + S.substring(0,i);
                if(newWord.compareTo(minimumWord) == -1){
                    minimumWord = newWord;
                }
            }
        }
        return minimumWord;
    }

}
