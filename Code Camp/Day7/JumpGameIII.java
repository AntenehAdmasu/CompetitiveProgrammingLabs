// Question link : https://leetcode.com/problems/jump-game-iii/

import java.util.HashSet;
import java.util.Stack;

public class JumpGameIII {

    public static void main(String[] args) {
        int[] test = new int[]{4,2,3,0,3,1,2};
        System.out.println(new JumpGameIII().canReach(test,5));
    }
    public boolean canReach(int[] arr, int start) {
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        visited.add(start);
        while (!stack.isEmpty()){
            int val = stack.pop();
            if(arr[val] == 0) return true;
            if(val - arr[val] >= 0 && !visited.contains(val - arr[val])){
                stack.push(val-arr[val]);
                visited.add(val-arr[val]);
            }
            if(val + arr[val] < arr.length && !visited.contains(val + arr[val])) {
                stack.push(val + arr[val]);
                visited.add(val + arr[val]);
            }
        }
        return false;
    }

}
