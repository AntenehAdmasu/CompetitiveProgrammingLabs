public class KthLargest {

    static int[] heap;
    int size;
    int heapsize;

    public static void main(String[] args) {
        int[] nums = new int[]{};
        KthLargest c = new KthLargest(1,nums);

        for (int x: heap) {
//            System.out.println("* " + x);
        }

        System.out.println(c.add(-3));

        System.out.println(c.add(-2));

        System.out.println(c.add(-4));

        System.out.println(c.add(0));

        System.out.println(c.add(4));

    }


    public KthLargest(int k, int[] nums) {
        heap = new int[k];
        size = 0;
        heapsize = k;
        for (int i = 0;i < nums.length && i < k; i++) {
            insert(nums[i]);
        }

        for (int i = k; i < nums.length && i < nums.length; i++) {
            if(nums[i] > heap[0]){
                delete(heap);
                insert(nums[i]);
            }
        }
    }

    public int add(int val) {
        if(size < heapsize){
            insert(val);

        }else if(val > heap[0]){
            delete(heap);
            insert(val);
        }
        return heap[0];
    }

    public void insert(int val) {
        heap[size] = val;
        size++;
        int i = size-1;
        while (heap[i] < heap[(parent(i))]) {
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
    }

    public void delete(int[] numbers) {
        // SWAP THE FIRST WITH THE LAST
        int temp = heap[0];
        heap[0] = heap[size-1];
        heap[size-1] = temp;
        size--;
        for (int x: heap) {
//            System.out.println("SS* " + x);
        }
        sinkDown(0);
        for (int x: heap) {
//            System.out.println("DD* " + x);
        }
    }

    public void sinkDown(int pos){
        int smallerChild;
        if(rightChild(pos) < size && heap[rightChild(pos)] < heap[pos]){
            smallerChild = heap[leftChild(pos)] < heap[rightChild(pos)] ? leftChild(pos) : rightChild(pos);
        }else if ((leftChild(pos) < size && heap[leftChild(pos)] < heap[pos])){
            smallerChild = leftChild(pos);
        }else{
            return;
        }
        int temp = heap[pos];
        heap[pos] = heap[smallerChild];
        heap[smallerChild] = temp;
        sinkDown(smallerChild);
    }





    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int leftChild(int i) {
        return i * 2 + 1;
    }

    public int rightChild(int i) {
        return i * 2 + 2;
    }


}
