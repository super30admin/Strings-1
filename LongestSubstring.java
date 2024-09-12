/*Time Complexity : O(n)
Space Complexity : O(n) 
Did it run on LeetCode : Yes.
Any problems : No.
*/


class Solution {
public int lengthOfLongestSubstring(String s) {
    int i = 0;  // Create a slow pointer i that will be used to remove. We need to remove elements from hashset because the longest substring can occur anywhere.
    
    j = 0;      // Create a fast pointer j that will traverse the String.
    max = 0;    // Create a counter variable for max length of longest substring.   
    Set<Character> set = new HashSet<>(); // Create a hashset.
    
    while (j < s.length()) {     // Traverse every element of String S.
        if (!set.contains(s.charAt(j))) {   // If element is not in HashSet.
            set.add(s.charAt(j++)); // Add to hashset.
            max = Math.max(max, set.size());
        } else {
            set.remove(s.charAt(i++));  // If element already present, remove.
        }
    }
    
    return max; // Return max count.
}
}