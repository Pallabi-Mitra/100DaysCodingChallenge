class Solution {
    public int appendCharacters(String s, String t) {


   int index_s = 0; // Pointer for String s
   int index_t = 0; // Pointer for String t

   while(index_s < s.length() && index_t < t.length()){
    if(s.charAt(index_s)==t.charAt(index_t))
    {
        index_t++;// Move pointer of t when characters match
    }
    index_s++;// Always move pointer of s
   }
// If t is already a subsequence of s all characters present
   if(index_t==t.length())
   {
    return 0;
   }
// Characters left in t that are not matched will be appended
    return t.length() - index_t;

        
    }
}