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

    }

        public int pop(){
        out++;
        size--;
        return list.get(out--);

    }

        public int peek(){
        return list.get(out);
    }

        public boolean empty(){
        return this.size == 0;
    }


}
