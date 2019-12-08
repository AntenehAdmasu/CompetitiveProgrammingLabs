public class SwapNodeInPairs {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
//        ListNode e = new ListNode(5);

        a.next = b; b.next = c; c.next = d;// d.next = e;

        ListNode h = new SwapNodeInPairs().swapPairsLoop(a);

        while (h != null){
            System.out.println("#"+h.val);
            h = h.next;
        }

    }

    public ListNode swapPairs(ListNode head) {
        int i = 0;
        ListNode pointer = new ListNode(0);

        ListNode next = head.next;
        ListNode temp = next.next;
        ListNode previous = null;

                    //SWAPPING NODES
                    if(i != 0) previous.next = next;
                    next.next = head;
                    head.next = temp;
                    if (i == 0)pointer.next = next; i++;

                    //UPDATING NODES
                    previous = head;
                    head = temp;
                    next = head.next;
                    temp = next.next;


        System.out.println("previous is " + previous.val);
        System.out.println("head is " + head.val);
        System.out.println("next is " + next.val);
        System.out.println("temp is " + temp.val);
        System.out.println();


                    //SWAPPING NODES
                    if(i != 0) previous.next = next;
                    next.next = head;
                    head.next = temp;
                    if (i == 0)pointer.next = next; i++;

                    //UPDATING NODES
                    previous = head;
                    head = temp;
                    next = head.next;
                    temp = next.next;


        System.out.println("previous is " + previous.val);
        System.out.println("head is " + head.val);
        System.out.println("next is " + next.val);
        System.out.println("temp is " + temp.val);
        System.out.println();

                    //SWAPPING NODES
                    if(i != 0) previous.next = next;
                    next.next = head;
                    head.next = temp;
                    if (i == 0)pointer.next = next; i++;

                    //UPDATING NODES
                    previous = head;
                    head = temp;
                    next = head.next;
                    temp = next.next;


        if(i != 0) previous.next = next;
        next.next = head;
        head.next = temp;
        if (i == 0)pointer.next = next; i++;

        System.out.println("previous is " + previous.val);
        System.out.println("head is " + head.val);
        System.out.println("next is " + next.val);
//        System.out.println("temp is " + temp.val);

        return pointer.next;


    }


    public ListNode swapPairsLoop(ListNode head) {
        if(head == null || head.next == null)  return head;
        int i = 0;

        ListNode next = head.next;
        ListNode temp = next.next;
        ListNode pointer = new ListNode(0);
        ListNode previous = null;

        while(next != null && temp != null ){

            if(i != 0) previous.next = next;
            next.next = head;
            head.next = temp;
            if (i == 0)pointer.next = next; i++;

            //UPDATING NODES
            previous = head;
            head = temp;
            next = head.next;
            if(next == null) return pointer.next;
            temp = next.next;

        }

        if(i != 0) previous.next = next;
        next.next = head;
        head.next = temp;
        if (i == 0)pointer.next = next; i++;

        return pointer.next;
    }





}
