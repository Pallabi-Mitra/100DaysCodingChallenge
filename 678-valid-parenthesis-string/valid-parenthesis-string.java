// Using Two Pass Greedy Algorithm:


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