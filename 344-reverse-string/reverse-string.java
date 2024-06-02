class Solution {
    public void reverseString(char[] s) {

// Reverse a String :

        int left = 0;
        int right = s.length-1;
       while( left< right)
        {
            char temp = s[right];
            s[right]=s[left];
            s[left]=temp;
            left++;
            right--;
        }


        
    }
}