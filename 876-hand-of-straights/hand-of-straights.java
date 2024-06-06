class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

    if (hand.length % groupSize != 0) return false;

    // Use a TreeMap to count the occurrences of each card
    TreeMap<Integer, Integer> count = new TreeMap<>();
    for (int card : hand) {
        count.put(card, count.getOrDefault(card, 0) + 1);
    }

    // Iterate through the sorted keys of the TreeMap
    while (!count.isEmpty()) {
        int firstCard = count.firstKey();
        for (int i = 0; i < groupSize; i++) {
            int card = firstCard + i;
            // Check if the group can be formed
            if (count.getOrDefault(card, 0) == 0) return false;
            if (count.get(card) == 1) {
                count.remove(card);
            } else {
                count.put(card, count.get(card) - 1);
            }
        }
    }
    return true;
        
        
    }
}