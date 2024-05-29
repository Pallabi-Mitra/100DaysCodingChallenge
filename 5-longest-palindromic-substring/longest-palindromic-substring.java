class Solution {
    public String longestPalindrome(String s) {

         int n = s.length();
    if (n < 2) {
        return s;
    }
    
    int maxLength = 1;
    int start = 0;

    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            if (isPalindrome(s, i, j) && (j - i + 1) > maxLength) {
                start = i;
                maxLength = j - i + 1;
            }
        }
    }
    
    return s.substring(start, start + maxLength);
}

private boolean isPalindrome(String s, int low, int high) {
    while (low < high) {
        if (s.charAt(low) != s.charAt(high)) {
            return false;
        }
        low++;
        high--;
    }
    return true;
        
    }
}