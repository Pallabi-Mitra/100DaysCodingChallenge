class Solution {
    public boolean isNStraightHand(int[] nums, int k) {

// HAshMap :

    // Edge case: if the array length is not a multiple of k, return false
        if (nums.length % k != 0) {
            return false;
        }

        // Sort the array
        Arrays.sort(nums);

        // Frequency map to count occurrences of each number
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Try to form sets of k consecutive numbers
        for (int num : nums) {
            if (countMap.get(num) == 0) {
                continue; // This number has already been used in a previous set
            }

            // Attempt to create a sequence of k consecutive numbers starting from 'num'
            for (int i = 0; i < k; i++) {
                int current = num + i;
                if (countMap.getOrDefault(current, 0) == 0) {
                    return false; // If any number in the sequence is missing, return false
                }
                countMap.put(current, countMap.get(current) - 1);
            }
        }

        return true;
    }
}




// TreeMap :
/*

// since group size not possible to create
   if (hand.length % groupSize != 0) return false;

    // Use a TreeMap to count the occurrences of each card
    TreeMap<Integer, Integer> count = new TreeMap<>();
    for (int card : hand) {
        count.put(card, count.getOrDefault(card, 0) + 1);
    }

    // Iterate through the sorted keys of the TreeMap
    while (!count.isEmpty()) {
        int firstCard = count.firstKey(); // take the first key of the sorted map to check for consecutive
        for (int i = 0; i < groupSize; i++) {
            int card = firstCard + i; // take the next card for consecutive, within size k
            // Check if the group can be formed
            if (count.getOrDefault(card, 0) == 0) return false; // if no consecutive card present
            if (count.get(card) == 1) {
                count.remove(card); // if 1 crad is present remove it
            } else { // if multiple card present of same value reduce count by 1
                count.put(card, count.get(card) - 1);
            }
            // keep doing this untill groupSize, take each card
        }
    }
    return true;
        
    }
}

*/