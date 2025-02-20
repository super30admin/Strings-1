// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // TC = O(n), SC = O(n)
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int start = 0, max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                start = Math.max(start, map.get(c)); // max b/w these as if we move backward, index provided by map, then we might have duplicate char again
            }
            max = Math.max(max, i -start + 1);
            map.put(c, i + 1); // putting index+1 as start starts from i+1 to prevent duplicate (ie the repeating character)
        }
        return max;
    }
}