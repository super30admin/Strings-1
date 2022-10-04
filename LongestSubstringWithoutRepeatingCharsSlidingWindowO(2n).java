// Time complexity: O(2n) which is O(n). One n for the fast pointer, and the other n is for the slow pointer, as when we find a repeated character, we move the slow pointer ahead one by one and remove the char from the set until we escape the repeated character

// Space complexity: O(n)

// Approach: Sliding window. We take two pointers, slow and fast. We keep adding the character at the fast index to the set until we find a repeated char (already previously added in set). At that point, we keep remove the characters at slow pointer from the set one by one until we escape the repeated character. So basically we are initally increasing the window to find the longest substring and then when we get a repeated character, we shrink the window until we escape the repeated character and then we continue growing the window from there. Our maximum window is the max length.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int longestLength = 0;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int slow = 0;
        int fast = 1;
        while (fast < s.length()) {
            if (set.contains(s.charAt(fast))) {
                while (s.charAt(slow) != s.charAt(fast)) {
                    set.remove(s.charAt(slow));
                    slow++;
                }
                set.remove(s.charAt(slow));
                slow++;
            }
            set.add(s.charAt(fast));
            longestLength = Math.max(longestLength, fast-slow+1);
            fast++;
        }
        return longestLength;
    }
}