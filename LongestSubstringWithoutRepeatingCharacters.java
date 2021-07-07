// Time Complexity : O(n) n-> length of string s
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : 
// Two-pointer approach. Both pointers will be initialized to 0 and then the window will be created by counting in the unique characters.
// Whenever a new character is found, it is added to the set and pointer j is incremeneted.
// Whenever a repeat character is found, it is removed from the set and pointer i is incremented.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int i = 0, j = 0; // two pointers
        int max = 0;
        Set<Character> set = new HashSet<>();
        while(j < s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                max = Math.max(max, set.size());
                j++;
            }
            else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}

