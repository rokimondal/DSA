public class BuyAndSellStocks {
    public static int maximumProfit(int prices[]) {
        int buyPrice = prices[0];
        int profit = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            if (buyPrice < prices[i]) {
                profit = Math.max(profit, prices[i] - buyPrice);
            } else {
                buyPrice = prices[i];
            }
        }
        if (profit > 0) {
            return profit;
        }
        return 0;
    }

    public static void main(String[] args) {
        int prices[] = { 7, 6, 5, 4, 3, 1 };
        System.out.println(maximumProfit(prices));
    }
}
