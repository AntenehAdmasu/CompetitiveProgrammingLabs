import java.util.ArrayList;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ArrayList<Integer> half = new ArrayList<>();
        while(fast != null && fast.next != null){
            half.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        // If the LL is even
        int index = half.size() - 1;
        if(fast != null){
            slow = slow.next;
        }
        while (slow != null){
            if(half.get(index--) != slow.val){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
