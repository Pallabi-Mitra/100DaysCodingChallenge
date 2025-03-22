class Solution {
    public boolean isPalindrome(String s) {


        s= s.replaceAll("[^a-zA-Z0-9]","");
        s= s.toLowerCase();
        char ch []= s.toCharArray();



        int n = ch.length;

        int start = 0;
        int end = n-1;

        while(start<end)
        {
            if(ch[start]!=ch[end])
            {
                return false;
            }
            else
            {
                start++;
                end--;
            }
        }
        
        return true;
    }
}