// Question https://leetcode.com/problems/validate-stack-sequences/

import java.util.Stack;

public class ValidateStackSequence {
    public static void main(String[] args) {
        int[] pushed = new int[]{2,3,0,1};

//        int[] popped = new int[]{4,3,5,1,2};

        int[] popped2 = new int[]{0,3,2,1};

        System.out.println(new ValidateStackSequence().validateStackSequences(pushed, popped2));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        int pushedPointer = 0;
        boolean nextX = false;
        boolean found = true;
        Stack<Integer> stack = new Stack<>();
        for (int x: popped) {
            if(!stack.empty() && stack.peek() == x){
                stack.pop();
                continue;
            }else{
                while (pushedPointer < pushed.length){
                    stack.push(pushed[pushedPointer]);
                    if(stack.peek() == x) {
                        stack.pop();
                        nextX = true;
                        pushedPointer++;
                        break;
                    }
                    pushedPointer++;
                }

                if(nextX){
                    nextX = false;
                    continue;
                }
                while (!stack.empty()){
                    int top = stack.pop();
                    if(top == x){
                        found = true;
                        break;
                    }
                }
                if (found){
                    found = false;
                    continue;
                }
                return false;

            }
        }
        return true;
    }
}
