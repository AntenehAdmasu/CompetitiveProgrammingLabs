// Question link : https://leetcode.com/problems/target-sum/

import java.util.HashMap;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {

        HashMap<State, Integer> lookup = new HashMap<>();
        int possibilities1 = traverseDfs(nums[0] * -1, nums, 0, lookup, S);
        int possibilities2 = traverseDfs(nums[0], nums, 0, lookup, S);

        return possibilities1 + possibilities2;
    }

    public int traverseDfs(int value, int[] nums, int index, HashMap<State,Integer> lookup, int target){
        
        State state = new State(index, target-value);
        int answer = 0;
        
        if(lookup.containsKey(state)){
            return lookup.get(state);
        }
        
        if (index == nums.length-1){
            if (target - value == 0){
                lookup.put(state, 1);
                return 1;
            }
            return 0;
        }else{
            int possi1 = traverseDfs(nums[index+1],nums,index+1,lookup,target-value);
            int possi2 = traverseDfs(nums[index+1]*-1,nums,index+1,lookup,target-value);
            answer = possi1 + possi2;
        }
        
        lookup.put(state, answer);
        return answer;        
    }
   
}


class State {

    int index;
    int target;

    public State (int index, int target){
        this.index = index;
        this.target = target;
    }

    @Override
    public boolean equals(Object o){
        State s = (State) o;
        return this.index == s.index && this.target == s.target;
    }

    @Override
    public int hashCode(){
        return ("" + index + " " + target).hashCode();
    }

}