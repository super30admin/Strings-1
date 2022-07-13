// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//3. Longest Substring Without Repeating Characters
//https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    // HashMap Approach
    // time: O(n) where n is the length of the string
    // space: O(1)
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        // slow and fast pointer and hashmap to store chars and its indices
        int slow = 0;
        int fast = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;

        // iterate through the string by moving the fast pointer

        // check if the char is present in the string

        // if it is not, add it

        // if it is, update slow pointer to max(its hashmap index+1, where the slow
        // pointer is currently at), and update the repeating char's index in the
        // hashmap. Size of the substring before this repeating char was encountered
        // will be subtraction of their indices (diff of current repeating char-1 and
        // where the slow pointer was at)

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (!map.containsKey(c)) {
                map.put(c, i);
                if (maxLen < (fast - slow + 1))
                    maxLen = fast - slow + 1;

            } else {

                if (s.charAt(slow) != c && slow >= map.get(c))
                    if (maxLen < (fast - slow + 1))
                        maxLen = fast - slow + 1;

                slow = Math.max(slow, map.get(c) + 1);
                map.put(c, i);

            }
            fast++;
        }

        return maxLen;

    }
}