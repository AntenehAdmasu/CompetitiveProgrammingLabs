// Question link : https://leetcode.com/problems/number-of-equivalent-domino-pairs/

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class EquivalentDomino {

    public static void main(String[] args) {
        int[][] test = new int[][]{
                new int[]{1,2},
                new int[]{2,1},
                new int[]{1,2},
                new int[]{1,2}
//                new int[]{1,2}
            };
        System.out.println(new EquivalentDomino().numEquivDominoPairs(test));
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<Integer, Integer> occ = new HashMap<>();
        int equivalentCounter = 0;
        for (int i = 0; i < dominoes.length; i++) {

        	// Swapping to make it sorted
            if(dominoes[i][1] < dominoes[i][0]){
                int temp = dominoes[i][1];
                dominoes[i][1] = dominoes[i][0];
                dominoes[i][0] = temp;
            }
            
            int num =Integer.parseInt("" + dominoes[i][0] + dominoes[i][1]);
            if(occ.containsKey(num)){
                equivalentCounter += occ.get(num);
                occ.put(num, occ.get(num) + 1);
            }else{
                occ.put(num,1);
            }
        
        }

        return equivalentCounter;
    }
}
