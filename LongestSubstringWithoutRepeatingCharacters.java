// Time Complexity : O(n)
// Space Complexity : O(1), worst case set can contain 26 alphabet
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We use 2 pointers with a sliding window approach to have right pointer move fast and left pointer move slow.
If the set doesnt contain the incoming letter, then we simply add it and keep track of max length of the window
so far. But, if the incoming character already exists in the set, then we need to move our slow/left pointer
until to the point where we find that duplicating character again and get it removed from the set.this way the
window size also changes and final maxLen value gives us the longest string that exists with no repeating characters.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int left = 0, maxLen = 0;

        for(int right = 0 ; right < s.length() ; right++) {
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}