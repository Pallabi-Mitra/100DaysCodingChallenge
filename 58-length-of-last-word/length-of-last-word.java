class Solution {
    public int lengthOfLastWord(String s) {

       char [] ch = s.toCharArray();

        int i = ch.length-1;
        int count = 0;
        while(i>=0){
            if(!Character.isLetter(ch[i]))
            {
                i--;
            }
            else
            {
               break;
            }
         
        }
       
        
        while(i>=0)
        {
            if(Character.isLetter(ch[i]))
            {
                count++;
                i--;
            }
            else
            break;
        }

        return count;
        
    }
}