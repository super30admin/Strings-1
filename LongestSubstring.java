// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int ans = 0;

        if (s == null || s.length() == 0) return ans;

        // Create Map to track the uniqueness in Substring
        Map<Character, Integer> map = new HashMap<>();

        // Sliding window
        int i = 0;
        int j = 0;

        while(j < s.length()) {

            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // If map.msize() == window size
            // Every char in substring is unique
            if (map.size() == j - i + 1) {

                ans = Math.max(ans, j - i + 1);
                j++;
            } else if (map.size() < j - i + 1) {
                // Now something is duplicated --
                // while duplicates are there - slide the window
                while (map.size() < j - i + 1) {

                    char d = s.charAt(i);

                    int f = map.get(d);

                    if(f == 1) map.remove(d);
                    else map.put(d, map.get(d) - 1);

                    i++;
                }

                j++;

            }


        }

        return ans;
    }
}