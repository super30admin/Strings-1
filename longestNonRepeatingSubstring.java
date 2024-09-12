// Time Complexity : O(n) where n is the length of the string
// Space Complexity : O(n) to store elements in the map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Sliding window solution

class longestNonRepeatingSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) return s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int slow = 0, fast = 0, max = 0;
        while (fast < s.length()) {
            char c = s.charAt(fast);
            if (map.containsKey(c)) {
                slow = Math.max(slow, map.get(c) + 1);    
            }
            map.put(c, fast);
            int len = fast - slow + 1;
            max = Math.max(max, len);
            fast++;
        }
        return max;
    }
}