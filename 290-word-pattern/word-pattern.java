class Solution {
    public boolean wordPattern(String s, String ss) {




// Using 1 HashMap: single Pass

// Initialize a HashMap to store the mapping of characters to words
        HashMap<Character, String> a = new HashMap<>();
        
        // Split the input string `ss` by spaces to get individual words
        String[] split_string = ss.split(" ");
        
        // If the length of the pattern `s` is not equal to the number of words, return false
        if (s.length() != split_string.length) {
            return false;
        }
        
        // Iterate through each character in the pattern `s` and the corresponding word in `split_string`
        for (int i = 0; i < s.length(); i++) {
            char patternChar = s.charAt(i);
            String word = split_string[i];
            
            // Check if the pattern character already has a mapping
            if (a.containsKey(patternChar)) {
                // If the current word does not match the mapped word, return false
                if (!a.get(patternChar).equals(word)) {
                    return false;
                }
            }
            else
            {
// If the word is already mapped to another pattern character return false
// the pattern char is not present in map,but the corresponding word is already in map which shows it is mapped with some other character previously. so dont add it.               
                if(a.containsValue(word))
                {
                        return false; 
                }
            }
                // Add the unique mapping of the pattern character to the word
                a.put(patternChar, word);
            }
        
        
        // If all mappings are consistent, return true
        return true;
    }
}







// Using Arrays : 

/*
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

*/


// Using two HashMaps :

/*

HashMap<Character,String> pw = new HashMap<>(); // pattern to word

HashMap<String,Character> wp = new HashMap<>(); // word to pattern


String arr[]= s.split(" ");

if(arr.length!=pattern.length())
return false;

    for(int i = 0;i<pattern.length();i++)
    {
        char p = pattern.charAt(i);

        String word = arr[i];

        if(pw.containsKey(p)) // if key present
        {
// if the pattern character encountered doesnt match the same word            
            if(!pw.get(p).equals(word)) 
                return false;

        }
        else

        pw.put(p,word); // pattern to word mapping

// if word is present in map but mapped to different pattern character
        if(wp.containsKey(word)) 
        {
            if(wp.get(word)!=p)
            {
                return false;
            }

        }
        else
        {
            wp.put(word,p); // word to character of pattern matching
        }

    }
    
    return true; //pattern matches for all other cases
}

}

*/


// Using HashMap and HashSet :
/*

 // Initialize a HashMap to store the mapping of characters to words
        HashMap<Character, String> charToWord = new HashMap<>();
        // Initialize a HashSet to store the words that have been mapped
        HashSet<String> mappedWords = new HashSet<>();
        
        // Split the input string `s` by spaces to get individual words
        String[] words = s.split(" ", -1);
        
        // If the length of the pattern `pattern` is not equal to the number of words, return false
        if (pattern.length() != words.length) {
            return false;
        }
        
        // Iterate through each character in the pattern `pattern` and the corresponding word in `words`
        for (int i = 0; i < pattern.length(); i++) {
            char patternChar = pattern.charAt(i);
            String word = words[i];
            
            // Check if the pattern character already has a mapping
            if (charToWord.containsKey(patternChar)) {
                // If the current word does not match the mapped word, return false
                if (!charToWord.get(patternChar).equals(word)) {
                    return false;
                }
            } else {
                // Ensure no two characters map to the same word
                if (mappedWords.contains(word)) {
                    return false; // Word already mapped to another character
                }
                // Add the mapping of the pattern character to the word
                charToWord.put(patternChar, word);
                // Add the word to the set of mapped words
                mappedWords.add(word);
            }
        }
        
        // If all mappings are consistent, return true
        return true;
    }
}
*/