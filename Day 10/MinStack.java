// Question : https://leetcode.com/problems/min-stack/

import java.util.ArrayList;
import java.util.Collections;

public class MinStack {

    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(5);
    }

        private ArrayList<Integer> stack;
        int min = 0;

        public MinStack() {
            stack = new ArrayList<>();
        }

        public void push(int x) {
            stack.add(x);
            min = Collections.min(stack);
        }

        public void pop() {
            if (getSize() > 0) {
                int item = stack.remove(getSize() - 1);
                if (item == min && !isEmpty()) {
                    min = Collections.min(stack);
                }
            }
        }

        public int top() {
            if (getSize() > 0) {
                return stack.get(getSize() - 1);
            }
            return 0;
        }

        public int getMin() {
            return min;
        }

        public boolean isEmpty(){
            return getSize() == 0;
        }

        public int getSize() {
            return stack.size();
        }

}
