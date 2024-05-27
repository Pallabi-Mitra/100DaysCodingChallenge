class Solution {
    public String reverseWords(String s) {



//Follow-up: If the string data type is mutable in your language, can you solve it in-place 
//with O(1) extra space?

   // Convert the string to a char array
    char[] chars = s.toCharArray();
    int n = chars.length;
    
    // Reverse the entire char array
    reverse(chars, 0, n - 1);
    
    // Reverse each word in the reversed char array
    int start = 0;
    for (int end = 0; end < n; end++) {
        if (chars[end] == ' ') {
            reverse(chars, start, end - 1);
            start = end + 1;
        }
    }
    // Reverse the last word
    reverse(chars, start, n - 1);
    
    // Clean up spaces: remove leading, trailing, and extra spaces
    return cleanSpaces(chars, n);
}

private void reverse(char[] chars, int left, int right) {
    while (left < right) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
        left++;
        right--;
    }
}

private String cleanSpaces(char[] chars, int n) {
    int i = 0, j = 0;
    
    while (j < n) {
        // Skip leading spaces
        while (j < n && chars[j] == ' ') j++;
        // Copy non-space characters
        while (j < n && chars[j] != ' ') chars[i++] = chars[j++];
        // Skip spaces between words, but keep one space
        while (j < n && chars[j] == ' ') j++;
        if (j < n) chars[i++] = ' ';
    }
    
    return new String(chars, 0, i);
}
}
//Bruteforce :
/*

         // Trim leading and trailing spaces
    s = s.trim();
        // Split the string by one or more spaces
         String[] words = s.split("\\s+");
       
         

        for(int i = 0; i< words.length/2;i++)
        {
            String temp = words[i];
            words[i]=words[words.length-1-i];
            words[words.length-1-i] = temp;
        }
        
        // Join the reversed words with a single space
          return String.join(" ", words);

        
        
    }
}
*/


//Bruteforce :

/*
// Trim leading and trailing spaces
        s=s.trim();
    // replace all spaces single,double,triple with single space

        String ss = s.replaceAll("[ ]+"," ");
        // split strings in spaces
        String arr[]=ss.split(" ");
        StringBuilder sb =new StringBuilder();
        int i;

        for(i = arr.length-1;i>0;i--)
        {
            sb.append(arr[i]+" ");
        }
        sb.append(arr[0]); // append the first word spearetely to avoid trailing spaces
        

        return sb.toString();
        
    }
}
*/
