class Solution {
    public int candy(int[] ratings) {

           int n = ratings.length;
    
    // Step 1: Initialize an array to store candies, each child gets at least 1 candy
    int[] candies = new int[n];
    Arrays.fill(candies, 1);
    
    // Step 2: Traverse from left to right, ensure right rule
    for (int i = 1; i < n; i++) {
        if (ratings[i] > ratings[i - 1]) {
            candies[i] = candies[i - 1] + 1;
        }
    }
    
    // Step 3: Traverse from right to left, ensure left rule
    for (int i = n - 2; i >= 0; i--) {
        if (ratings[i] > ratings[i + 1]) {
            candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        }
    }
    
    // Step 4: Sum up the candies and return
    int totalCandies = 0;
    for (int candy : candies) {
        totalCandies += candy;
    }
    
    return totalCandies;
        
    }
}