class Solution {
    public int maxScore(int[] cardPoints, int k) {

   // Bruteforce :

  int n = cardPoints.length;
    int leftSum = 0, rightSum = 0;

    // Compute the initial sum of the first k cards from the start
    for (int i = 0; i < k; i++) {
        leftSum += cardPoints[i];
    }

    // Initialize the maximum score to the sum of the first k cards
    int maxScore = leftSum;

    // Compute sums by taking cards from the end
    for (int i = 0; i < k; i++) {
        leftSum -= cardPoints[k - 1 - i]; // Remove the leftmost card from leftSum
        rightSum += cardPoints[n - 1 - i]; // Add a card from the right
        maxScore = Math.max(maxScore, leftSum + rightSum); // Update maxScore
    }

    return maxScore;
   
   
    
        
    }
}