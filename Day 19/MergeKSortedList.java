// Question link : https://leetcode.com/problems/merge-k-sorted-lists/

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {

    
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(new ListNodeComparator());
        ListNode handler = new ListNode(0);
        ListNode pointer = handler;
        
        for (ListNode l:lists) {
            if(l != null){
                heap.add(l);
            }
        }
        
        while (!heap.isEmpty()){
            ListNode node = heap.poll();
            handler.next = node;
            handler = handler.next;
            if(node.next != null) heap.add(node.next);
        }
        return pointer == null ? pointer : pointer.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class ListNodeComparator implements Comparator<ListNode> {

    // Comparing Listnodes nodes based on their values
    @Override
    public int compare(ListNode l1, ListNode l2) {
        if (l1.val == l2.val) return 0;
        return l1.val < l2.val ? -1 : 1;
    }
}