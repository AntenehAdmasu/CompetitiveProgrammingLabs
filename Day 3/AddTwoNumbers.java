public class AddTwoNumbers {



        public static ListNode addTwoNumbers(ListNode l1, ListNode l2 ) {

        ListNode handler = new ListNode(0);
        ListNode pointer = handler;

        int carry = 0;
        while(l1!=null || l2!=null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum > 9 ? 1 : 0;

            sum %= 10;
            ListNode l = new ListNode(sum);
            pointer.next = l;
            pointer = pointer.next;


        }
            if(carry > 0){
                ListNode l = new ListNode(carry);
                pointer.next = l;
            }

        return handler.next;

    }

}
