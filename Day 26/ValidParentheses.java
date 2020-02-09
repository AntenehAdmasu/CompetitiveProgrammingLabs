// Question link : https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

public class ValidParentheses {

    public int minAddToMakeValid(String S) {
        int openCounter = 0;
        int closedCounter = 0;
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '(') openCounter++;
            else{
                if(openCounter >= closedCounter){
                    openCounter--;
                }else{
                    closedCounter++;
                }
            }
        }
        return openCounter + closedCounter;

    }
}
