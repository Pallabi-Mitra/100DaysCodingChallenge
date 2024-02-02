class Solution {
    public int strStr(String haystack, String needle) {

        int result;
        if(haystack.contains(needle))
        {
                result = haystack.indexOf(needle);
        }
        else
            result = -1;

        return result;
        
    }
}