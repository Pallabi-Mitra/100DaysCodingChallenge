class Solution {
    public int bitwiseComplement(int num) {
        // Convert the number to its binary string representation
    String binaryStr = Integer.toBinaryString(num);
    
    // Initialize a StringBuilder to store the flipped binary result
    StringBuilder flippedBinary = new StringBuilder();
    
    // Traverse through each character and flip the bits
    for (char c : binaryStr.toCharArray()) {
        // If '1', append '0'; if '0', append '1'
        flippedBinary.append(c == '1' ? '0' : '1');
    }
    
    // Convert the flipped binary string back to an integer
    return Integer.parseInt(flippedBinary.toString(), 2);
        
    }
}