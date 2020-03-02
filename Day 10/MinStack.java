// Question : https://leetcode.com/problems/min-stack/

import java.util.ArrayList;
import java.util.Collections;


public class MinStack {

    ArrayList<ValueMinimumPair> stack;

    public MinStack() {
        stack = new ArrayList<>();
    }

    public void push(int x) {
        int minimum = Math.min(x, getMin());
        ValueMinimumPair item = new ValueMinimumPair(x, minimum); 
        stack.add(item);
    }

    public void pop() {
        if (stack.size() > 0) {
            stack.remove(stack.size() - 1);
        }
    }

    public int top() {
        return stack.size() > 0 ? stack.get(stack.size() - 1).value : -1; 
    }

    public int getMin() {
        return stack.size() > 0 ? stack.get(stack.size()-1).min : Integer.MAX_VALUE;
    }

}


class ValueMinimumPair{
    int value;
    int min;
    public ValueMinimumPair(int val, int minimum){
        this.value = val;
        this.min = minimum;
    }
}