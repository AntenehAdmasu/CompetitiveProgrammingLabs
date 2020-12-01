public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if(num == 0) return false;

        int sqrRoot = (int) Math.sqrt(num);
        int sum = 0;

        for (int i = 1; i <= sqrRoot; i++) {
            if(sum > num) return false;
            if(num % i == 0){
                sum += (i != num)? i : 0;
                sum +=(num/i != num)? num / i : 0;
            }
        }
        return sum == num;
    }
}
