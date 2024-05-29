class Solution {
    public String intToRoman(int num) {


        // Define Roman numeral symbols and their values
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    // StringBuilder to store the result
    StringBuilder roman = new StringBuilder();

    // Iterate over the symbols
    for (int i = 0; i < values.length; i++) {
        // Append the symbol while the value is less than or equal to num
        while (num >= values[i]) {
            roman.append(symbols[i]);
            num -= values[i];
        }
    }
    return roman.toString();
        
    }
}