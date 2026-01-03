// https://leetcode.com/problems/custom-sort-string/description/

import java.util.HashMap;

/**
 * Approach: Frequency map is used to store frequencies of each letter in string s.
 * Then we iterate through each character in the order string and
 * by find the frequency of that character in frequency map,
 * we add it to the sorted string those many number of times.
 * Once the character is added to the sorted string, we remove its entry in the frequencyMap.
 * At the end we iterate through the remaining entries in the frequencyMap and add those to the sorted string.
 * We are using StringBuilder to build the sorted string to optimize space used.
*/
// m = order.length(); n = s.length();
// TC: n + m + n ~= O(m + n);
// SC: 26 entries for frequency map + n for string builder ~= O(n)
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        StringBuilder sortedString = new StringBuilder();
        // Populate frequency map for characters in s
        for (char ch: s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        // Iterate through characters in order and populate sortedString
        for (char ch: order.toCharArray()) {
            if (frequencyMap.containsKey(ch)) {
                int count = frequencyMap.get(ch); // number of times ch is found in s.
                while (count -- != 0) {
                    sortedString.append(ch);
                }
                // Remove the ch's entry in frequencyMap after adding it to the sortedString
                frequencyMap.remove(ch);
            }
        }
        // Add remaining characters of frequencyMap to sortedString
        for (char ch: frequencyMap.keySet()) {
            int count = frequencyMap.get(ch); // number of times ch is found in s.
            while (count -- != 0) {
                sortedString.append(ch);
            }
        }
        // Convert StringBuilder to String and return
        return sortedString.toString();
    }
}