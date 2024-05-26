class Solution {
    public boolean rotateString(String s, String goal) {

/*
//An optimized approach would be to concatenate the original string with itself and then check //if the goal string is a substring of this concatenated string.

       if (s.length() != goal.length()) // If lengths are different, return false
        return false;
    
    String concatenated = s + s;
    return concatenated.contains(goal);
            

*/

// Brute Force :

        int len1= s.length();

        int len2 = goal.length();

        if(len1!=len2)  return false;


        for(int i =0;i<len1;i++)
        {
            s= s.charAt(len1-1)+s.substring(0,len1-1);
            //s=shiftRight(s)
            if(s.equals(goal))
            {
                    return true;
            }
            

            
        }
        return false;
        
    }

   // public String shiftRight(String s){
       // return s.CharAt(len1-1)+s.substring(0,len1-1);}


}