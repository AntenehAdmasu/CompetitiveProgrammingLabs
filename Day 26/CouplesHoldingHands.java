// Question link : https://leetcode.com/problems/couples-holding-hands/

public class CouplesHoldingHands {


    public int minSwapsCouples(int[] row) {
        int index = 0;
        int swapCounter = 0;

        while(index < row.length-1){
            int couple = row[index] % 2 == 0 ? row[index] + 1 : row[index] - 1;

            if(row[index+1] == couple){
                index += 2;
            }else{
                int couplesLocation = index+1;
                while(row[couplesLocation] != couple){
                    couplesLocation ++;
                }

                int tempVal = row[index+1];
                row[index+1] = row[couplesLocation];
                row[couplesLocation] = tempVal;
                swapCounter++;
            }


        }
        return swapCounter;
    }
}
