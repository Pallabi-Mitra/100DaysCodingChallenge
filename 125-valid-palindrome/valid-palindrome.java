class Solution {
    public boolean isPalindrome(String s) {


    String ans = "";

    for(char c : s.toCharArray())
    {
        if(Character.isDigit(c) || Character.isLetter(c))
        {
            ans += c;
        }

    }
    ans=ans.toLowerCase();

    int begin = 0;
    int end = ans.length()-1;

    while(begin<=end)
    {
        if(ans.charAt(begin)!=ans.charAt(end))
            return false;
        begin++;
        end--;
    }

    return true;



        



        
    }
}