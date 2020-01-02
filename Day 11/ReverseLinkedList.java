// Question : 

public class ReverseLinkedList {

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
