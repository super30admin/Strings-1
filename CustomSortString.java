/* 
Time Complexity: O(n + m) 
   - n = length of s (to build frequency map), m = length of order (to reorder characters).

Space Complexity: O(1)
   - Frequency map has at most 26 entries since only lowercase letters are involved.

Did this code successfully run on Leetcode: Yes
*/

// Approach:
// - Build a frequency map of characters in s.
// - Traverse the order string, and for each character that appears in s, append it to the result according to its frequency, then remove it from the map.
// - After processing order, append any leftover characters from the map in arbitrary order.
// - This ensures the relative order follows 'order' for those characters, and the rest remain as-is.

import java.util.HashMap;

public class CustomSortString {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>(); //freq map

        for(char c : s.toCharArray()){ //build freq map for s
            map.put(c, map.getOrDefault(c, 0)+ 1);
        }

        StringBuilder result = new StringBuilder();
        for(char c : order.toCharArray()){ // iterate over order array and check freq in map
            if(map.containsKey(c)){
                int freq = map.get(c);
                for(int k = 0; k < freq; k++){
                    result.append(c);
                }
                map.remove(c);
            }
        }

        for(char c : map.keySet()){ // If there's any char left in map, append it to the res
            int freq = map.get(c);
            for(int k = 0; k < freq; k++){
                result.append(c);
            }
        }

        return result.toString();
    }
}
