public class RemoveDuplicates {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3); 
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5; 

        ListNode l = new RemoveDuplicates().deleteDuplicates(l1);
        while (l != null){
            System.out.println(l.val);
            l = l.next;
        }

    }


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
