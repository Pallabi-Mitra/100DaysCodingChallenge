class Solution {
    public String frequencySort(String s) {

/*
    TreeMap<Integer,Character> mpp = new TreeMap<>(Collections.reverseOrder());

        for(char c : s.toCharArray())
        {
            int freq=0;

            for(Map.Entry<Integer,Character> entries : mpp.entrySet())
            {
                if(entries.getValue()==c)
                {
                    freq = entries.getKey();
                    freq++;
                    
                }
            }
            
            mpp.put(freq,c);

        }

        StringBuilder result = new StringBuilder();

         for (Map.Entry<Integer,Character> entry : mpp.entrySet()) {
            int f = entry.getKey();
            char c = entry.getValue();
            for (int i = 0; i < f; i++) {
                result.append(c);
            }
        }


        return result.toString();
        
        }
}
*/
 // Step 1: Count the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Convert the HashMap entries to a list and sort it by frequency in descending order
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort((entry1, entry2) -> entry2.getValue() - entry1.getValue());

        // Step 3: Build the result string
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entryList) {
            char c = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
/*
// Step 1: Create a HashMap to store character frequency
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        // Step 2: Count frequency of each character
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        // Step 3: Sort the entries based on frequency
    List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        Collections.sort(entryList, (a, b) -> b.getValue() - a.getValue());
        
        // Step 4: Construct the result string
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entryList) {
            char c = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}

*/