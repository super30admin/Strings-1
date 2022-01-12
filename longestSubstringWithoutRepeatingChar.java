// Time Complexity = O(n)
// Space Complexity = O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
// This is solved using sliding window protocol approach
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max=0, slow=0;

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(map.containsKey(ch)) {
                // Move slow pointer to the ch index when the char is repeated and hence a part of the map
                // and only if its in the forward direction, otherwise keep where it was
                slow = Math.max(map.get(ch), slow);
            }

            // check max everytime
            max = Math.max(max, i-slow+1);

            // for every fast pointer i value, update the map
            map.put(ch, i + 1);
        }

        return max;
    }
}