class Solution {
    public String reverseWords(String s) {



//Follow-up: If the string data type is mutable in your language, can you solve it in-place 
//with O(1) extra space?
// Convert string to char array

     String result = new String();
    int i = 0;
    int n = s.length();

    while(i < n){
        while(i < n && s.charAt(i) == ' ') i++;
        if(i >= n) break;
        int j = i + 1;
        while(j < n && s.charAt(j) != ' ') j++;
        String sub = s.substring(i, j);
        if(result.length() == 0) result = sub;
        else result = sub + " " + result;
        i = j+1;
    }
    return result;
}
}

// Stack Solution :




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
