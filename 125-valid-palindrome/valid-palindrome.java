class Solution {
    public boolean isPalindrome(String s) {





if (s.isEmpty()) {
        	return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while(start <= last) {
        	char currFirst = s.charAt(start);
        	char currLast = s.charAt(last);
        	if (!Character.isLetterOrDigit(currFirst )) {
        		start++;
        	} else if(!Character.isLetterOrDigit(currLast)) {
        		last--;
        	} else {
        		if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
        			return false;
        		}
        		start++;
        		last--;
        	}
        }
        return true;
    }
}

// Using String Builder //

/*
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
*/

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