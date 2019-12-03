public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;

        ListNode h = new ReverseLinkedList().reverseList(l1);
        while (h != null){
            System.out.println(h.val);
            h = h.next;
        }

    }

    public ListNode reverseList(ListNode head) {

        if(head.next != null){
            ListNode previous = head;
            ListNode current = previous.next;
            ListNode temp = current.next;
            previous.next = null;

            while(current.next != null){

                current.next = previous;

                previous = current;
                current = temp;
                temp = temp.next;
            }

            current.next = previous;
            return current;
        }
        return head;
    }

}

class ListNode {
    int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
