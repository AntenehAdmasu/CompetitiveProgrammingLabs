public class CountPrimes {
    public int countPrimes(int n) {
        int[] num = new int[n];
        int count = 0;
        for(int i = 2; i < n; i++){
            if(num[i] == 0){
                num[i] = 1;
                count++;
                for(int j = i; j < n; j += i){
                    num[j] = 1;
                }
            }
        }
        return count;
    }
}
