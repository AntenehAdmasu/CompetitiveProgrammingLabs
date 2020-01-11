// Question : https://leetcode.com/problems/perfect-number/submissions/

public class PerfecrNumber {

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
    }
    public static boolean checkPerfectNumber(int num) {
        if(num == 0) return false;
        int sqrRoot = (int) Math.sqrt(num);
        int sum = 0;

        for (int i = 1; i <= sqrRoot; i++) {
            if(sum > num) return false;
            if(num % i == 0){
                sum += (i != num)? i : 0;
                sum +=( num/i != num)? num / i : 0;

            }
        }

        if(sum == num) return true;
        return false;
    }
}

