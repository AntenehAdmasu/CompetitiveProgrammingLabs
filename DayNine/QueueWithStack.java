import java.util.ArrayList;

public class QueueWithStack {
    ArrayList<Integer> list;
    int size, out;

    public QueueWithStack(){

        this.list = new ArrayList();
        this.out = 0; this.size = 0;
    }

        public void push(int x){
        list.add(x);
        size++;
        System.out.println(this.empty());
        if (this.empty()){
            out++;
        }
        System.out.println("out in push " + out);

    }

        public int pop(){
        System.out.println("out is " + out);
        out++;
        size--;
        return list.get(out--);

    }

        public int peek(){
        System.out.println("In peek , out is " + out);
        return list.get(out);
    }

        public boolean empty(){
        return this.size == 0;
    }


}
