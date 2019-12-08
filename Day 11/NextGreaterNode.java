import java.util.ArrayList;

public class NextGreaterNode {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(7);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(9);
        ListNode f = new ListNode(2);
        ListNode g = new ListNode(5);
        ListNode h = new ListNode(1);



        a.next = b; b.next = c; c.next = d; d.next = e; e.next = f; f.next = g; g.next = h;

        int[] x =  new NextGreaterNode().nextLargerNodes(a);

        for (int i = 0; i < x.length ; i++) {
            System.out.println(x[i]);
        }
    }

    public int[] nextLargerNodes(ListNode head) {

        ArrayList<Integer> answer = new ArrayList<>();
        int i = 0;
        while (head != null){
            ListNode next = head.next;
            boolean foundLarger = false;
            while (next != null){
                if(next.val > head.val){
                    answer.add(i, next.val);
                    foundLarger = true;
                    break;
                }
                next = next.next;
            }
            if(!foundLarger) answer.add(i, 0);
            foundLarger = false;
            i++;
            head = head.next;
        }

        int[] ans = answer.stream().mapToInt(k -> k).toArray();

        return ans;
    }

}
