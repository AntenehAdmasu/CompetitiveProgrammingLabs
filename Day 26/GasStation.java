// Question link : https://leetcode.com/problems/gas-station/

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] netGas = new int[gas.length];

        for (int i = 0; i < gas.length; i++) {
            netGas[i] = gas[i] - cost[i];
        }
        int start = 0;

        while(start < netGas.length && netGas[start] < 0) start++;

        while(start < netGas.length){

            int gasSum = netGas[start];
            int failIndex = start;

            for (int i = start + 1; i <= start + netGas.length ; i++) {
                if(i >= netGas.length){
                    i %= netGas.length;
                }
                gasSum += netGas[i];

                if(gasSum < 0){
                    failIndex = i;
                    break;
                }
                if(i == start){
                    return start;
                }
            }

            // Find the next index where the new iteration can start cvbgfnh
            if(failIndex < start) return -1;
            while(failIndex < netGas.length-1 && netGas[failIndex] < 0){
                failIndex++;
            }
            start = failIndex;
        }

        return -1;
    }

}
