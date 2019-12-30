import java.util.List;

public class ReverseNodesInKGroup {


    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode previous = null;
        ListNode pointer = new ListNode(0);
        ListNode start = null;
        ListNode endOfPrevious = null;
        ListNode next = null;

        int loopcount = 1;
        while (isEnough(head,k)){

            for (int i = 0; i < k; i++) {
                if(i == 0) start = head;
                next = head.next;

                head.next = (i == 0) ? endOfPrevious: previous;

                // UPDATING NODES
                previous = head;
                head = next;

            }
            if(loopcount == 1){
                pointer.next = previous;
            }
            if(loopcount > 1) endOfPrevious.next = previous;

            endOfPrevious = start;
            loopcount++;

        }

        if(head == null){
            endOfPrevious.next = null;
        }else if(! (endOfPrevious == null)){
            endOfPrevious.next = head;
        }else{
            return head;
        }

        return pointer.next;
    }


    public boolean isEnough(ListNode item, int k){
        for (int i = 0; i < k; i++) {
            if(item == null){
                return false;
            }
            item = item.next;
        }
        return true;
    }
}
