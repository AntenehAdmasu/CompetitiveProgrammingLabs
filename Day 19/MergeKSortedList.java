// Question link : https://leetcode.com/problems/merge-k-sorted-lists/

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(new ListNodeComparator());
        for (ListNode l : lists) {
            while (l.next != null) {
                heap.add(new ListNode(l.val));
                l = l.next;
            }
        }
        ListNode handle = new ListNode(0);
        ListNode head = heap.poll();
        handle.next = head;

        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            head.next = node;
            head = node;
        }

        return handle.next;
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