//  Question : https://leetcode.com/problems/play-with-chips/

public class PlayWithChips {

    public static void main(String[] args) {
        int[] test = new int[]{1,1,2,2,4,3,6};
        System.out.println(new PlayWithChips().minCostToMoveChips(test));
    }
    public int minCostToMoveChips(int[] chips) {
        int oddCount = 0;
        int evenCount = 0;
        
        for (int x: chips ) {
            if(x % 2 == 0){
                evenCount++;
                continue;
            }
            oddCount++;
        }
        return Math.min(oddCount, evenCount);
    }

}
