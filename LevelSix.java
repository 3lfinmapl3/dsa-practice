public class LevelSix {
    /**
     * This new level will be dealing with Arrays and all about em.
     */


    /**
     * 
     * The problem :
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     * 
     * Example 1: prices = [7, 1, 5, 3, 6, 4] ➡️ Returns 5 (Buy on day 2 at price 1, sell on day 5 at price 6. 6 - 1 = 5).  

     * Example 2: prices = [7, 6, 4, 3, 1] ➡️ Returns 0 (In this case, no transactions are done and the max profit = 0).
     * [2,4,9,1,2,3]
    
    *  
    */
    private static int maxProfit(int [] prices){
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i=0; i < prices.length; i++){
            if (prices[i] < minPrice){
                minPrice = prices[i];
            }
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
    
    
    public static void main(String[] args)  {
        
        int [] prices =  {7, 2, 11, 33, 1};
        System.out.println(maxProfit(prices));
    }

}
