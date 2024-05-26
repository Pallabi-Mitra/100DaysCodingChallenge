class Solution {
    public boolean rotateString(String s, String goal) {


       if (s.length() != goal.length()) // If lengths are different, return false
        return false;
    
    String concatenated = s + s;
    return concatenated.contains(goal);
            


        
    }
}