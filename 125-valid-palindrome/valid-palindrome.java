class Solution {
    public boolean isPalindrome(String s) {



StringBuilder sb = new StringBuilder();

    for(char ch : s.toCharArray()){
        if(Character.isLetterOrDigit(ch)){
            sb.append(Character.toLowerCase(ch));
        }
    }
    if(sb.toString().equals(sb.reverse().toString())){
    return true;
    }
    return false;
    }
}


// 2-pointer approach :
/*
    String ans = "";

    for(char c : s.toCharArray())
    {
        if(Character.isDigit(c) || Character.isLetter(c))
        {
            ans += c;
        }

    }
    ans=ans.toLowerCase();

    int begin = 0;
    int end = ans.length()-1;

    while(begin<=end)
    {
        if(ans.charAt(begin)!=ans.charAt(end))
            return false;
        begin++;
        end--;
    }

    return true;
     
    }
}

*/