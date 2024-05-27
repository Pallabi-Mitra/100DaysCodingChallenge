class Solution {
    public String reverseWords(String s) {



//Follow-up: If the string data type is mutable in your language, can you solve it in-place 
//with O(1) extra space?

// Use Stringbuilder :

// Convert string to char array
/*
    if (s == null || s.length() == 0) {
        return s;
    }
    s=s.trim();

    // Step 1: Reverse the entire string
    s = reverse(s, 0, s.length() - 1);

    // Step 2: Reverse each word
    int start = 0;
    int end = 0;
    while (start < s.length()) {
        // Skip leading spaces
        while (start < s.length() && s.charAt(start) == ' ') {
            start++;
        }
        end = start;
        // Find the end of the word
        while (end < s.length() && s.charAt(end) != ' ') {
            end++;
        }
        // Reverse the word
        s = reverse(s, start, end - 1);
        start = end;
    }

    return s;
}

private String reverse(String s, int left, int right) {
    StringBuilder sb = new StringBuilder(s);
    while (left < right) {
        char temp = sb.charAt(left);
        sb.setCharAt(left, sb.charAt(right));
        sb.setCharAt(right, temp);
        left++;
        right--;
    }
    return sb.toString();
}
}
*/
// Stack Solution :

String wordSplit[]=s.trim().split("\\s+");

Stack<String> st = new Stack<>();

for(String word : wordSplit)
{
    st.push(word);
}
StringBuilder ans = new StringBuilder();

for(int i = 0;i<wordSplit.length-1;i++)
{
    String res = st.peek();
    ans.append(res).append(" ");
    st.pop();

}
ans.append(st.pop());
return ans.toString();
    
    }
}



// 2 pointer:

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
