class Solution {
    public int maxIceCream(int[] costs, int coins) {
        // Find the maximum cost to determine counting array size
        int maxCost = 0;
        for (int cost : costs) {
            if (cost > maxCost) {
                maxCost = cost;
            }
        }
        
        // Counting sort: count frequencies of each cost
        int[] count = new int[maxCost + 1];
        for (int cost : costs) {
            count[cost]++;
        }
        
        int bars = 0;
        // Iterate through costs in ascending order
        for (int price = 1; price <= maxCost; price++) {
            if (count[price] == 0) continue;
            
            // Buy as many as possible at this price
            int canBuy = Math.min(count[price], coins / price);
            bars += canBuy;
            coins -= canBuy * price;
            
            // If we run out of coins, break early
            if (coins == 0) {
                break;
            }
        }
        
        return bars;
    }
}