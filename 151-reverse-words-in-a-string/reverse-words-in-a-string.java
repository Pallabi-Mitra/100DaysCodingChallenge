class Solution {
    public String reverseWords(String s) {



//Follow-up: If the string data type is mutable in your language, can you solve it in-place 
//with O(1) extra space?

// Use Stringbuilder :

// Step 1: Trim leading and trailing spaces
    s = s.trim();
    
    // Step 2: Reverse the entire string using StringBuilder
    StringBuilder sb = new StringBuilder(s).reverse();
    
    // Step 3: Reverse each word in the reversed string
    int start = 0;
    for (int i = 0; i < sb.length(); i++) {
        if (sb.charAt(i) == ' ') {
            reverse(sb, start, i - 1);
            start = i + 1;
        }
    }
    // Reverse the last word
    reverse(sb, start, sb.length() - 1);
    
    // Step 4: Clean up multiple spaces
    int i = 0;
    while (i < sb.length()) {
        if (sb.charAt(i) == ' ') {
            int j = i + 1;
            while (j < sb.length() && sb.charAt(j) == ' ') {
                j++;
            }
            if (j > i + 1) {
                sb.delete(i + 1, j);
            }
        }
        i++;
    }
    
    return sb.toString();
}

private void reverse(StringBuilder sb, int left, int right) {
    while (left < right) {
        char temp = sb.charAt(left);
        sb.setCharAt(left, sb.charAt(right));
        sb.setCharAt(right, temp);
        left++;
        right--;
    }
}
}

// Stack Solution :
/*
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
    //ans.append(stack.pop()).append(" ");

}
ans.append(st.pop());
return ans.toString();
    
    }
}

*/

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
