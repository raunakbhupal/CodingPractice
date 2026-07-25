public int maxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE;   // cheapest buy price seen so far
    int maxProfit = 0;

    for (int price : prices) {
        if (price < minPrice) {
            minPrice = price;                       // found a cheaper buy day
        } else {
            maxProfit = Math.max(maxProfit, price - minPrice);  // sell today?
        }
    }
    return maxProfit;
}
