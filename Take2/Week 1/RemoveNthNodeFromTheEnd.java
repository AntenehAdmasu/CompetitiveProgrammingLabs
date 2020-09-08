import java.util.ArrayList;

public class RemoveNthNodeFromTheEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return n == 1 ? null : head;
        }
        ListNode fast = head;
        int nodes = 0;
        while(fast != null && fast.next != null){
            nodes += 2;
            fast = fast.next.next;
        }
        nodes += fast != null ? 1 : 0;
        int counter = 0;
        ListNode handler = new ListNode(-1);
        handler.next = nodes == n ? head.next : head;

        while (++counter < nodes - n){
            head = head.next;
        }
        head.next = head.next.next;
        return handler.next;
    }

}
