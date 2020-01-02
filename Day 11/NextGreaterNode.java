// Question : https://leetcode.com/problems/next-greater-node-in-linked-list/

import java.util.ArrayList;

public class NextGreaterNode {

   public int[] nextLargerNodes(ListNode head) {

        ArrayList<Integer> answer = new ArrayList<>();
        int i = 0;
        while (head != null){
            ListNode next = head.next;
            boolean foundLarger = false;
            while (next != null){
                if(next.val > head.val){
                    answer.add(i, next.val);
                    foundLarger = true;
                    break;
                }
                next = next.next;
            }
            if(!foundLarger) answer.add(i, 0);
            foundLarger = false;
            i++;
            head = head.next;
        }

        int[] ans = answer.stream().mapToInt(k -> k).toArray();

        return ans;
    }

}
