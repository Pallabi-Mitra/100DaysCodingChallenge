class Solution {
    public int scoreOfString(String s) {

        int n = s.length();
        int sum = 0;
        for(int i = 1;i<n;i++)
        {
            int ch1 = s.charAt(i);
            int ch2 = s.charAt(i-1);
            sum +=Math.abs(ch2-ch1);

        }
        return sum;
    }
}