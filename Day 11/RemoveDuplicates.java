// Question : 

public class RemoveDuplicates {

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null) return null;
        if(head.next == null) return head;

        ListNode pointer = new ListNode(0);
        pointer.next = head;
        ListNode next = head.next;
        int current;

        while(next != null){ 

            if(head.val == next.val){
                current = head.val;
                next = next.next;
            }else{
                head.next = next;
                head = head.next;
                next = head.next;

            }
        }
        head.next = next;
        return pointer.next;

    }
}
