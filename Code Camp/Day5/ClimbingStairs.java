// Question link : https://leetcode.com/problems/climbing-stairs/

public class ClimbingStairs {

    public int getSteps(int n){
        int[] calculated = new int[n+1];
        int x = getStepsRec(n,calculated);
        return x;
    }

    private int getStepsRec(int n, int[] calculated) {
        if(n < 3) return n;
        if(calculated[n] == 0) calculated[n] = getStepsRec(n-1, calculated) + getStepsRec(n-2, calculated);
        return calculated[n];
    }

    public int bottomUp(int n){
        if(n < 3) return n;
        int prev = 1;
        int recent = 2;
        int current = 0;
        for(int i = 2; i < n; i++){
            current = prev + recent;
            prev = recent;
            recent = current;
        }
        return current;
    }
}
