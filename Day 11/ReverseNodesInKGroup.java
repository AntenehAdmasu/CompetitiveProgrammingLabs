import java.util.List;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        ListNode h = new ListNode(8);
        ListNode i = new ListNode(9);
        ListNode j = new ListNode(10);
        ListNode m = new ListNode(11);
        ListNode n = new ListNode(12);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;
        i.next =  j;
        j.next =  m;
//        m.next =  n;


        ListNode handle = new ReverseNodesInKGroup().reverseKGroup(a,15);

        while (handle != null){
//        for (int k = 0; k < 10; k++) {


            System.out.println("#"+handle.val);
            handle = handle.next;
        }
    }


    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode previous = null;
        ListNode pointer = new ListNode(0);
        ListNode start = null;
        ListNode endOfPrevious = null;

        ListNode next = null;

        int loopcount = 1;
        while (isEnough(head,k)){
            System.out.println("head is " + head.val);

            for (int i = 0; i < k; i++) {
                if(i == 0) start = head;
                next = head.next;

                head.next = (i == 0) ? endOfPrevious: previous;

                // UPDATING NODES
                previous = head;
                head = next;

            }
            if(loopcount == 1){
                System.out.println("handler is " + previous.val);
                pointer.next = previous;
            }
            if(loopcount > 1) endOfPrevious.next = previous;

            endOfPrevious = start;
            loopcount++;

        }

        if(head == null){
            endOfPrevious.next = null;
        }else if(! (endOfPrevious == null)){
            endOfPrevious.next = head;
        }else{
            return head;
        }

        return pointer.next;

    }

    public boolean isEnough(ListNode item, int k){
        for (int i = 0; i < k; i++) {
            if(item == null){
                return false;
            }
            item = item.next;
        }
        return true;
    }
}
