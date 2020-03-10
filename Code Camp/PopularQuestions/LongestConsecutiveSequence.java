// Question link : https://leetcode.com/problems/longest-consecutive-sequence/solution/

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> numbers = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();

        int maxChain = 1;
        for(int x: nums){
            numbers.add(x);
        }

        for(int x : nums){
            if(!visited.contains(x)){
                HashSet<Integer> members = new HashSet<>();
                dfs(x, numbers, visited, members);
                maxChain = Math.max(maxChain, members.size());
            }
        }
        return maxChain;
    }

    public void dfs(int number, HashSet<Integer> numbers, HashSet<Integer> visited, HashSet<Integer> members){
        members.add(number);
        visited.add(number);
        if(numbers.contains(number - 1) && !visited.contains(number - 1)){
            dfs(number - 1, numbers, visited, members);
        }
        if(numbers.contains(number + 1) && !visited.contains(number + 1)){
            dfs(number + 1, numbers, visited, members);
        }

    }


}


