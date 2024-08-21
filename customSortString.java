import java.util.HashMap;

class Solution {
    /**
     * Time Complexity: O(n + m), where n is the length of string 's' and m is the length of string 'order'.
     * Space Complexity: O(n), where n is the number of unique characters in string 's'.
     */
    public String customSortString(String order, String s) {
        // Initialize a StringBuilder to store the final sorted result
        StringBuilder result = new StringBuilder();
        
        // Create a HashMap to count the occurrences of each character in the string 's'
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Populate the HashMap with character counts from string 's'
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // Iterate through the characters in the 'order' string
        for (char c : order.toCharArray()) {
            // Check if the current character is present in the HashMap
            if (map.containsKey(c)) {
                // Append the character to 'result' as many times as it appears in 's'
                while (map.get(c) != 0) {
                    result.append(c);
                    // Decrease the count of the character in the HashMap
                    map.put(c, map.get(c) - 1);
                }
                // Remove the character from the HashMap as it's fully processed
                map.remove(c);
            }
        }
        
        // Append any remaining characters from the HashMap that were not in 'order'
        for (char c : map.keySet()) {
            // Append the character to 'result' as many times as it appears in 's'
            while (map.get(c) != 0) {
                result.append(c);
                // Decrease the count of the character in the HashMap
                map.put(c, map.get(c) - 1);
            }
        }
        
        // Convert the StringBuilder to a String and return the result
        return result.toString();
    }
}
