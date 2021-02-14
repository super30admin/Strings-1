// Time Complexity : O(n)
// Space Complexity : O(n) for map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Your code here along with comments explaining your approach
//Sliding window approach

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;

        int startPtr = 0;
        HashMap<Character,Integer> map = new HashMap();

        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            if(map.containsKey(c)) {
                startPtr = Math.max(startPtr, map.get(c));
            }
            map.put(c,i+1);
            max = Math.max(max, i - startPtr + 1);

        }

        return max;
    }
}
