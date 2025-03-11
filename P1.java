/*
Time Complexity (TC):
O(n + m) where n is the length of string S and m is the length of string T. This is because:
We iterate through T to build the frequency map (O(m)).
We iterate through S and process characters in T (O(n)).
We iterate through the remaining characters in T to append them (O(m)).

Space Complexity (SC):
O(m) where m is the length of string T. This is because the frequency map stores each unique character in T.

Code Explanation (In 3 Lines):
The code counts the frequency of each character in T and then appends characters to the result sb following the custom order specified in S.
Characters in S are appended first in their given order, and then the remaining characters from T (not in S) are appended at the end.
This ensures that the characters are sorted according to S with the remaining characters in arbitrary order.
 */


 class Solution {

    public String customSortString(String S, String T) {
 
        StringBuilder sb = new StringBuilder();  // StringBuilder to efficiently build the result string
 
        Map<Character, Integer> map = new HashMap<>();  // HashMap to store frequency of each character in T
 
        // Compute the frequency map of characters in T
        for (Character ch : T.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);  // Increment the count of each character in T
        }
 
        // Process characters in S and append them in the custom order
        for (Character ch : S.toCharArray()) {
            int count = map.getOrDefault(ch, 0);  // Get the frequency of the character in T
            while (count > 0) {
                sb.append(ch);  // Append the character to the result string as many times as it occurs
                count--;  // Decrease the frequency count
            }
            map.remove(ch);  // Remove the character from the map since it's processed
        }
 
        // Process the remaining characters in T that are not in S and append them at the end
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character ch = entry.getKey();  // Get the character
            int count = entry.getValue();  // Get the frequency of the character
            while (count > 0) {
                sb.append(ch);  // Append the character to the result string
                count--;  // Decrease the frequency count
            }
        }
 
        return sb.toString();  // Return the final sorted string
    }
 
 }