class Solution {
    public double averageWaitingTime(int[][] customers) {


        long currentTime = 0; // Tracks the current time
    long totalWaitingTime = 0; // Tracks the total waiting time

    for (int[] customer : customers) {
        int arrivalTime = customer[0];
        int preparationTime = customer[1];

        // If the chef is idle, update currentTime to the arrivalTime of the customer
        if (currentTime < arrivalTime) {
            currentTime = arrivalTime;
        }

        // Calculate the waiting time for the current customer
        long waitingTime = currentTime + preparationTime - arrivalTime;

        // Add the waiting time to the total waiting time
        totalWaitingTime += waitingTime;

        // Update the current time to the time when the chef will be available next
        currentTime += preparationTime;
    }

    // Return the average waiting time
    return (double) totalWaitingTime / customers.length;
        
    }
}