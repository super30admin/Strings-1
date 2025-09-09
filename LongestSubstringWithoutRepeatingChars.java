/* 
Time Complexity: O(n)
   - Each character is visited at most twice (once by i, once by slow pointer).

Space Complexity: O(1)
   - The set stores at most 128 ASCII characters (constant size).

Did this code successfully run on Leetcode: Yes
*/

// Approach:
// - Use the sliding window technique with two pointers (slow, i) and a HashSet to track unique characters.
// - For each character s[i]:
//     * If it's already in the set, shrink the window from the left (increment slow) until the duplicate is removed.
//     * Add s[i] to the set and update the maximum window length.
// - Return the maximum length after traversing the string.


import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int slow = 0;
        int max = 0;

        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);

            if(set.contains(c)){
                while(s.charAt(slow) != c){
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }
            set.add(c);
            max = Math.max(max, i - slow + 1);
        }
        return max;
    }
}
