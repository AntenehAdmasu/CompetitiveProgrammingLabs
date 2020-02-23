// Question link : https://leetcode.com/problems/house-robber-ii/

import java.util.HashMap;

public class HouseRobberII {

    public static void main(String[] args) {
        int[] houses2 = {1, 2, 3, 4, 5};
        System.out.println("house 1 " + new HouseRobberII().rob(houses2));
    }


    public int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int max = 0;
        if (nums.length < 4) {
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }
        HashMap<String,Integer> lookup = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            int nearer = traverseDfs(nums, i+2, i, lookup);
            int farther = traverseDfs(nums, i+3, i, lookup);
            int maxFromI = nums[i] + Math.max(nearer, farther);
            String key = i + " " + i;
            max = Math.max(max, maxFromI);
        }
        return max;

    }


    private int traverseDfs(int[] nums, int index, int startIndex, HashMap<String,Integer> lookup ) {

        int newindex = index % nums.length;
        String key = ""+startIndex+" "+index;

        if (Math.abs(newindex - startIndex) < 2 || ((Math.abs(nums.length - index) + Math.abs(0 - startIndex)) < 2)) {
            lookup.put(key,0);
            return 0;
        }

        if(lookup.containsKey(key)){
            return lookup.get(key);
        }

        int maxResult = Math.max(traverseDfs(nums, index + 2, startIndex,lookup), traverseDfs(nums, index + 3, startIndex, lookup));
        int totalResult = maxResult + nums[newindex];
        lookup.put(key, totalResult);

        return totalResult;

    }
}
