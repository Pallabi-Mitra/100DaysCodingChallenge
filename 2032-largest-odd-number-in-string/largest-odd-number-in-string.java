class Solution {
    public String largestOddNumber(String num) {


/*
        StringBuilder res = new StringBuilder("");
        char ch[]= num.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            int n1 = ch[i]-'0';
            int n2=ch[i]-'0';

            if(n1%2!=0)
            {
                res.append(c);
               
            }
            else if(res.length()>1)
            {
                

                res="";
            }
        }
        if(res.equals(""))
            return "";
        res.reverse();
        String result = res.toString();
        
        return result;
       */
       // Iterate through the string from the end to the beginning
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            
            // Check if the current character is an odd digit
            if (c == '1' || c == '3' || c == '5' || c == '7' || c == '9') {
                // Return the substring from the start to the current position (inclusive)
                return num.substring(0, i + 1);
            }
        }
        
        // If no odd digit is found, return an empty string
        return "";
     
    }
}