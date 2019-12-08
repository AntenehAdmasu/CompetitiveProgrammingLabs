import java.util.ArrayList;

public class StackWithQueue {
    ArrayList<Integer> myStack;
    int pointer;
    public StackWithQueue(){
        this.myStack = new ArrayList<>();
        this.pointer = 0;
    }

    public void push(int x){
        myStack.add(0,x);
    }

    public int pop(){
        int val = myStack.get(0);
        myStack.remove(0);
        return val;
    }

    public int peek(){
        int val = myStack.get(0);
        return val;
    }

    public boolean empty(){

        return myStack.size() == 0;
    }

}
