// Question : https://leetcode.com/problems/integer-break/

public class IntegerBreak {
    public int integerBreak(int n) {
        if(n==2 || n==3) return n - 1;
        if(n % 3 == 2) return (int)Math.pow(3, n/3) * 2;
        return (int)Math.pow(3, ((n/3) - 1)) * ((n % 3) + 3);
    }
}
