// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

// Approach : I used a hashmap to store the last seen index of every character and I iterate over the string - If I have seen this before and it is a part of my current sliding window (the index was after the start) - I update my start to be the index after this so I do not include both, else I simply calculate the length and compare with max length.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c) && map.get(c) >= start) start = map.get(c) + 1;
            int currLen = end - start + 1; 
            maxLen = Math.max(maxLen, currLen);
            map.put(c, end);
        }
        return maxLen;
    }
}
