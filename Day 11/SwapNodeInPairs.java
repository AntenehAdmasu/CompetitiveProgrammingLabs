// Question : https://leetcode.com/problems/swap-nodes-in-pairs/

public class SwapNodeInPairs {
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null)  return head;
        int i = 0;

        ListNode next = head.next;
        ListNode temp = next.next;
        ListNode handler = new ListNode(0);
        ListNode previous = null;

        while(next != null && temp != null ){

            if(i != 0) previous.next = next;
            next.next = head;
            head.next = temp;
            if (i == 0)handler.next = next; i++;

            previous = head;
            head = temp;
            next = head.next;
            if(next == null) return handler.next;
            temp = next.next;

        }

        if(i != 0) previous.next = next;
        next.next = head;
        head.next = temp;
    
        if (i == 0)handler.next = next; i++;

        return handler.next;
    }





}
