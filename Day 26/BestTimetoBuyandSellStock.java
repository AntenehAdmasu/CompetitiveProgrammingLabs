// Question : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0, counter = 0, sell = 0, buy = 0;
        boolean sold = false;

        while (counter < prices.length - 1) {
            while (counter < prices.length - 1 && prices[counter] > prices[counter + 1]) {
                counter++;
            }
            buy = prices[counter];

            while (counter < prices.length - 1 && prices[counter] < prices[counter + 1]) {
                counter++;
            }
            sell = prices[counter];
            if (sell == prices[counter]) sold = true;
            if (sold) profit += (sell - buy);
            sold = false;
            counter++;

        }
        return profit;

    }

}
