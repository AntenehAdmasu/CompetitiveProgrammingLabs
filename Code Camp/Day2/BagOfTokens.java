// Question link : https://leetcode.com/problems/bag-of-tokens/submissions/

import java.util.Arrays;

public class BagOfTokens {
    public static void main(String[] args) {
        int[] tokens = new int[]{100,200,300,400};
        int[] tokens2 = new int[]{100,200};
        new BagOfTokens().bagOfTokensScore(tokens, 200);
    }


    public int bagOfTokensScore(int[] tokens, int P) {
        if(tokens.length == 0) return 0;
        Arrays.sort(tokens);
        int start = 0;
        int end = tokens.length - 1;
        int maxPoint = 0;
        int point = 0;
        if(P < tokens[0]) return 0;

        while(start < end) {
            if (P >= tokens[start]) {
                P -= tokens[start++];
                point += 1;
                maxPoint = Math.max(point, maxPoint);
            } else if (point > 0) {
                P += tokens[end--];
                point -= 1;
            }
        }
        if(start == end && P >= tokens[start]) maxPoint = Math.max(point + 1, maxPoint);
        return maxPoint;
    }



}
