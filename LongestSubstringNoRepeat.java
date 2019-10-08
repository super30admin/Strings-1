/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Idea:
 * 
 * Naive Brute Force: 
 * Time Complexity: O(n^3); generate all n^2 substrings and O(n) work for verifying the same. 
 * Space Complexity: O(k); k is distinct character count, use HashSet to hold them.
 * 
 * Optimized Brute Force: 
 * Time Complexity: O(n^2): track the count on the fly, verification step reduces to O(1). 
 * Space Complexity: O(k); k is distinct character count, use HashSet to hold them.
 * 
 * Sliding Window Technique: 
 * Idea is to use start and end that is current window of focus. 
 * The end pointer would be putting characters into the set, making sure that 
 * duplicates are removed before we put it. The start pointer would be removing 
 * characters and incrementing until charAt[end] can be inserted in the
 * set. Track the global maxima on the fly.
 * 
 * Time Complexity: O(n) 
 * Space Complexity: O(k); k is distinct character count, use HashSet to hold them.
 * 
 * Runtime: 10 ms, faster than 43.60% of Java online submissions for Longest
 * Substring Without Repeating Characters. 
 * Memory Usage: 36.5 MB, less than 99.76% of Java online submissions for Longest 
 * Substring Without Repeating Characters.
 * 
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0;
        Set<Character> set = new HashSet<>();
        int maxLen = 0;

        while (start < s.length() && end < s.length()) {
            Character ch = s.charAt(end);
            // remove char from set, until s[end] can be inserted.
            while (set.contains(ch)) {
                set.remove(s.charAt(start++));
            }
            // insert s[end]
            set.add(ch);
            maxLen = Math.max(maxLen, set.size());
            
            end++;
        }
        return maxLen;
    }
}