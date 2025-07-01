//Time Complexity : O(n)
// Space Complexity : O(n)
// n = length of s 
/*Approach: The approach to custom sorting a string based on the order of characters in another string involves using a HashMap to count 
the frequency of each character in the string to be sorted. We then use a StringBuilder to construct the result string by appending 
characters in the order specified by the 'order' string, ensuring each character appears as many times as it occurs in the original string. 
After processing the characters in 'order', we append any remaining characters from the original string that were not in 'order', 
maintaining their original frequency. This ensures the final string is sorted according to the custom order while preserving the 
frequency of all characters.
 */
class Solution {
    public String customSortString(String order, String s) {
        // If either string is empty, return an empty string
        if (order.length() < 1 || s.length() < 1) return new String();
        
        // Create a HashMap to store the frequency of each character in string s
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Initialize the character count if not already present
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            // Increment the character count
            map.put(c, map.get(c) + 1);
        }
        
        // StringBuilder to build the result string
        StringBuilder sb = new StringBuilder();
        
        // Append characters in the order specified by the 'order' string
        for (int j = 0; j < order.length(); j++) {
            char c = order.charAt(j);
            if (map.containsKey(c)) {
                int freq = map.get(c);
                // Append the character 'freq' times
                for (int k = 0; k < freq; k++) {
                    sb.append(c);
                }
                // Remove the character from the map once processed
                map.remove(c);
            }
        }
        
        // Append remaining characters that were not in 'order'
        if (!map.isEmpty()) {
            for (char ch : map.keySet()) {
                int cnt = map.get(ch);
                for (int k = 0; k < cnt; k++) {
                    sb.append(ch);
                }
            }
        }
        
        // Return the final sorted string
        return sb.toString();
    }
}
