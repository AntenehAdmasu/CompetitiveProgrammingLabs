public class RemoveDuplicates {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
//        ListNode l6 = new ListNode(4);
//        ListNode l7 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
//        l5.next = l6;
//        l6.next = l7;

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
            System.out.println("In while");

            System.out.println("head's val " + head.val);
            System.out.println("next's val " + next.val);

            if(head.val == next.val){

                System.out.println("in if");

                current = head.val;
                next = next.next;
            }else{
                System.out.println("in else");
                head.next = next;
                head = head.next;
                next = head.next;

            }
        }
        head.next = next;
        return pointer.next;

    }
}
