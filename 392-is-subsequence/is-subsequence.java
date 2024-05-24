class Solution {
    public boolean isSubsequence(String sub, String s1) {

        int j = 0;

        for(int i = 0;i<s1.length() && j<sub.length();i++)
        {
            if(s1.charAt(i)==sub.charAt(j))
            {
               
                j++;
            }

        }
        if(j==sub.length())
        return true;
        else
        return false;

        
    }
}