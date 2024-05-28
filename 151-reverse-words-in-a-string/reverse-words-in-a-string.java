class Solution {
    public String reverseWords(String s) {



//Follow-up: If the string data type is mutable in your language, can you solve it in-place 
//with O(1) extra space?

// Use Stringbuilder :

// Step 1: Trim leading and trailing spaces
     s=s.trim();
        StringBuilder sb = new StringBuilder(s);
      
       
       
      
        int n = sb.length();

        int start = 0;
       

        for(int end=0;end<n;end++)
        {
            while(end < n && sb.charAt(end)==' ')
            {
                end++;
            }
            while(end < n && sb.charAt(end)!=' ')
            {
                end++;
            }

           reverse(sb,start,end-1);

           while(end<n && sb.charAt(end+1)==' ')

           {
             
             end++;
           }

           //StringBuilder replace(int start, int end, String str): 
            start=end+1;
           // end= start;

            
        }
        sb= sb.reverse();
        String result =sb.toString();
        result = result.replaceAll("[ ]+"," ");
        
        return result;

    }

        private void reverse(StringBuilder sb,int left,int right)
        {
            
            while(left<right)
            {
                char temp = sb.charAt(left);
                sb.setCharAt(left,sb.charAt(right));
                sb.setCharAt(right, temp);
                left++;
                right--;
            }
            //return right;
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
