class Solution {
    public boolean wordPattern(String pattern, String s) {


// Split the input string `s` by spaces
    String[] words = s.split(" ");
    
    // If the number of words is not equal to the length of the pattern, return false
    if (words.length != pattern.length()) {
        return false;
    }

    // Arrays to store mappings from pattern to words and words to pattern
    String[] charToWord = new String[26]; // Since pattern consists of lowercase letters only
    Map<String, Character> wordToChar = new HashMap<>();

    // Iterate over the pattern and the corresponding words
    for (int i = 0; i < pattern.length(); i++) {
        char c = pattern.charAt(i);
        String word = words[i];
        
        // Check mapping from pattern to words
        if (charToWord[c - 'a'] == null) {
            charToWord[c - 'a'] = word;
        } else if (!charToWord[c - 'a'].equals(word)) {
            return false; // Inconsistent mapping
        }

        // Check mapping from words to pattern
        if (wordToChar.containsKey(word)) {
            if (wordToChar.get(word) != c) {
                return false; // Inconsistent mapping
            }
        } else {
            wordToChar.put(word, c);
        }
    }

    return true; // Pattern matches
}
}