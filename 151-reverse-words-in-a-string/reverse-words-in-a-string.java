class Solution {
    public String reverseWords(String s) {


//Bruteforce :

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
