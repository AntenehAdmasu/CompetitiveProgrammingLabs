import java.util.ArrayList;

public class Stack {
    ArrayList<String> myStack;
    int pointer;
    public Stack(){
        this.myStack = new ArrayList<>();
        this.pointer = 0;
    }

    public void push(String e){
        myStack.add(e);
        pointer = myStack.size() - 1;
    }

    public String pop(){
        if (myStack.size() > 0){
            String val = myStack.get(this.pointer);
            myStack.remove(pointer);
            pointer = myStack.size() - 1;
            return val;
        }else{
            return null;
        }
    }

    public String view(){
        if (myStack.size() > 0){
            String val = myStack.get(this.pointer);
            return val;
        }else{
            System.out.println("In else of view");
            return "";
        }
    }

    public boolean isEmpty(){
        return (myStack.size() == 0);
    }

    public int getSize(){
        return myStack.size();
    }





}
