class Solution {
    public String frequencySort(String s) {


// TreeMap :
/*
  // Step 1: Count the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Use TreeMap with reverse order to sort by frequency in descending order
        TreeMap<Integer, List<Character>> sortedMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            int freq = entry.getValue();
            char ch = entry.getKey();
            sortedMap.computeIfAbsent(freq, k -> new ArrayList<>()).add(ch);
        }

        // Step 3: Build the result string
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, List<Character>> entry : sortedMap.entrySet()) {
            int freq = entry.getKey();
            for (char c : entry.getValue()) {
                for (int i = 0; i < freq; i++) {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }





*/
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

// HashMap : 
// Step 1: Create a HashMap to store character frequency
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        // Step 2: Count frequency of each character
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        // Step 3: Sort the entries based on frequency
    List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
      //  Collections.sort(entryList, (a, b) -> b.getValue() - a.getValue());

        entryList.sort((entry1,entry2)-> entry2.getValue()-entry1.getValue());
        
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

