/*
Problem - Longest Substring without Repeat Characters
Approach - We slide a window and keep adding characters until we hit a duplicate.
Then we move the slow pointer ahead to remove that duplicate.
We keep checking the window size to track the longest unique substring.
Time Complexity - O(n)
Space Complexity - O(1)
 */
import java.util.HashSet;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int slow = 0; // pointer to start
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                while(s.charAt(slow) != c) {
                    set.remove(s.charAt(slow));
                    slow++; // until we found the character
                }
                slow++; // moving the pointer again to start the window from next charcter
            }
            set.add(c);
            max = Math.max(max, i-slow+1); // window size to track the length
        }
        return max;
    }
}
