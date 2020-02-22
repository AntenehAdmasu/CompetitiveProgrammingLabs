// Question link : https://leetcode.com/problems/single-number-iii/

import java.util.ArrayList;

public class SingleNumberIII {


    public int[] singleNumber(int[] nums) {
        int result = 0;

        ArrayList<Integer> ones = new ArrayList<>();
        ArrayList<Integer> zeroes = new ArrayList<>();
        int[] answer = new int[2];

        for(int i = 0; i < nums.length; i++){
            result ^= nums[i];
        }

        int bitNumber=0;
        for(int i = 0; i < 32; i++){

            if(((result>>i) % 2) != 0){
                bitNumber = i;
                break;
            }
        }

        for(int num: nums){
            if(((num>>bitNumber) & 1) == 1){
                ones.add(num);
                continue;
            }
            zeroes.add(num);
        }

        int res1 = 0;
        for(int num = 0; num < ones.size(); num++){
            res1 ^= ones.get(num);
        }
        answer[0] = res1;

        int res2 = 0;
        for(int num = 0; num < zeroes.size(); num++){
            res2 ^= zeroes.get(num);
        }
        answer[1] = res2;


        return answer;
    }
}
