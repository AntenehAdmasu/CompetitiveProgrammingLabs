// Question link : https://leetcode.com/problems/generate-parentheses/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        HashSet<String> combinations = new HashSet<>();

        String single = "()";
        if (n == 1) {
            result.add(single);
            return result;
        }
        List<String> recur = generateParenthesis(n - 1);
        for (String comb : recur) {
            for (int i = 0; i < comb.length(); i++) {
                String newComb = comb.substring(0, i) + single + comb.substring(i, comb.length());
                if (!combinations.contains(newComb)) {
                    result.add(newComb);
                    combinations.add(newComb);
                }
            }
        }

        return result;
    }
}
