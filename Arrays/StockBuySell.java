// Program to find best buying and selling days 
import java.util.ArrayList; 

// Solution structure 
class Interval { 
	int buy, sell; 
} 

class StockBuySell { 
	// This function finds the buy sell schedule for maximum profit 
	void stockBuySell(int price[], int n) 
	{ 
		// Prices must be given for at least two days 
		if (n == 1) 
			return; 

		int count = 0; 

		// solution array 
		ArrayList<Interval> sol = new ArrayList<Interval>(); 

		// Traverse through given price array 
		int i = 0; 
		while (i < n - 1) { 
			// Find Local Minima. Note that the limit is (n-2) as we are 
			// comparing present element to the next element. 
			while ((i < n - 1) && (price[i + 1] <= price[i])) 
				i++; 

			// If we reached the end, break as no further solution possible 
			if (i == n - 1) 
				break; 

			Interval e = new Interval(); 
			e.buy = i++; 
			// Store the index of minima 

			// Find Local Maxima. Note that the limit is (n-1) as we are 
			// comparing to previous element 
			while ((i < n) && (price[i] >= price[i - 1])) 
				i++; 

			// Store the index of maxima 
			e.sell = i - 1; 
			sol.add(e); 

			// Increment number of buy/sell 
			count++; 
		} 

		// print solution 
		if (count == 0) 
			System.out.println("There is no day when buying the stock "
							+ "will make profit"); 
		else
			for (int j = 0; j < count; j++) 
				System.out.println("Buy on day: " + sol.get(j).buy 
								+ "	 "
								+ "Sell on day : " + sol.get(j).sell); 

		return; 
	} 

	public static void main(String args[]) 
	{ 
		StockBuySell stock = new StockBuySell(); 

		// stock prices on consecutive days 
		int price[] = { 100, 180, 260, 310, 40, 535, 695 }; 
		int n = price.length; 

		// fucntion call 
		stock.stockBuySell(price, n); 
	} 
} 





//Code for when you can buy and sell only once and need to find the max profit

public class Solution {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}

/*Example
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.*/
