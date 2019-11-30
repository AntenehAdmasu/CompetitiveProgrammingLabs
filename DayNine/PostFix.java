import java.util.Stack;

public class PostFix {
    public int evalRPN(String[] tokens) {
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")  ){
                switch (tokens[i]){
                    case ("+"):
                        answer = stack.pop() + stack.pop();
                        stack.push(answer);
                        break;
                    case ("-"):
                        int operand1 = stack.pop();
                        int operand2 = stack.pop();
                        answer = operand2 - operand1;
                        stack.push(answer);
                        break;
                    case ("*"):
                        answer = stack.pop() * stack.pop();
                        stack.push(answer);
                        break;
                    case ("/"):
                        int operand1div = stack.pop();
                        int operand2div = stack.pop();
                        answer = operand2div / operand1div;
                        stack.push(answer);

                        break;
                }
            }else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }


}
