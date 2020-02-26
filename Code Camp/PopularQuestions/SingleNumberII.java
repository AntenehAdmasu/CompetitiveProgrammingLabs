// Question link : https://leetcode.com/problems/single-number-ii/

public class SingleNumberII {


    public int singleNumber(int[] nums) {

        int uniqueNumber = 0;

        for(int i = 0; i < 32; i++){
            int bitsTurnedOn = 0;

            for(int num: nums){

                // Counting the number of ones
                if(((num>>i) % 2) != 0){
                    bitsTurnedOn++;
                }
            }

            int bitsFromUniqueNumber = bitsTurnedOn % 3;

            if(bitsFromUniqueNumber !=0){
                uniqueNumber |= (1<<i);   // turning the bit on
            }

        }

        return uniqueNumber;

    }


}
