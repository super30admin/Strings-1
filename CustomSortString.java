// ============================ Approach- 1 Using hashmap =================================
/*
Time: O(S+T)
space: O(T) (hashmap and string builder)

Approach:
========
1. Store characters in T in frequency map 
2. Use string builder to update characters of T in the order of S
3. Characters in T which are not in S are added in the end
*/
class Solution {
    public String customSortString(String S, String T) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char c: T.toCharArray()) {
           freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);  // store T characters and count in hashmap
        }

         //use string builder to update characters of T in the order of S
        StringBuilder sb = new StringBuilder(); 
        for(char c: S.toCharArray()) {             
            while(freqMap.containsKey(c)) {
                int val = freqMap.get(c);
                if(val == 0)
                    freqMap.remove(c);
                else {
                    sb.append(c);
                    freqMap.put(c, val - 1);
                }
            }
        }
        // characters in T which are not in S added in the end
        for(Map.Entry<Character, Integer> entry: freqMap.entrySet()) {
            int val = entry.getValue();
            while(val != 0) {
                sb.append(entry.getKey());
                val--;
            }
        }
        return sb.toString();
    }
}


// ============================ Approach- 2 Using hashtable =================================

class Solution {
    public String customSortString(String S, String T) {
        int[] counts = new int[26];
        for(char c: T.toCharArray()) {
            counts[c-'a']++;
        }
        
         //use string builder to update characters of T in the order of S
        StringBuilder sb = new StringBuilder(); 
        for(char c: S.toCharArray()) {
           while(counts[c-'a'] > 0) {
               sb.append(c);
               counts[c-'a']--;
           }
        }
        

        // characters in T which are not in S added in the end
        for(char c = 'a'; c <= 'z'; c++)  {
            while(counts[c-'a'] > 0) {
                sb.append(c);
                counts[c-'a']--;
            }
        }
            
        return sb.toString();
    }
}