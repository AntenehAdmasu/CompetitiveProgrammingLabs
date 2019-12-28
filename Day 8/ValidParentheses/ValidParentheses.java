// Question : https://leetcode.com/problems/valid-parentheses

public class ValidParentheses {
    public static void main(String[] args) {
        boolean ans = isValid("");
        System.out.println("Your input is " + ans);
    }
    public static boolean isValid(String s) {
        Stack parentheses = new Stack();

        for (int i = 0; i < s.length(); i++) {
            String symbol = Character.toString(s.charAt(i));
            switch (symbol){
                case ("("):
                    parentheses.push("(");
                    break;
                case ("{"):
                    parentheses.push("{");
                    break;
                case ("["):
                    parentheses.push("[");
                    break;
                case (")"):
                    if (parentheses.view().equals("(")){
                        parentheses.pop();
                    }else {
                        return false;
                    }
                    break;
                case ("}"):

                    if (parentheses.view().equals("{")){
                        parentheses.pop();
                    }else {
                        return false;
                    }
                    break;
                case ("]"):
                    if (parentheses.view().equals("[")){
                        parentheses.pop();
                    }else {
                        return false;
                    }
                    break;
            }

        }
        return parentheses.isEmpty();
    }
}
