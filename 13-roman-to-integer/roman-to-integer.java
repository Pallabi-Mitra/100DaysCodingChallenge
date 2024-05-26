class Solution {
    public int romanToInt(String s) {

        // Step 1: Create a mapping of Roman numerals to integers
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        // Step 2: Initialize the result variable
        int result = 0;
        int length = s.length();
        int prevValue = 0;

        // Step 3: Iterate through the string from right to left
        for (int i = length - 1; i >= 0; i--) {
            // Get the value of the current character
            int currentValue = romanMap.get(s.charAt(i));

            // Check if the current value is less than the previous value
            if (currentValue < prevValue) {
                // Subtract the current value if it is less than the previous value
                result -= currentValue;
            } else {
                // Add the current value
                result += currentValue;
            }

            // Update the previous value
            prevValue = currentValue;
        }

        // Step 4: Return the final result
        return result;
    }
}
