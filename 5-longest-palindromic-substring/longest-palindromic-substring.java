class Solution {
    public String longestPalindrome(String s) {
 if (s == null || s.length() < 1) {
            return "";
        }

        // Expansion Around Center
        int maxLength = 0; // To track the length of the longest palindrome found
        String res = ""; // To store the longest palindromic substring

        int n = s.length();
        char[] ch = s.toCharArray(); // Convert input string to a character array for easier access

        int left, right;

        for (int i = 0; i < n; i++) {
            // Odd length palindromes
            left = i;
            right = i;

            while (left >= 0 && right < n && ch[left] == ch[right]) {
                if ((right - left + 1) > maxLength) {
                    res = s.substring(left, right + 1); // Update the result with the new longest palindrome
                    maxLength = right - left + 1;
                }
                left--; // Move left pointer outward
                right++; // Move right pointer outward
            }

            // Even length palindromes
            left = i;
            right = i + 1;

            while (left >= 0 && right < n && ch[left] == ch[right]) {
                if ((right - left + 1) > maxLength) {
                    res = s.substring(left, right + 1); // Update the result with the new longest palindrome
                    maxLength = right - left + 1;
                }
                left--; // Move left pointer outward
                right++; // Move right pointer outward
            }
        }
        return res; // Return the longest palindromic substring found
    
    }
}


// Bruteforce : O(n3):
/*

    int n = s.length();
    if (n < 2) {
        return s;
    }
    
    int maxLength = 1;
    int start = 0;

    for (int i = 0; i < n; i++) {
        for (int j = i+1; j < n; j++) {
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
*/
