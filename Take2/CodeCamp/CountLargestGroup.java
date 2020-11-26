import java.util.HashMap;

public class CountLargestGroup {

    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> sumSizeMap = new HashMap<>();
        int maxSize = 0;
        int maxSizeCount = 0;
        for(int i = 1; i <= n; i++){
            int sum = getSum(i);

            sumSizeMap.put(sum, sumSizeMap.containsKey(sum) ? sumSizeMap.get(sum) + 1: 1);
            int freq = sumSizeMap.get(sum);
            if(freq == maxSize){
                maxSizeCount++;
            }else if(freq > maxSize){
                maxSize = freq;
                maxSizeCount = 1;
            }
        }
        return maxSizeCount;
    }

    public int getSum(int num){
        int sum = 0;
        while(num > 9){
            sum += num % 10;
            num /= 10;
        }
        sum += num;
        return sum;
    }
}
