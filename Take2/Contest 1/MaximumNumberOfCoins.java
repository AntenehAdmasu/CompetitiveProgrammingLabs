import java.util.Arrays;

public class MaximumNumberOfCoins {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int index = piles.length - 2;
        int total = 0;

        for(int i = index; i >= piles.length / 3; i -= 2){
            total += piles[i];
        }
        return total;
    }
}
