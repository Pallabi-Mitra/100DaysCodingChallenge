class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {

      // Split the sentence into words
    String[] words = sentence.split(" ");
    StringBuilder result = new StringBuilder();

    // Iterate through each word in the sentence
    for (String word : words) {
        String replacement = word;
        // Check each root in the dictionary
        for (String root : dictionary) {
            if (word.startsWith(root)) {
                // Replace with the shortest root
                if (root.length() < replacement.length()) {
                    replacement = root;
                }
            }
        }
        result.append(replacement).append(" ");
    }

    // Remove the trailing space and return the result
    return result.toString().trim();
        
    }
}