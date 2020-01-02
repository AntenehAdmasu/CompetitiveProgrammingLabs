// Question : 

public class MergeTwoSortedLists {

    public ListNode2 mergeTwoLists(ListNode2 l1, ListNode2 l2) {
        int val = l1.val > l2.val ? l2.val: l1.val;

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

