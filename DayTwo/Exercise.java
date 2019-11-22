import java.lang.reflect.Array;
import java.util.*;
public class Exercise {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode c1 = new ListNode(9);
        ListNode c2 = new ListNode(9);
        ListNode c3 = new ListNode(9);

        l1.next = c1;
        c1.next = c2;
        c2.next = c3;
        ListNode l2 = new ListNode(9);

        AddTwoNumbers adder = new AddTwoNumbers();
        adder.addTwoNumbers(l1, l2);

        ReverseInteger ri = new ReverseInteger();
        ri.reverse(-454654);
    }


}

class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }













//    public static int[] twoSum(int[] nums, int target) {
//        for(int i =0; i < nums.length; i++){
//            if(nums[i] <= target){
//                for (int j = 0; j < nums.length; j++) {
//
//
////                    if (nums[j] <= target) {
//                        if (nums[i] + nums[j] == target){
//                            System.out.println(i);
//                            System.out.println(j);
//                            return new int[]{i, j};
//                        }
////                    }
//                }
//            }
//        }
//        return new int[]{1, 2};
//    }