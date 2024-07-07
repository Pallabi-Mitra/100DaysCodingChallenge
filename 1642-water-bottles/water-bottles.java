class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
int totalDrank = numBottles;  // Initialize total bottles drank with the initial full bottles

        while (numBottles >= numExchange) {  // Continue until we can exchange empty bottles for full ones
            int newBottles = numBottles / numExchange;  // Number of new full bottles we can get
            numBottles = newBottles + (numBottles % numExchange);  // Update numBottles: new full bottles + remaining empty bottles
            totalDrank += newBottles;  // Add new full bottles to the total count
        }

        return totalDrank;  // Return the total number of bottles drank
    }
}

 