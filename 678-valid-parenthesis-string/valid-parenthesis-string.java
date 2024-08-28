// min- max balance


class Solution{
public boolean checkValidString(String s) {
    int minBalance = 0, maxBalance = 0;
    for (char c : s.toCharArray()) {
        if (c == '(') {
            minBalance++;
            maxBalance++;
        } else if (c == ')') {
            minBalance = Math.max(minBalance - 1, 0);
            maxBalance--;
        } else { // '*'
            minBalance = Math.max(minBalance - 1, 0);
            maxBalance++;
        }
        if (maxBalance < 0) return false;
    }
    return minBalance == 0;
}
}


// Using Two Pass Greedy Algorithm:
/*

class Solution{
public boolean checkValidString(String s) {
    int leftBalance = 0;
    for (char c : s.toCharArray()) {
        if (c == '(' || c == '*') leftBalance++;
        else leftBalance--;
        if (leftBalance < 0) return false;
    }

    int rightBalance = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
        char c = s.charAt(i);
        if (c == ')' || c == '*') rightBalance++;
        else rightBalance--;
        if (rightBalance < 0) return false;
    }

    return true;
}
}
*/

/*
Explanation
Left to Right Pass: Ensures that the string can be valid considering each '*' as '('.
Right to Left Pass: Ensures that the string can be valid considering each '*' as ')'.

*/



// Using Recursion :
/*

class Solution {
    public boolean checkValidString(String s) {

        return backtrack(s.toCharArray(),0,0);
        
    }

    private boolean backtrack(char s[],int index, int balance)
    {
        if(balance < 0) return false; // Unmatched ')' is found

        if(index == s.length) return balance ==0; // Balanced at the end of the string

        char c = s[index];

        if(c=='('){
            return backtrack(s,index+1,balance+1);
        }else if(c==')'){
            return backtrack(s,index+1,balance-1);
        }else{
                return backtrack(s,index+1,balance+1) ||// Treat '*' as '('
                backtrack(s,index+1,balance-1) ||// Treat '*' as ')'
                backtrack(s, index+1, balance);  // Treat '*' as empty
        }


    
    }
}

*/