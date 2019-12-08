public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode2 l1 = new ListNode2(1);
        ListNode2 l2 = new ListNode2(3);
        ListNode2 l3 = new ListNode2(6);
        ListNode2 l4 = new ListNode2(10);
        ListNode2 l5 = new ListNode2(15);

        ListNode2 k1 = new ListNode2(22);


        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode2 m1 = new ListNode2(2);
        ListNode2 m2 = new ListNode2(4);
        ListNode2 m3 = new ListNode2(7);
        ListNode2 m4 = new ListNode2(8);
        ListNode2 m5 = new ListNode2(25);
        ListNode2 m6 = new ListNode2(35);


        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = m5;
        m5.next = m6;


        ListNode2 x = new MergeTwoSortedLists().mergeTwoLists(k1, m1);

        while (x != null){
            System.out.println(x.val);
            x = x.next;
        }
    }

    public ListNode2 mergeTwoLists(ListNode2 l1, ListNode2 l2) {
        int val = l1.val > l2.val ? l2.val: l1.val;

        System.out.println("Initial is " + val);
        ListNode2 head = new ListNode2(val);
        ListNode2 pointer = new ListNode2(0);
        pointer.next = head;
        if (l1.val < l2.val){
            l1 = l1.next;
        }else{
            l2 = l2.next;
        }


        while((l1 != null) && (l2 != null)){
            if(l1.val < l2.val ){

                head.next = l1;
                head = l1;
                l1 = l1.next;
            }else{

                head.next = l2;
                head = l2;
                l2 = l2.next;
            }


        }

        head.next = l1 == null? l2 : l1;

        return pointer.next;
    }



}



class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2(int x) { val = x; }
}

