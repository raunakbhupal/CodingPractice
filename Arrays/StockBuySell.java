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


//Code for finding profit with atmost 2 transactions
/*
1) Create a table profit[0..n-1] and initialize all values in it 0.
2) Traverse price[] from right to left and update profit[i] such that profit[i] stores maximum profit achievable from one transaction in subarray price[i..n-1]
3) Traverse price[] from left to right and update profit[i] such that profit[i] stores maximum profit such that profit[i] contains maximum achievable profit from
two transactions in subarray price[0..i].
4) Return profit[n-1]

To do step 2, we need to keep track of the maximum price from right to left side, and to do step 3, we need to keep track of the minimum price from left to right. 
Why we traverse in reverse directions? The idea is to save space, in the third step, we use the same array for both purposes, maximum with 1 transaction and 
maximum with 2 transactions. After iteration i, the array profit[0..i] contains the maximum profit with 2 transactions, and profit[i+1..n-1] contains 
profit with two transactions.
*/

class Profit {
	// Returns maximum profit
	// with two transactions on a
	// given list of stock prices,
	// price[0..n-1]
	static int maxProfit(int price[], int n)
	{
		// Create profit array
		// and initialize it as 0
		int profit[] = new int[n];
		for (int i = 0; i < n; i++)
			profit[i] = 0;

		/* Get the maximum profit
		with only one transaction
		allowed. After this loop,
		profit[i] contains
		maximum profit from
		price[i..n-1] using at most
		one trans. */
		int max_price = price[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			// max_price has maximum
			// of price[i..n-1]
			if (price[i] > max_price)
				max_price = price[i];

			// we can get profit[i]
			// by taking maximum of:
			// a) previous maximum,
			// i.e., profit[i+1]
			// b) profit by buying
			// at price[i] and selling
			// at
			// max_price
			profit[i] = Math.max(profit[i + 1],
								max_price - price[i]);
		}

		/* Get the maximum profit
		with two transactions allowed
		After this loop, profit[n-1]
		contains the result
		*/
		int min_price = price[0];
		for (int i = 1; i < n; i++) {
			// min_price is minimum
			// price in price[0..i]
			if (price[i] < min_price)
				min_price = price[i];

			// Maximum profit is maximum of:
			// a) previous maximum, i.e., profit[i-1]
			// b) (Buy, Sell) at (min_price, price[i]) and
			// add
			// profit of other trans.
			// stored in profit[i]
			profit[i] = Math.max(
				profit[i - 1],
				profit[i] + (price[i] - min_price));
		}
		int result = profit[n - 1];
		return result;
	}

	// Driver Code
	public static void main(String args[])
	{
		int price[] = { 2, 30, 15, 10, 8, 25, 80 };
		int n = price.length;
		System.out.println("Maximum Profit = "
						+ maxProfit(price, n));
	}

}

/*
Example:
Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.


Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.*/
