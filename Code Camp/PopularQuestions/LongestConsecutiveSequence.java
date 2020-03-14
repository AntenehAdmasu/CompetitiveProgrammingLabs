// Question link : https://leetcode.com/problems/longest-consecutive-sequence/solution/

import java.util.HashSet;

public class LongestConsecutiveSequence {


    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        HashSet<Integer> numbers = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        
        int maxChain = 1;
        for(int x: nums){
            numbers.add(x);
        }
        
        for(int x : nums){
            if(!visited.contains(x)){
                int count = dfs(x, numbers, visited);
                maxChain = Math.max(maxChain, count);
            }
        }
        return maxChain;
    }
    
    public int dfs(int number, HashSet<Integer> numbers, HashSet<Integer> visited){
        visited.add(number);
        int count = 1;
        
        if(numbers.contains(number - 1) && !visited.contains(number - 1)){
            count += dfs(number - 1, numbers, visited);
        }
        if(numbers.contains(number + 1) && !visited.contains(number + 1)){
            count += dfs(number + 1, numbers, visited);
        }
        return count;
    }


}


0214214214214214214214214214214214214214