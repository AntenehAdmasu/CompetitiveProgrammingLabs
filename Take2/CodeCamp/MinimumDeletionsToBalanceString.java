import java.util.Arrays;

public class MinimumDeletionsToBalanceString {

    public int minimumDeletions(String s) {
        int aCount = 0;
        int bCount = 0;
        int[] aOcc = new int[s.length()];
        int[] bOcc = new int[s.length()];
        int index = 0;

        for(char c: s.toCharArray()){
            if(c == 'a'){
                aCount++;
                aOcc[index] = index == 0 ? 1 : aOcc[index-1] + 1;
                bOcc[index] = index == 0 ? 0 : bOcc[index-1];
            }else{
                bCount++;
                bOcc[index] = index == 0 ? 1 : bOcc[index-1] + 1;
                aOcc[index] = index == 0 ? 0 : aOcc[index-1];

            }
            index++;
        }
        int minOperations = s.length() + 1;
        if(aCount == 0 || bCount == 0){
            return 0;
        }
        int minCount = Math.min(aCount, bCount);
        for(int i = 0; i < s.length(); i++){
            int aDeletion = aCount - aOcc[i];
            int bDeletion = bOcc[i];
            minOperations = Math.min(minOperations, aDeletion + bDeletion);
        }
        return Math.min(minOperations, minCount);
    }
}
