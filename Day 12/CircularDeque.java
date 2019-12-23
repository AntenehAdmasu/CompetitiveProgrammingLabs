import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class CircularDeque {
    public int queueSize;
    public int addedValues;
    public int first;
    public int last;
    int[] queue;


    public static void main(String[] args) {

        CircularDeque circularDeque = new CircularDeque(8);


        System.out.println(circularDeque.insertFront(5));
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.isEmpty());
        System.out.println(circularDeque.deleteFront());
        System.out.println(circularDeque.insertLast(3));
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.insertLast(7));
        System.out.println(circularDeque.insertFront(7));
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.insertLast(4));
        System.out.println(circularDeque.isEmpty());



    }

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public CircularDeque(int k) {
        queueSize = k;
        addedValues = 0;
        queue = new int[queueSize];
        first = 0;
        last = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()) return false;

        if(isEmpty()){
            addedValues++;
            queue[first] = value;
            return true;
        }
        first++;
        first = first % (queueSize);
        addedValues++;
        queue[first] = value;

        return true;
    }


    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()) return false;
        if(isEmpty()){
            queue[last] = value;
            addedValues++;
            return true;
        }
        last--;
        last += (last < 0) ? queueSize : 0;

        queue[last] = value;
        addedValues++;

        return true;
    }


    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) return false;
        if(addedValues == 1) return true;
        first--;
        if(first<0) first += queueSize;
        addedValues--;

        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) return false;
        if(addedValues == 1) return true;

        last++;
        last = last % queueSize;

        addedValues--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()) return -1;
        return queue[first];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()) return -1;
        return queue[last];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return addedValues == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return addedValues == queueSize;
    }

}
