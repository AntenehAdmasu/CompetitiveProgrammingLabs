// Question link : https://leetcode.com/problems/delete-and-earn/

import java.util.ArrayList;

public class DeleteAndEarn {

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,2,4,3,4,2,4,2,4,3,2,1,3,3,4,6,7,5,7,4,7,8,5,3,3};
        int[] nums2 = new int[]{3,4,2,4,3,4,3,5,5};

        new DeleteAndEarn().deleteAndEarn(nums2);
    }
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0) return 0;
        int[] numbers = new int[10001];

        for (int x: nums) numbers[x]++;
        ArrayList<Integer> uniqueNumbers = new ArrayList<>();
        for (int i = 0; i < 10000 ; i++) {
            if(numbers[i] != 0){
                uniqueNumbers.add(i);
            }
        }
        int[] storedValues = new int[uniqueNumbers.size()];

        if(uniqueNumbers.size()==1) return uniqueNumbers.get(0) * numbers[uniqueNumbers.get(0)];

        if(uniqueNumbers.size()==2){
            if(uniqueNumbers.get(1)-uniqueNumbers.get(0) == 1){
                return Math.max(uniqueNumbers.get(0) * numbers[uniqueNumbers.get(0)], uniqueNumbers.get(1) * numbers[uniqueNumbers.get(1)]);
            }
            return ((uniqueNumbers.get(0) * numbers[uniqueNumbers.get(0)])) + ((uniqueNumbers.get(1) * numbers[uniqueNumbers.get(1)]));
        }

        for (int i = 1; i < uniqueNumbers.size() ; i++) {
            int nearestLeft = i-1;
            int uniqueNumber = uniqueNumbers.get(i);

            while (nearestLeft >= 0 && uniqueNumber - uniqueNumbers.get(nearestLeft) == 1) nearestLeft--;
            int left1;
            if(nearestLeft < 0){
                left1 = 0;
            }else{
                left1 = storedValues[nearestLeft] != 0 ? storedValues[nearestLeft] : uniqueNumbers.get(nearestLeft) * numbers[uniqueNumbers.get(nearestLeft)];
            }
            int left2;
            if(nearestLeft-1 < 0){
                left2 = Integer.MIN_VALUE;
            }else{
                left2 = storedValues[nearestLeft-1] != 0 ? storedValues[nearestLeft-1] : uniqueNumbers.get(nearestLeft-1) * numbers[uniqueNumbers.get(nearestLeft-1)];
            }
            storedValues[i] = Math.max(left1, left2) + (uniqueNumber * numbers[uniqueNumber]);
        }
        int final1 = storedValues[storedValues.length-1];
        int final2 = storedValues[storedValues.length-2];

        return Math.max(final1, final2);
    }
}
