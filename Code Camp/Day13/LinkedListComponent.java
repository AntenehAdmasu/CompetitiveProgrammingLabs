// Question link : https://leetcode.com/contest/weekly-contest-80/problems/linked-list-components

import java.util.HashSet;

public class LinkedListComponent {


    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> GIndex = new HashSet<>();
        int totalConnected = 0;

        for (int i = 0; i < G.length; i++) {
            GIndex.add(G[i]);
        }

        boolean isInConnection = false;

        while(head != null) {
            int currenntVal = head.val;
            if(GIndex.contains(currenntVal)){
                if(!isInConnection) totalConnected += 1;
                isInConnection = true;

            }
            if(head.next == null) break;
            int nextVal = head.next.val;

            if(GIndex.contains(currenntVal) && GIndex.contains(nextVal) ){
                totalConnected += isInConnection ? 0 : 1;
                isInConnection = true;
            }else{
                isInConnection = false;
            }

            head = head.next;
        }

        return totalConnected;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
