class Solution {
    public int countSeniors(String[] details) {
         int count = 0;
    for (String detail : details) {
        // Extract age from the 12th and 13th characters
        //string to integer conversion
        int age = Integer.parseInt(detail.substring(11, 13));
        if (age > 60) {
            count++;
        }
    }
    return count;

        
    }
}