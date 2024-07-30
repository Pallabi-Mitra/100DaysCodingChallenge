class Solution {
    public int minimumDeletions(String s) {


            int countB = 0, minDeletions = 0;

    for (char c : s.toCharArray()) {
        if (c == 'b') {
            countB++;
        } else {
            minDeletions = Math.min(minDeletions + 1, countB);
        }
    }
    return minDeletions;
    }
}