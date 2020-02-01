// Question link : https://leetcode.com/problems/maximum-of-absolute-value-expression/

public class MaximumAbsoluteValueExpression {

    public int maxAbsValExpr(int[] arr1, int[] arr2) {

        // Case1 formula
        int case1FirstSum = 0 - arr1[0] - arr2[0];
        int case1SecondSum = 0 + arr1[0] + arr2[0];

        // Case2 formula
        int case2FirstSum = 0 - arr1[0] + arr2[0];
        int case2SecondSum = 0 + arr1[0] - arr2[0];

        // Case3 formula
        int case3FirstSum = 0 + arr1[0] - arr2[0];
        int case3SecondSum = 0 - arr1[0] + arr2[0];

        // Case4 formula
        int case4FirstSum = 0 + arr1[0] + arr2[0];
        int case4SecondSum = 0 - arr1[0] - arr2[0];


        for (int i = 0; i < arr1.length; i++) {
            int c1Sum1 = i - arr1[i] - arr2[i];
            int c1Sum2 = 0 - i + arr1[i] + arr2[i];

            int c2Sum1 = i - arr1[i] + arr2[i];
            int c2Sum2 = 0 - i + arr1[i] - arr2[i];

            int c3Sum1 = i + arr1[i] - arr2[i];
            int c3Sum2 = 0 - i - arr1[i] + arr2[i];

            int c4Sum1 = i + arr1[i] + arr2[i];
            int c4Sum2 = 0 - i - arr1[i] - arr2[i];

            if (c1Sum1 > case1FirstSum) case1FirstSum = c1Sum1;
            if (c1Sum2 > case1SecondSum) case1SecondSum = c1Sum2;

            // Case 2
            if(c2Sum1 > case2FirstSum) case2FirstSum = c2Sum1;
            if(c2Sum2 > case2SecondSum) case2SecondSum = c2Sum2;

            // Case 3
            if(c3Sum1 > case3FirstSum) case3FirstSum = c3Sum1;
            if(c3Sum2 > case3SecondSum) case3SecondSum = c3Sum2;

            // Case 4
            if(c4Sum1 > case4FirstSum) case4FirstSum = c4Sum1;
            if(c4Sum2 > case4SecondSum) case4SecondSum = c4Sum2;
        }

        int case1Max = case1FirstSum + case1SecondSum;
        int case2Max = case2FirstSum + case2SecondSum;
        int case3Max = case3FirstSum + case3SecondSum;
        int case4Max = case4FirstSum + case4SecondSum;

        int overAllMax = Math.max(Math.max(case1Max, case2Max), Math.max(case3Max, case4Max));

        return overAllMax;
    }
}