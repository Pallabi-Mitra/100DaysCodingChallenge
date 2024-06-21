class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
         int n = customers.length;
        
        // Calculate initially satisfied customers without using the technique
        int initiallySatisfied = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                initiallySatisfied += customers[i];
            }
        }
        
        // Calculate maximum additional satisfied customers using the technique
        int maxAdditionalSatisfied = 0;
        int currentAdditionalSatisfied = 0;
        
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                currentAdditionalSatisfied += customers[i];
            }
        }
        
        maxAdditionalSatisfied = currentAdditionalSatisfied;
        
        for (int i = minutes; i < n; i++) {
            if (grumpy[i] == 1) {
                currentAdditionalSatisfied += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                currentAdditionalSatisfied -= customers[i - minutes];
            }
            maxAdditionalSatisfied = Math.max(maxAdditionalSatisfied, currentAdditionalSatisfied);
        }
        
        return initiallySatisfied + maxAdditionalSatisfied;
    }

    }
