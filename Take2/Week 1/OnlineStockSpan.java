import java.util.Stack;

public class OnlineStockSpan {
    Stack<int[]> stack;
    public OnlineStockSpan() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int counter = 1;
        if(!stack.isEmpty() && stack.peek()[0] <= price){
            while (!stack.isEmpty() && stack.peek()[0] <= price){
                counter += stack.pop()[1];
            }
        }
        stack.add(new int[]{price, counter});
        return stack.peek()[1];
    }
}
