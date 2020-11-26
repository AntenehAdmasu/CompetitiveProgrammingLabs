import java.util.Arrays;

public class ReducingDishes {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int sum = 0;
        int prefixSum = 0;
        int firstPosIndex = -1;
        for (int i = 0; i < n; i++) {
            if (satisfaction[i] > 0) {
                firstPosIndex = firstPosIndex == -1 ? i : firstPosIndex;
                sum += satisfaction[i] * (i - firstPosIndex + 1);
                prefixSum += satisfaction[i];
            }
        }
        if (firstPosIndex == -1) {
            return 0;
        }
        int prevSum = sum;
        for (int index = firstPosIndex - 1; index >= 0; index--) {
            int newSum = satisfaction[index] + prefixSum;
            if (newSum < 0) {
                break;
            }
            prevSum += newSum;
            prefixSum += satisfaction[index];
        }
        return prevSum;
    }
}
